/*
    Swing resources:

    Components overview:
    https://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html

    Popup dialogs:
    https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
 */

package com.birdbraintechnologies.bluebirdconnector;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.media.*;
import javafx.embed.swing.JFXPanel;
//import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import javafx.stage.Screen;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
//import javax.media.Manager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GUI extends JFrame {

    static final Logger LOG = LoggerFactory.getLogger(GUI.class);

    private static GUI sharedInstance;

    private RobotManager robotManager = RobotManager.getSharedInstance();
    private boolean autoconnectRequested = false;

    private Translations tr = Translations.getSharedInstance();

    private int screen_width = 800;
    private int screen_height = 700;

    private JPanel bannerPanel;
    private JLabel wifiLabel;
    private JLabel wifiIndicator;
    private JLabel bleLabel;
    private JLabel bleIndicator;
    private ImageIcon redDot;
    private ImageIcon greenDot;
    private Boolean bleAvailable = null;
    private Boolean wifiAvailable = null;
    private boolean scanning = false;

    private JPanel findPanel;
    private JButton findBn;
    private JList foundRobots;
    private DefaultListModel discoveryList; //Could create a custom list model

    private JPanel resultsPanel;

    //Colors
    private Color bbtBlue = new Color(8, 155, 171);
    private Color neonCarot = new Color(255, 152, 34);
    private Color seance = new Color(137, 17, 153);

    //Fonts
    private Font bnFont = new Font("Helvetica Neue", Font.BOLD, 18);
    private Font titleFont = new Font("Helvetica Neue", Font.BOLD, 30);

    private GUI() {

    }

    public static GUI getSharedInstance() {
        if (sharedInstance == null) {
            sharedInstance = new GUI();
        }
        return sharedInstance;
    }

    public void initialize() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BlueBird Connector");

        tr.setLanguage(null); //Set to the system language

        Dimension screenBounds = Toolkit.getDefaultToolkit().getScreenSize();
        if (screen_width > screenBounds.getWidth())
            screen_width = (int)screenBounds.getWidth() - 50;
        if (screen_height > screenBounds.getHeight())
            screen_height = (int)screenBounds.getHeight() - 50;

        SpringLayout bannerLayout = new SpringLayout();
        bannerPanel = new JPanel(bannerLayout);
        bannerPanel.setBackground(Color.white);
        bannerPanel.setPreferredSize(new Dimension(screen_width, 100));

        ImageIcon circuitry = createImageIcon("/images/pattern-blue-circuitry.png", "", 600, -1);
        JLabel circuitryLabel = new JLabel(circuitry);
        bannerPanel.add(circuitryLabel);
        bannerLayout.putConstraint(SpringLayout.NORTH, circuitryLabel, 0, SpringLayout.NORTH, bannerPanel);
        bannerLayout.putConstraint(SpringLayout.WEST, circuitryLabel, 0, SpringLayout.WEST, bannerPanel);
        JLabel circuitryLabel2 = new JLabel(circuitry);
        bannerPanel.add(circuitryLabel2);
        bannerLayout.putConstraint(SpringLayout.NORTH, circuitryLabel2, 0, SpringLayout.NORTH, bannerPanel);
        bannerLayout.putConstraint(SpringLayout.WEST, circuitryLabel2, 600, SpringLayout.WEST, bannerPanel);

        ImageIcon bbtLogo = createImageIcon("/images/birdbrain-logo-h.png", "BirdBrain Technologies", -1, 80);
        JLabel logoLabel = new JLabel(bbtLogo);
        bannerPanel.add(logoLabel);
        bannerLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, logoLabel, 0, SpringLayout.HORIZONTAL_CENTER, bannerPanel);
        bannerLayout.putConstraint(SpringLayout.VERTICAL_CENTER, logoLabel, 0, SpringLayout.VERTICAL_CENTER, bannerPanel);

        ImageIcon wifiIcon = createImageIcon("/images/wifi-solid.png", "Wifi", 0, 0);
        wifiLabel = new JLabel(wifiIcon);
        wifiLabel.getAccessibleContext().setAccessibleDescription("wifi is disabled");
        wifiLabel.setFocusable(true);
        bannerPanel.add(wifiLabel);
        bannerLayout.putConstraint(SpringLayout.NORTH, wifiLabel, 5, SpringLayout.NORTH, bannerPanel);

        redDot = createImageIcon("/images/circle-solid-red.png", "not connected", 0, 0);
        greenDot = createImageIcon("/images/circle-solid-green.png", "connected", 0, 0);
        wifiIndicator = new JLabel(redDot);
        bannerPanel.add(wifiIndicator);
        bannerLayout.putConstraint(SpringLayout.NORTH, wifiIndicator, 35, SpringLayout.NORTH, bannerPanel);
        bannerLayout.putConstraint(SpringLayout.EAST, wifiLabel, 0, SpringLayout.WEST, wifiIndicator);
        bannerLayout.putConstraint(SpringLayout.EAST, wifiIndicator, -5, SpringLayout.EAST, bannerPanel);
        setIndicator(true, internetIsAvailable()); //TODO: update this sometime!

        ImageIcon bleIcon = createImageIcon("/images/bluetooth-brands-solid.png", "Bluetooth", 0, 0);
        bleLabel = new JLabel(bleIcon);
        bleLabel.getAccessibleContext().setAccessibleDescription("bluetooth is disabled");
        bleLabel.setFocusable(true);
        bannerPanel.add(bleLabel);
        bannerLayout.putConstraint(SpringLayout.SOUTH, bleLabel, -5, SpringLayout.SOUTH, bannerPanel);

        bleIndicator = new JLabel(redDot);
        bannerPanel.add(bleIndicator);
        bannerLayout.putConstraint(SpringLayout.SOUTH, bleIndicator, -5, SpringLayout.SOUTH, bannerPanel);
        bannerLayout.putConstraint(SpringLayout.EAST, bleLabel, 0, SpringLayout.WEST, bleIndicator);
        bannerLayout.putConstraint(SpringLayout.EAST, bleIndicator, -10, SpringLayout.EAST, bannerPanel);
        if (bleAvailable != null) { //May be set before gui initialized
            setIndicator(false, bleAvailable);
        }

        SpringLayout findLayout = new SpringLayout();
        findPanel = new JPanel(findLayout);
        findPanel.setBackground(bbtBlue);
        //findPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        findPanel.setPreferredSize(new Dimension(screen_width, 100));

        findBn = new JButton();
        findBn.setBackground(neonCarot);
        findBn.setFont(bnFont); // NOI18N
        findBn.setForeground(Color.white);
        findBn.setText(tr.translate(scanning ? "finding_robots" : "find_robots"));
        findBn.addActionListener(this::findBnActionPerformed);
        findPanel.add(findBn);
        findLayout.putConstraint(SpringLayout.NORTH, findBn, 20, SpringLayout.NORTH, findPanel);
        findLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, findBn, 0, SpringLayout.HORIZONTAL_CENTER, findPanel);

        discoveryList = new DefaultListModel();
        foundRobots = new JList(discoveryList); //can also set list with foundRobots.setModel(discoveryList)
        foundRobots.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        foundRobots.setLayoutOrientation(JList.VERTICAL); //Vertical is default
        FoundRobotCell cell = new FoundRobotCell();
        foundRobots.setCellRenderer(cell);
        //findPanel.add(foundRobots);

        resultsPanel = new JPanel();
        resultsPanel.setBackground(seance);
        resultsPanel.setPreferredSize(new Dimension(screen_width, screen_height-200));

        JButton snapBn = new JButton(tr.translate("start_programming"));
        snapBn.setBackground(neonCarot);
        snapBn.addActionListener(this::snapBnActionPerformed);
        resultsPanel.add(snapBn);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        contentPane.add(bannerPanel);
        contentPane.add(findPanel);
        contentPane.add(resultsPanel);

        pack();
        this.setVisible(true);

    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    private static ImageIcon createImageIcon(String path,
                                               String description, int width, int height) {
        java.net.URL imgURL = GUI.class.getResource(path);
        if (imgURL != null) {
            System.out.println("IMAGE URL!!!! " + imgURL.toString());
            ImageIcon imageIcon = new ImageIcon(imgURL, description);
            if (width != 0 && height != 0) { //getScaledInstance throws IllegalArgumentException if w or h is 0
                Image image = imageIcon.getImage(); // transform it
                //if either width or height are negative, uses other value and maintains aspect ratio
                Image newImg = image.getScaledInstance(width, height,  Image.SCALE_SMOOTH); // scale it the smooth way
                imageIcon = new ImageIcon(newImg);  // transform it back
            }
            imageIcon.getAccessibleContext().setAccessibleDescription(description);
            return imageIcon;
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public void showErrorDialog(String title, String header, String message, boolean abort) {
        //This dialog is blocking. Executing continues when dialog is dismissed.
        JOptionPane.showMessageDialog(this, header + "\n" + message, title, JOptionPane.ERROR_MESSAGE);

        if (abort)
            System.exit(1);
    }

    private void findBnActionPerformed(ActionEvent evt) {
        System.out.println("FIND ROBOTS clicked!");

        //showErrorDialog("find robots clicked", "I don't know what this is for", "it was clicked", true);

        if (bleAvailable) {
            if (scanning) {
                findBn.setText(tr.translate("find_robots"));
                robotManager.stopDiscovery();
            } else {
                findBn.setText(tr.translate("finding_robots"));
                robotManager.startDiscovery();
            }

        } else {
            Modal modal = new Modal(this, "Plug_in_Dongle.mp4");
        }
    }

    private void snapBnActionPerformed(ActionEvent evt) {
        String projectName = "";
        Robot[] connectedDeviceList = robotManager.getConnectedRobotList();
        if (connectedDeviceList.length == 1) {
            if (connectedDeviceList[0].name.startsWith("FN")) {
                projectName = "FinchSingleDeviceStarterProject";
            } else {
                projectName = "HummingbirdSingleDeviceStarterProject";
            }
        } else {
            if (allRobotsAreFinches(connectedDeviceList)) {
                projectName = "FinchMultiDeviceStarterProject";
            } else if (noRobotsAreFinches(connectedDeviceList)) {
                projectName = "HummingbirdMultiDeviceStarterProject";
            } else {
                projectName = "MixedMultiDeviceStarterProject";
            }
        }


        String lang = tr.getCurrentLanguage();

        boolean shouldOpenOnline = true;//TODO: use slider results

        String urlString = "http://127.0.0.1:30061/snap.html#open:/snapProjects/" + projectName + ".xml&editMode&noRun&lang=" + lang;
        if (wifiAvailable && shouldOpenOnline) {
            urlString = "https://snap.berkeley.edu/snapsource/snap.html#present:Username=birdbraintech&ProjectName=" + projectName + "&editMode&noRun&lang=" + lang;
        }

        LOG.info("Opening " + urlString);
        String osName = System.getProperty("os.name");
        //Snap is best used in chrome. Try to open chrome first.
        try {
            final String dir = System.getProperty("user.dir");
            LOG.debug("OS = {}; user dir = {}" , osName, dir);

            if (osName.contains("Win")) {
                Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome \"" + urlString + "\""});
            } else { //Linux
                Runtime.getRuntime().exec(new String[] { "chromium-browser", urlString });
            }
        } catch (Exception exception) {
            LOG.info("Could not open url in chrome. Trying the default browser. Exception: " + exception.getMessage());
            try {
                if (osName.contains("Win")) {
                    Desktop.getDesktop().browse(new URL(urlString).toURI());
                } else { //Linux
                    LOG.debug("using xdg-open");
                    Runtime.getRuntime().exec(new String[] { "xdg-open", urlString });
                }
            } catch (Exception e) {
                LOG.error("Failed to open url {}", urlString);
                e.printStackTrace();
            }
        }
    }

    private boolean allRobotsAreFinches(Robot[] connectedDeviceList) {
        boolean onlyFinches = true;
        for (int i = 0; i < connectedDeviceList.length; i++) {
            if (!connectedDeviceList[i].name.startsWith("FN")) {
                onlyFinches = false;
            }
        }
        return onlyFinches;
    }
    private boolean noRobotsAreFinches(Robot[] connectedDeviceList) {
        boolean noFinches = true;
        for (int i = 0; i < connectedDeviceList.length; i++) {
            if (connectedDeviceList[i].name.startsWith("FN")) {
                noFinches = false;
            }
        }
        return noFinches;
    }

    private static boolean internetIsAvailable() {
        try {
            final URL url = new URL("https://snap.berkeley.edu/");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            return true;
        } catch (MalformedURLException e) {
            //throw new RuntimeException(e);
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    public void setIndicator(Boolean wifi, Boolean connected) {
        ImageIcon icon = redDot;
        String connTxt = "disabled";
        if (connected) {
            icon = greenDot;
            connTxt = "enabled";
        }

        if (wifi) {
            wifiAvailable = connected;
            wifiIndicator.setIcon(icon);
            wifiLabel.getAccessibleContext().setAccessibleDescription("wifi is " + connTxt);
        } else {
            bleAvailable = connected;
            if (bleIndicator != null) { //ble may be set before gui setup
                bleIndicator.setIcon(icon);
                bleLabel.getAccessibleContext().setAccessibleDescription("bluetooth is " + connTxt);
            }
        }

    }

    public void setScanStatus(Boolean isScanning) {
        scanning = isScanning;
        if (findBn == null) { return; }
        if (scanning) {
            findBn.setText(tr.translate("finding_robots"));
        } else {
            findBn.setText(tr.translate("find_robots"));
        }
    }

    public void receiveScanResponse(String name, JSONObject discoveryInfo){
        if (robotManager.autoConnect && !autoconnectRequested) {
            autoconnectRequested = true;
            requestConnection(name);
        }
        discoveryInfo.put("fancyName", FancyNames.getDeviceFancyName(name));
        //Remove first 2 characters so that the name can change while advertising...
        //availableRobots.put(name.substring(2), discoveryInfo.toString());
        LOG.debug("blePacketReceived():discovery: {} {}", name, discoveryInfo.toString());

        //updateGuiDeviceList();
        robotManager.receiveScanResponse(name);
    }

    public void requestConnection(String nameToConnect) {
        LOG.debug("Requesting connection to " + nameToConnect);
        //availableRobots.remove(nameToConnect.substring(2));
        //updateGuiDeviceList();
        robotManager.connectToRobot(nameToConnect);
    }

    private class FoundRobotCell extends JLabel implements ListCellRenderer {

        public FoundRobotCell() {
            setOpaque(true);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

            //Get the selected index. (The index parameter isn't
            //always valid, so just use the value.)
            int selectedIndex = ((Integer)value).intValue();

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }


            return this;
        }
    }

    private class Modal extends JDialog {
        public Modal(JFrame frame, String title) {
            super(frame);

            String video = null;
            if (title.endsWith(".mp4")) {
                video = title;
                switch (video){
                    case "HummBit_Calibration.mp4":
                    case "MicroBit_Calibration.mp4":
                    case "Finch_Calibration.mp4":
                    case "HummBit_V2_Calibration.mp4":
                    case "MicroBit_V2_Calibration.mp4":
                    case "Finch_V2_Calibration.mp4":
                        title = tr.translate("CompassCalibrate");
                        break;
                    case "NativeMacBLEon.mp4":
                    case "Plug_in_Dongle.mp4":
                        title = tr.translate("Connection_Failure");
                        break;
                    default:
                        LOG.error("unsupported video " + video);
                }
            }

            JPanel titlePanel = new JPanel();
            JLabel titleLabel = new JLabel(title);
            titleLabel.setFont(titleFont);
            titleLabel.setForeground(Color.white);
            titlePanel.add(titleLabel);
            titlePanel.setBackground(seance);
            titlePanel.setPreferredSize(new Dimension(screen_width * 3/4, screen_height * 1/8));

            JPanel contentPanel = new JPanel();
            if (video != null) {
                /*
                //create the media player with the media url
                Player mediaPlayer = Manager.createRealizedPlayer("/videos/" + video);
                //get components for video and playback controls
                Component video = mediaPlayer.getVisualComponent();
                */
                try {

                    final JFXPanel VFXPanel = new JFXPanel();

                    java.net.URL imgURL = GUI.class.getResource("/videos/" + video);
                    System.out.println(imgURL.toString());
                    //File video_source = new File(imgURL.toString());
                    Media m = new Media(imgURL.toURI().toString()); //new Media(video_source.toURI().toString());
                    MediaPlayer player = new MediaPlayer(m);
                    MediaView viewer = new MediaView(player);

                    StackPane root = new StackPane();
                    Scene scene = new Scene(root);

                    // center video position
                    javafx.geometry.Rectangle2D screen = Screen.getPrimary().getVisualBounds();
                    viewer.setX((screen.getWidth() - contentPanel.getWidth()) / 2);
                    viewer.setY((screen.getHeight() - contentPanel.getHeight()) / 2);

                    // resize video based on screen size
                    /*DoubleProperty width = viewer.fitWidthProperty();
                    DoubleProperty height = viewer.fitHeightProperty();
                    width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
                    height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));*/
                    viewer.setPreserveRatio(true);
                    viewer.setFitHeight(screen_height/2);

                    // add video to stackpane
                    root.getChildren().add(viewer);

                    VFXPanel.setScene(scene);
                    //player.play();
                    player.setAutoPlay(true);
                    //player.setOnEndOfMedia(player::play);
                    player.setCycleCount(MediaPlayer.INDEFINITE);
                    contentPanel.setLayout(new BorderLayout());
                    contentPanel.add(VFXPanel, BorderLayout.CENTER);
                    contentPanel.setPreferredSize(new Dimension(screen_width * 3/4, screen_height/2));
                } catch (Exception e) {
                    LOG.error("Exception playing video: " + e.getMessage());
                }
            }

            Container contentPane = getContentPane();
            contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
            contentPane.add(titlePanel);
            contentPane.add(contentPanel);

            this.pack();

            this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            this.setLocationRelativeTo(frame);
            this.setAlwaysOnTop(true);
            this.addWindowFocusListener(new WindowFocusListener() {

                public void windowGainedFocus(WindowEvent e) {
                    //do nothing
                }

                public void windowLostFocus(WindowEvent e) {
                    if (SwingUtilities.isDescendingFrom(e.getOppositeWindow(), Modal.this)) {
                        return;
                    }
                    Modal.this.setVisible(false);
                }

            });

            this.setVisible(true);

        }
    }
}

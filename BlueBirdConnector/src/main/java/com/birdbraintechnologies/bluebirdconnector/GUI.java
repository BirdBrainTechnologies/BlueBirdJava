/*
    Swing resources:

    Components overview:
    https://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html

    Popup dialogs:
    https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
 */

package com.birdbraintechnologies.bluebirdconnector;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GUI extends JFrame {

    static final Logger LOG = LoggerFactory.getLogger(GUI.class);

    private static GUI sharedInstance;

    private RobotManager robotManager = RobotManager.getSharedInstance();
    private boolean autoconnectRequested = false;

    private int screen_width = 800;
    private int screen_height = 700;

    private JPanel bannerPanel;
    private JLabel wifiIndicator;
    private JLabel bleIndicator;
    private ImageIcon redDot;
    private ImageIcon greenDot;

    private JPanel findPanel;
    private JButton findBn;
    private JList foundRobots;
    private DefaultListModel discoveryList; //Could create a custom list model

    private JPanel resultsPanel;

    //Colors
    private Color bbtBlue = new Color(8, 155, 171);
    private Color neonCarot = new Color(255, 152, 34);
    private Color seance = new Color(137, 17, 153);

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

        Dimension screenBounds = Toolkit.getDefaultToolkit().getScreenSize();
        if (screen_width > screenBounds.getWidth())
            screen_width = (int)screenBounds.getWidth() - 50;
        if (screen_height > screenBounds.getHeight())
            screen_height = (int)screenBounds.getHeight() - 50;

        bannerPanel = new JPanel();
        bannerPanel.setBackground(Color.white);
        bannerPanel.setPreferredSize(new Dimension(screen_width, 100));

        ImageIcon bbtLogo = createImageIcon("/images/birdbrain-logo-h.png", "BirdBrain Technologies", 365, 100);
        JLabel logoLabel = new JLabel(bbtLogo);
        bannerPanel.add(logoLabel);

        ImageIcon wifiIcon = createImageIcon("/images/wifi-solid.png", "Wifi", 0, 0);
        JLabel wifiLabel = new JLabel(wifiIcon);
        bannerPanel.add(wifiLabel);

        redDot = createImageIcon("/images/circle-solid-red.png", "not connected", 0, 0);
        greenDot = createImageIcon("/images/circle-solid-green.png", "connected", 0, 0);
        wifiIndicator = new JLabel(redDot);
        bannerPanel.add(wifiIndicator);
        setIndicator(true, internetIsAvailable()); //TODO: update this sometime!

        ImageIcon bleIcon = createImageIcon("/images/bluetooth-brands-solid.png", "Bluetooth", 0, 0);
        JLabel bleLabel = new JLabel(bleIcon);
        bannerPanel.add(bleLabel);

        bleIndicator = new JLabel(redDot);
        bannerPanel.add(bleIndicator);

        findPanel = new JPanel();
        findPanel.setBackground(bbtBlue);
        findPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        findPanel.setPreferredSize(new java.awt.Dimension(screen_width, 100));

        findBn = new JButton();
        findBn.setOpaque(true);
        findBn.setBackground(neonCarot);
        findBn.setFont(new Font("Helvetica Neue", Font.BOLD, 18)); // NOI18N
        findBn.setForeground(Color.white);
        findBn.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        findBn.setText("FIND ROBOTS");
        findBn.setAlignmentX(Component.CENTER_ALIGNMENT);
        findBn.setAlignmentY(Component.CENTER_ALIGNMENT);
        findBn.setPreferredSize(new Dimension(150, 30));
        findBn.addActionListener(this::findBnActionPerformed);
        findPanel.add(findBn);

        discoveryList = new DefaultListModel();
        foundRobots = new JList(discoveryList); //can also set list with foundRobots.setModel(discoveryList)
        foundRobots.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        foundRobots.setLayoutOrientation(JList.VERTICAL); //Vertical is default
        FoundRobotCell cell = new FoundRobotCell();
        foundRobots.setCellRenderer(cell);
        findPanel.add(foundRobots);

        resultsPanel = new JPanel();
        resultsPanel.setBackground(seance);
        resultsPanel.setPreferredSize(new Dimension(screen_width, screen_height-200));

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
            ImageIcon imageIcon = new ImageIcon(imgURL, description);
            if (width != 0) {
                Image image = imageIcon.getImage(); // transform it
                Image newimg = image.getScaledInstance(width, height,  Image.SCALE_SMOOTH); // scale it the smooth way
                imageIcon = new ImageIcon(newimg);  // transform it back
            }
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

    private void findBnActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("FIND ROBOTS clicked!");
        showErrorDialog("find robots clicked", "I don't know what this is for", "it was clicked", true);
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
        if (connected) {
            icon = greenDot;
        }

        if (wifi) {
            wifiIndicator.setIcon(icon);
        } else {
            bleIndicator.setIcon(icon);
        }
    }

    public void setScanStatus(Boolean scanning) {

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

}

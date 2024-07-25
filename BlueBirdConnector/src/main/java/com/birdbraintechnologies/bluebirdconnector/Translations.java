package com.birdbraintechnologies.bluebirdconnector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Handle translations of all text visible in the interface.
 */

public class Translations {

    static final Logger LOG = LoggerFactory.getLogger(Translations.class);

    private static Translations sharedInstance;

    //Table of all keys in all supported languages.
    private Map<String, Map> fullTranslationTable = new HashMap();
    private Map<String, String> translationTable;
    private String currentLanguage;

    public static Translations getSharedInstance() {
        if (sharedInstance == null) {
            sharedInstance = new Translations();
        }
        return sharedInstance;
    }

    private Translations() {
        //TODO: Add accessibility descriptions
        Map<String, String> en = new HashMap<>();
        en.put("say_this", "Say This");
        en.put("find_robots", "Find Robots");
        en.put("finding_robots", "Finding Robots");
        en.put("connected", "Connected");
        en.put("start_programming", "Start Programming");
        en.put("device_disconnected", "Device (A or B) Disconnected");
        en.put("reconnecting", "Reconnecting");
        en.put("connect_dongle", "Connect Bluetooth Dongle");
        en.put("CompassCalibrate", "Calibrate Compass");
        en.put("Update_firmware", "Update Firmware");
        en.put("No_Ble", "No Bluetooth Detected");
        en.put("Ble_Required", "This app requires Bluetooth.");
        en.put("Connection_Failure", "Connection Failure");
        fullTranslationTable.put("en", en);

        Map<String, String> ko = new HashMap<>();
        ko.put("say_this", "(Slot 1 = 안녕!) 말하기");
        ko.put("find_robots", "로봇 찾기");
        ko.put("finding_robots", "로봇 찾는 중");
        ko.put("connected", "연결 완료");
        ko.put("start_programming", "프로그래밍 시작하기");
        ko.put("device_disconnected", "기기 (A 또는 B) 연결 끊김");
        ko.put("reconnecting", "다시 연결 중");
        ko.put("connect_dongle", "블루투스 동글 연결하기");
        ko.put("CompassCalibrate", "나침반 센서 보정");
        ko.put("Update_firmware", "펌웨어 업데이트");
        ko.put("No_Ble", "블루투스 장치를 찾을 수 없습니다.");
        ko.put("Ble_Required", "이 앱은 블루투스 통신이 필요합니다.");
        ko.put("Connection_Failure", "연결 실패");
        fullTranslationTable.put("ko", ko);

        Map<String, String> de = new HashMap<>();
        de.put("say_this", "Sage");
        de.put("find_robots", "Suche Roboter");
        de.put("finding_robots", "Suche Roboter");
        de.put("connected", "Verbunden");
        de.put("start_programming", "Beginne Programmierung");
        de.put("device_disconnected", "Gerät (A oder B) getrennt");
        de.put("reconnecting", "Wiederverbinden");
        de.put("connect_dongle", "Verbinde Bluetooth Dongle");
        de.put("CompassCalibrate", "Kompass kalibrieren");
        de.put("Update_firmware", "Firmware Updaten");
        de.put("No_Ble", "Kein Bluetooth gefunden");
        de.put("Ble_Required", "Diese App benötigt Bluetooth");
        de.put("Connection_Failure", "Verbindung fehlgeschlagen");
        fullTranslationTable.put("de", de);

        Map<String, String> pt = new HashMap<>();
        pt.put("say_this", "Diga Isso");
        pt.put("find_robots", "Encontre Robôs");
        pt.put("finding_robots", "Encontrando Robôs");
        pt.put("connected", "Conectado");
        pt.put("start_programming", "Iniciar a programação");
        pt.put("device_disconnected", "Dispositivo (A ou B) Desconectado");
        pt.put("reconnecting", "Reconectando");
        pt.put("connect_dongle", "Conecte o Dongle Bluetooth");
        pt.put("CompassCalibrate", "Calibrar Bússola");
        pt.put("Update_firmware", "Atualizar Firmware");
        pt.put("No_Ble", "Nenhum Bluetooth Detectado");
        pt.put("Ble_Required", "Este aplicativo requer Bluetooth.");
        pt.put("Connection_Failure", "Falha na Conexão");
        fullTranslationTable.put("pt", pt);

        Map<String, String> fr = new HashMap<>();
        fr.put("say_this", "Dites ceci");
        fr.put("find_robots", "Trouvez des robots");
        fr.put("finding_robots", "Trouver des robots");
        fr.put("connected", "Connecté");
        fr.put("start_programming", "Lancez la programmation");
        fr.put("device_disconnected", "Le Périphérique (A ou B) déconnecté");
        fr.put("reconnecting", "Reconnecter");
        fr.put("connect_dongle", "Connectez le bluetooth dongle");
        fr.put("CompassCalibrate", "Calibrer le compas");
        fr.put("Update_firmware", "Mettez à Jour le Firmware");
        fr.put("No_Ble", "Aucun Bluetooth détecté");
        fr.put("Ble_Required", "Cette application nécessite Bluetooth.");
        fr.put("Connection_Failure", "Échec de connexion");
        fullTranslationTable.put("fr", fr);

        Map<String, String> nl = new HashMap<>();
        nl.put("say_this", "Zeg Dit");
        nl.put("find_robots", "Zoek Naar Robots");
        nl.put("finding_robots", "Zoeken Naar Robots");
        nl.put("connected", "Verbonden");
        nl.put("start_programming", "Begin met Programmeren");
        nl.put("device_disconnected", "Apparaat (A of B) Losgekoppeld");
        nl.put("reconnecting", "Verbinding Opniew Maken");
        nl.put("connect_dongle", "Sluit Bluetooth-dongle aan");
        nl.put("CompassCalibrate", "Kompas Kalibreren");
        nl.put("Update_firmware", "Update Firmware");
        nl.put("No_Ble", "Bluetooth niet gedetecteerd");
        nl.put("Ble_Required", "Deze app vereist Bluetooth.");
        nl.put("Connection_Failure", "Verbindingsfout");
        fullTranslationTable.put("nl", nl);

        Map<String, String> zh_Hans = new HashMap<>();
        zh_Hans.put("say_this", "说");
        zh_Hans.put("find_robots", "寻找机器人");
        zh_Hans.put("finding_robots", "寻找机器人中");
        zh_Hans.put("connected", "已连接");
        zh_Hans.put("start_programming", "开始编程");
        zh_Hans.put("device_disconnected", "设备（A或B）已断开连接");
        zh_Hans.put("reconnecting", "重新连接");
        zh_Hans.put("connect_dongle", "连接蓝牙");
        zh_Hans.put("CompassCalibrate", "校准指南针");
        zh_Hans.put("Update_firmware", "更新固件");
        zh_Hans.put("No_Ble", "未检测到蓝牙。");
        zh_Hans.put("Ble_Required", "该设备需要链接蓝牙。");
        zh_Hans.put("Connection_Failure", "连接失败");
        fullTranslationTable.put("zh_Hans", zh_Hans);

        Map<String, String> zh_Hant = new HashMap<>();
        zh_Hant.put("say_this", "說");
        zh_Hant.put("find_robots", "尋找機器人");
        zh_Hant.put("finding_robots", "尋找機器人中");
        zh_Hant.put("connected", "已連接");
        zh_Hant.put("start_programming", "開始編程");
        zh_Hant.put("device_disconnected", "設備（A或B）已斷開連接");
        zh_Hant.put("reconnecting", "重新連接");
        zh_Hant.put("connect_dongle", "連接藍牙");
        zh_Hant.put("CompassCalibrate", "校準指南針");
        zh_Hant.put("Update_firmware", "更新固件");
        zh_Hant.put("No_Ble", "未能檢測到藍牙");
        zh_Hant.put("Ble_Required", "此應用程式需要藍牙");
        zh_Hant.put("Connection_Failure", "連接失敗");
        fullTranslationTable.put("zh_Hant", zh_Hant);

        Map<String, String> ar = new HashMap<>();
        ar.put("say_this", "قل هذا");
        ar.put("find_robots", "ابحث عن روبوت");
        ar.put("finding_robots", "إيجاد روبوت");
        ar.put("connected", "متصل");
        ar.put("start_programming", "ابدأ البرمجة");
        ar.put("device_disconnected", "الجهاز أ أو ب غير متصل");
        ar.put("reconnecting", "إعادة الاتصال");
        ar.put("connect_dongle", "اتصال عن طريق البلوتوث");
        ar.put("CompassCalibrate", "معايرة البوصلة");
        ar.put("Update_firmware", "تحديث البرامج الثابتة");
        ar.put("No_Ble", "No Bluetooth Detected");
        ar.put("Ble_Required", "This app requires Bluetooth.");
        ar.put("Connection_Failure", "فشل الاتصال");
        fullTranslationTable.put("ar", ar);

        Map<String, String> da = new HashMap<>();
        da.put("say_this", "Sig dette");
        da.put("find_robots", "Find robotter");
        da.put("finding_robots", "Finder robotter");
        da.put("connected", "Forbundet");
        da.put("start_programming", "Start programmering");
        da.put("device_disconnected", "Forbindelse til enhed (A eller B) er afbrudt");
        da.put("reconnecting", "Opretter forbindelse igen");
        da.put("connect_dongle", "Forbind bluetooth dongle");
        da.put("CompassCalibrate", "Kalibrér kompas");
        da.put("Update_firmware", "Opdatér Firmware");
        da.put("No_Ble", "No Bluetooth Detected");
        da.put("Ble_Required", "This app requires Bluetooth.");
        da.put("Connection_Failure", "Forbindelse mislykket");
        fullTranslationTable.put("da", da);

        Map<String, String> he = new HashMap<>();
        he.put("say_this", "להגיד");
        he.put("find_robots", "למצוא רובוטים");
        he.put("finding_robots", "מחפשים רובוטים");
        he.put("connected", "מחובר");
        he.put("start_programming", "התחל תכנות");
        he.put("device_disconnected", "עתקן ( א או ב) מנותק");
        he.put("reconnecting", "מחברים מחדש");
        he.put("connect_dongle", "מחברים הדונגל לבלוטוס");
        he.put("CompassCalibrate", "כיול מצפן");
        he.put("Update_firmware", "עדכון קשוחה");
        he.put("No_Ble", "לא זוהה Bluetooth");
        he.put("Ble_Required", "אפליקציה זו דורשת Bluetooth.");
        he.put("Connection_Failure", "חיבור נכשל");
        fullTranslationTable.put("he", he);

        Map<String, String> es = new HashMap<>();
        es.put("say_this", "Decir esto");
        es.put("find_robots", "Encontrar robots");
        es.put("finding_robots", "Encontrando robots");
        es.put("connected", "Conectado");
        es.put("start_programming", "Iniciar programacion");
        es.put("device_disconnected", "Dispositivo (A o B) Desconectado");
        es.put("reconnecting", "Reconectando");
        es.put("connect_dongle", "Conectar el dongle del bluethoot");
        es.put("CompassCalibrate", "Calibrar la brujula");
        es.put("Update_firmware", "Actualizar Firmware");
        es.put("No_Ble", "Bluetooth no detectado");
        es.put("Ble_Required", "Esta aplicación requiere Bluetooth.");
        es.put("Connection_Failure", "Coneccion fallada");
        fullTranslationTable.put("es", es);

        Map<String, String> ca = new HashMap<>();
        ca.put("say_this", "Digues això");
        ca.put("find_robots", "Cerca robots");
        ca.put("finding_robots", "Cercant robots");
        ca.put("connected", "Connectat");
        ca.put("start_programming", "Comença a programar");
        ca.put("device_disconnected", "Dispositiu (A o B) desconnectat");
        ca.put("reconnecting", "Reconnectant");
        ca.put("connect_dongle", "Connecta llapis Bluetooth");
        ca.put("CompassCalibrate", "Calibratge de la brúixola");
        ca.put("Update_firmware", "Actualitza el Firmware");
        ca.put("No_Ble", "Bluetooth no detectat");
        ca.put("Ble_Required", "Aquesta aplicació requereix Bluetooth.");
        ca.put("Connection_Failure", "Error de connexió");
        fullTranslationTable.put("ca", ca);

        Map<String, String> fi = new HashMap<>();
        fi.put("say_this", "Sano tämä");
        fi.put("find_robots", "Etsi robotteja");
        fi.put("finding_robots", "Etsii robotteja");
        fi.put("connected", "Yhdistetty");
        fi.put("start_programming", "Aloita ohjelmointi");
        fi.put("device_disconnected", "Yhteys katkennut laitteeseen (A tai B)");
        fi.put("reconnecting", "Yhdistää uudelleen");
        fi.put("connect_dongle", "Yhdistä Bluetooth-palikka");
        fi.put("CompassCalibrate", "Kalibroi kompassi");
        fi.put("Update_firmware", "Päivitä laiteohjelma");
        fi.put("No_Ble", "No Bluetooth Detected");
        fi.put("Ble_Required", "This app requires Bluetooth.");
        fi.put("Connection_Failure", "Virhe yhdistettäessä");
        fullTranslationTable.put("fi", fi);

        Map<String, String> sv = new HashMap<>();
        sv.put("say_this", "Säg detta");
        sv.put("find_robots", "Hitta robotar");
        sv.put("finding_robots", "Hittar robotar");
        sv.put("connected", "Kopplade");
        sv.put("start_programming", "Börja programmera");
        sv.put("device_disconnected", "Enhet (A eller B) frånkopplad");
        sv.put("reconnecting", "Omkopplar");
        sv.put("connect_dongle", "Koppla Bluetooth dosa");
        sv.put("CompassCalibrate", "Kalibrera kompass");
        sv.put("Update_firmware", "Uppdatera Programvara");
        sv.put("No_Ble", "No Bluetooth Detected");
        sv.put("Ble_Required", "This app requires Bluetooth.");
        sv.put("Connection_Failure", "Problem med kopplingen");
        fullTranslationTable.put("sv", sv);
    }


    /**
     * translateStrings - Translate all strings initially present in the UI, if a
     * translation table has been selected.
     */
    /*function translateStrings() {
        if (translationTable == null) { return; }
        // Set up defaults
        $('#findBtnText').text(" " + translationTable["find_robots"]);
        $('#connection-state').html(translationTable["connected"]);
        $('#start_programming').html(translationTable["start_programming"]);
    }*/

    /**
     * setLanguage - Set the app language based on the navigator language. Set to
     * English if the language is not supported. Translate initial strings once set.
     */
    public void setLanguage(String language) {
        if (language == null) {
            //TODO: Test. maybe use Resources.getSystem().getConfiguration().locale.getLanguage();
            language = System.getProperty("user.language");
        }
        LOG.info("setting language = " + language);

        if (language.startsWith("zh")) {
            if (language == "zh-TW") { language = "zh_Hant"; } // Specify trad chinese
            else { language = "zh_Hans"; } // Default to simplified chinese for any other variant
        } else {
            language = language.substring(0, 2); // require the 2 letter code.
        }
        // Convert old code for Hebrew to new
        if (language == "iw") { language = "he"; }

        LOG.info("Language code used: " + language);

        translationTable = fullTranslationTable.get(language);
        if (translationTable == null) {
            LOG.info("Language unsupported. Defaulting to English (en)");
            language = "en";
            translationTable = fullTranslationTable.get(language); // populate the locale phrases
        }

        currentLanguage = language;

        LOG.info("translationTable:");
        LOG.info(translationTable.toString());

        //translateStrings();
    }

    public String translate(String key) {
        return translationTable.get(key);
    }

    public String getCurrentLanguage() {
        return currentLanguage;
    }

}

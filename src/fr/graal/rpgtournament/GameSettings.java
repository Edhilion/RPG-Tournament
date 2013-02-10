package fr.graal.rpgtournament;

import com.trolltech.qt.gui.*;

public class GameSettings extends QDialog {

    Ui_GameSettings ui = new Ui_GameSettings();

    public static void main(String[] args) {
        QApplication.initialize(args);

        GameSettings testGameSettings = new GameSettings();
        testGameSettings.show();

        QApplication.exec();
    }

    public GameSettings() {
        ui.setupUi(this);
    }

    public GameSettings(QWidget parent) {
        super(parent);
        ui.setupUi(this);
    }
}

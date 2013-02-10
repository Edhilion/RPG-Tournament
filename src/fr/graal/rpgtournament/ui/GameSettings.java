package fr.graal.rpgtournament.ui;

import com.trolltech.qt.gui.*;

import fr.graal.rpgtournament.Ui_GameSettings;

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

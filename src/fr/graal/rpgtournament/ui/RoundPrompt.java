package fr.graal.rpgtournament.ui;

import com.trolltech.qt.gui.*;

import fr.graal.rpgtournament.Ui_RoundPrompt;

public class RoundPrompt extends QDialog {

    Ui_RoundPrompt ui = new Ui_RoundPrompt();

    public static void main(String[] args) {
        QApplication.initialize(args);

        RoundPrompt testRoundPrompt = new RoundPrompt();
        testRoundPrompt.show();

        QApplication.exec();
    }

    public RoundPrompt() {
        ui.setupUi(this);
    }

    public RoundPrompt(QWidget parent) {
        super(parent);
        ui.setupUi(this);
    }
    
    }

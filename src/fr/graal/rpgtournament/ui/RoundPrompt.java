package fr.graal.rpgtournament.ui;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QWidget;

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

package fr.graal.rpgtournament;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Vector;

import com.trolltech.qt.gui.*;

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

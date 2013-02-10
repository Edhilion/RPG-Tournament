/********************************************************************************
** Form generated from reading ui file 'RoundPrompt.jui'
**
** Created: dim. 10. févr. 14:35:21 2013
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package fr.graal.rpgtournament.ui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_RoundPrompt implements com.trolltech.qt.QUiForm<QDialog>
{
    public QAction actionPrintFridayTables;
    public QAction actionPrintSaturdayTables;
    public QAction actionPrintSundayTables;
    public QDialogButtonBox buttonBox;
    public QTabWidget roundTabWidget;
    public QWidget tab;
    public QTextBrowser fridayRoundTextBrowser;
    public QWidget tab_2;
    public QTextBrowser saturdayRoundTextBrowser;
    public QWidget tab_3;
    public QTextBrowser sundayRoundTextBrowser;
    public QPushButton printFridayButton;
    public QPushButton printSaturdayButton;
    public QPushButton printSundayButton;

    public Ui_RoundPrompt() { super(); }

    public void setupUi(QDialog RoundPrompt)
    {
        RoundPrompt.setObjectName("RoundPrompt");
        RoundPrompt.resize(new QSize(820, 566).expandedTo(RoundPrompt.minimumSizeHint()));
        actionPrintFridayTables = new QAction(RoundPrompt);
        actionPrintFridayTables.setObjectName("actionPrintFridayTables");
        actionPrintSaturdayTables = new QAction(RoundPrompt);
        actionPrintSaturdayTables.setObjectName("actionPrintSaturdayTables");
        actionPrintSundayTables = new QAction(RoundPrompt);
        actionPrintSundayTables.setObjectName("actionPrintSundayTables");
        buttonBox = new QDialogButtonBox(RoundPrompt);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(470, 530, 341, 31));
        buttonBox.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.TabFocus);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
        roundTabWidget = new QTabWidget(RoundPrompt);
        roundTabWidget.setObjectName("roundTabWidget");
        roundTabWidget.setGeometry(new QRect(10, 10, 801, 511));
        tab = new QWidget();
        tab.setObjectName("tab");
        fridayRoundTextBrowser = new QTextBrowser(tab);
        fridayRoundTextBrowser.setObjectName("fridayRoundTextBrowser");
        fridayRoundTextBrowser.setGeometry(new QRect(10, 10, 781, 461));
        roundTabWidget.addTab(tab, com.trolltech.qt.core.QCoreApplication.translate("RoundPrompt", "Friday", null));
        tab_2 = new QWidget();
        tab_2.setObjectName("tab_2");
        saturdayRoundTextBrowser = new QTextBrowser(tab_2);
        saturdayRoundTextBrowser.setObjectName("saturdayRoundTextBrowser");
        saturdayRoundTextBrowser.setGeometry(new QRect(10, 10, 781, 461));
        roundTabWidget.addTab(tab_2, com.trolltech.qt.core.QCoreApplication.translate("RoundPrompt", "Saturday", null));
        tab_3 = new QWidget();
        tab_3.setObjectName("tab_3");
        sundayRoundTextBrowser = new QTextBrowser(tab_3);
        sundayRoundTextBrowser.setObjectName("sundayRoundTextBrowser");
        sundayRoundTextBrowser.setGeometry(new QRect(10, 10, 781, 461));
        roundTabWidget.addTab(tab_3, com.trolltech.qt.core.QCoreApplication.translate("RoundPrompt", "Sunday", null));
        printFridayButton = new QPushButton(RoundPrompt);
        printFridayButton.setObjectName("printFridayButton");
        printFridayButton.setGeometry(new QRect(10, 530, 81, 23));
        printSaturdayButton = new QPushButton(RoundPrompt);
        printSaturdayButton.setObjectName("printSaturdayButton");
        printSaturdayButton.setGeometry(new QRect(100, 530, 81, 23));
        printSundayButton = new QPushButton(RoundPrompt);
        printSundayButton.setObjectName("printSundayButton");
        printSundayButton.setGeometry(new QRect(194, 530, 81, 23));
        retranslateUi(RoundPrompt);
        buttonBox.accepted.connect(RoundPrompt, "accept()");
        buttonBox.rejected.connect(RoundPrompt, "reject()");
        printFridayButton.released.connect(actionPrintFridayTables, "trigger()");
        printSaturdayButton.released.connect(actionPrintSaturdayTables, "trigger()");
        printSundayButton.released.connect(actionPrintSundayTables, "trigger()");

        roundTabWidget.setCurrentIndex(0);


        RoundPrompt.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog RoundPrompt)
    {
        RoundPrompt.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("RoundPrompt", "Dialog", null));
        actionPrintFridayTables.setText(com.trolltech.qt.core.QCoreApplication.translate("RoundPrompt", "printFridayTables", null));
        actionPrintSaturdayTables.setText(com.trolltech.qt.core.QCoreApplication.translate("RoundPrompt", "printSaturdayTables", null));
        actionPrintSundayTables.setText(com.trolltech.qt.core.QCoreApplication.translate("RoundPrompt", "printSundayTables", null));
        roundTabWidget.setTabText(roundTabWidget.indexOf(tab), com.trolltech.qt.core.QCoreApplication.translate("RoundPrompt", "Friday", null));
        roundTabWidget.setTabText(roundTabWidget.indexOf(tab_2), com.trolltech.qt.core.QCoreApplication.translate("RoundPrompt", "Saturday", null));
        roundTabWidget.setTabText(roundTabWidget.indexOf(tab_3), com.trolltech.qt.core.QCoreApplication.translate("RoundPrompt", "Sunday", null));
        printFridayButton.setText(com.trolltech.qt.core.QCoreApplication.translate("RoundPrompt", "Print Friday", null));
        printSaturdayButton.setText(com.trolltech.qt.core.QCoreApplication.translate("RoundPrompt", "Print Saturday", null));
        printSundayButton.setText(com.trolltech.qt.core.QCoreApplication.translate("RoundPrompt", "Print Sunday", null));
    } // retranslateUi

}


/********************************************************************************
** Form generated from reading ui file 'ResultsPrompt.jui'
**
** Created: dim. 10. févr. 16:47:40 2013
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package fr.graal.rpgtournament.ui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_ResultsPrompt implements com.trolltech.qt.QUiForm<QDialog>
{
    public QAction actionPrintGMTables;
    public QAction actionPrintPCTables;
    public QDialogButtonBox buttonBox;
    public QTabWidget resultsTabWidget;
    public QWidget tab;
    public QTextBrowser gmResultsTextBrowser;
    public QWidget tab_2;
    public QTextBrowser pcResultsTextBrowser;
    public QPushButton printGMButton;
    public QPushButton printPCButton;

    public Ui_ResultsPrompt() { super(); }

    public void setupUi(QDialog ResultsPrompt)
    {
        ResultsPrompt.setObjectName("ResultsPrompt");
        ResultsPrompt.resize(new QSize(820, 566).expandedTo(ResultsPrompt.minimumSizeHint()));
        actionPrintGMTables = new QAction(ResultsPrompt);
        actionPrintGMTables.setObjectName("actionPrintGMTables");
        actionPrintPCTables = new QAction(ResultsPrompt);
        actionPrintPCTables.setObjectName("actionPrintPCTables");
        buttonBox = new QDialogButtonBox(ResultsPrompt);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(470, 530, 341, 31));
        buttonBox.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.TabFocus);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
        resultsTabWidget = new QTabWidget(ResultsPrompt);
        resultsTabWidget.setObjectName("resultsTabWidget");
        resultsTabWidget.setGeometry(new QRect(10, 10, 801, 511));
        tab = new QWidget();
        tab.setObjectName("tab");
        gmResultsTextBrowser = new QTextBrowser(tab);
        gmResultsTextBrowser.setObjectName("gmResultsTextBrowser");
        gmResultsTextBrowser.setGeometry(new QRect(10, 10, 781, 461));
        resultsTabWidget.addTab(tab, com.trolltech.qt.core.QCoreApplication.translate("ResultsPrompt", "GM", null));
        tab_2 = new QWidget();
        tab_2.setObjectName("tab_2");
        pcResultsTextBrowser = new QTextBrowser(tab_2);
        pcResultsTextBrowser.setObjectName("pcResultsTextBrowser");
        pcResultsTextBrowser.setGeometry(new QRect(10, 10, 781, 461));
        resultsTabWidget.addTab(tab_2, com.trolltech.qt.core.QCoreApplication.translate("ResultsPrompt", "PC", null));
        printGMButton = new QPushButton(ResultsPrompt);
        printGMButton.setObjectName("printGMButton");
        printGMButton.setGeometry(new QRect(10, 530, 81, 23));
        printPCButton = new QPushButton(ResultsPrompt);
        printPCButton.setObjectName("printPCButton");
        printPCButton.setGeometry(new QRect(100, 530, 81, 23));
        retranslateUi(ResultsPrompt);
        buttonBox.accepted.connect(ResultsPrompt, "accept()");
        buttonBox.rejected.connect(ResultsPrompt, "reject()");
        printGMButton.released.connect(actionPrintGMTables, "trigger()");
        printPCButton.released.connect(actionPrintPCTables, "trigger()");

        resultsTabWidget.setCurrentIndex(0);


        ResultsPrompt.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog ResultsPrompt)
    {
        ResultsPrompt.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("ResultsPrompt", "Dialog", null));
        actionPrintGMTables.setText(com.trolltech.qt.core.QCoreApplication.translate("ResultsPrompt", "printGMTables", null));
        actionPrintPCTables.setText(com.trolltech.qt.core.QCoreApplication.translate("ResultsPrompt", "printPCTables", null));
        resultsTabWidget.setTabText(resultsTabWidget.indexOf(tab), com.trolltech.qt.core.QCoreApplication.translate("ResultsPrompt", "GM", null));
        resultsTabWidget.setTabText(resultsTabWidget.indexOf(tab_2), com.trolltech.qt.core.QCoreApplication.translate("ResultsPrompt", "PC", null));
        printGMButton.setText(com.trolltech.qt.core.QCoreApplication.translate("ResultsPrompt", "Print GM", null));
        printPCButton.setText(com.trolltech.qt.core.QCoreApplication.translate("ResultsPrompt", "Print PC", null));
    } // retranslateUi

}


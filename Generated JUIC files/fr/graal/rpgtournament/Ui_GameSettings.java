/********************************************************************************
** Form generated from reading ui file 'GameSettings.jui'
**
** Created: dim. 10. févr. 15:08:31 2013
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package fr.graal.rpgtournament;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_GameSettings implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox buttonBox;
    public QGroupBox groupBox_Required_2;
    public QGridLayout gridLayout;
    public QLabel label_Name_2;
    public QLineEdit lineEdit_gameName;
    public QLabel label_Email_5;
    public QVBoxLayout verticalLayout;
    public QCheckBox checkBox_Day1;
    public QCheckBox checkBox_Day2;
    public QCheckBox checkBox_Day3;
    public QLineEdit lineEdit_gameIndex;
    public QLabel label_Name_3;

    public Ui_GameSettings() { super(); }

    public void setupUi(QDialog GameSettings)
    {
        GameSettings.setObjectName("GameSettings");
        GameSettings.resize(new QSize(400, 224).expandedTo(GameSettings.minimumSizeHint()));
        buttonBox = new QDialogButtonBox(GameSettings);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(40, 180, 341, 31));
        buttonBox.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.TabFocus);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
        groupBox_Required_2 = new QGroupBox(GameSettings);
        groupBox_Required_2.setObjectName("groupBox_Required_2");
        groupBox_Required_2.setGeometry(new QRect(10, 10, 371, 161));
        gridLayout = new QGridLayout(groupBox_Required_2);
        gridLayout.setObjectName("gridLayout");
        label_Name_2 = new QLabel(groupBox_Required_2);
        label_Name_2.setObjectName("label_Name_2");

        gridLayout.addWidget(label_Name_2, 0, 0, 1, 1);

        lineEdit_gameName = new QLineEdit(groupBox_Required_2);
        lineEdit_gameName.setObjectName("lineEdit_gameName");

        gridLayout.addWidget(lineEdit_gameName, 0, 1, 1, 1);

        label_Email_5 = new QLabel(groupBox_Required_2);
        label_Email_5.setObjectName("label_Email_5");

        gridLayout.addWidget(label_Email_5, 2, 0, 1, 1);

        verticalLayout = new QVBoxLayout();
        verticalLayout.setObjectName("verticalLayout");
        checkBox_Day1 = new QCheckBox(groupBox_Required_2);
        checkBox_Day1.setObjectName("checkBox_Day1");

        verticalLayout.addWidget(checkBox_Day1);

        checkBox_Day2 = new QCheckBox(groupBox_Required_2);
        checkBox_Day2.setObjectName("checkBox_Day2");

        verticalLayout.addWidget(checkBox_Day2);

        checkBox_Day3 = new QCheckBox(groupBox_Required_2);
        checkBox_Day3.setObjectName("checkBox_Day3");

        verticalLayout.addWidget(checkBox_Day3);


        gridLayout.addLayout(verticalLayout, 2, 1, 1, 1);

        lineEdit_gameIndex = new QLineEdit(groupBox_Required_2);
        lineEdit_gameIndex.setObjectName("lineEdit_gameIndex");

        gridLayout.addWidget(lineEdit_gameIndex, 1, 1, 1, 1);

        label_Name_3 = new QLabel(groupBox_Required_2);
        label_Name_3.setObjectName("label_Name_3");

        gridLayout.addWidget(label_Name_3, 1, 0, 1, 1);

        QWidget.setTabOrder(lineEdit_gameName, lineEdit_gameIndex);
        QWidget.setTabOrder(lineEdit_gameIndex, checkBox_Day1);
        QWidget.setTabOrder(checkBox_Day1, checkBox_Day2);
        QWidget.setTabOrder(checkBox_Day2, checkBox_Day3);
        QWidget.setTabOrder(checkBox_Day3, buttonBox);
        retranslateUi(GameSettings);
        buttonBox.accepted.connect(GameSettings, "accept()");
        buttonBox.rejected.connect(GameSettings, "reject()");

        GameSettings.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog GameSettings)
    {
        GameSettings.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("GameSettings", "Dialog", null));
        groupBox_Required_2.setTitle(com.trolltech.qt.core.QCoreApplication.translate("GameSettings", "Game Informations", null));
        label_Name_2.setText(com.trolltech.qt.core.QCoreApplication.translate("GameSettings", "Name", null));
        label_Email_5.setText(com.trolltech.qt.core.QCoreApplication.translate("GameSettings", "Days", null));
        checkBox_Day1.setText(com.trolltech.qt.core.QCoreApplication.translate("GameSettings", "Friday", null));
        checkBox_Day2.setText(com.trolltech.qt.core.QCoreApplication.translate("GameSettings", "Saturday", null));
        checkBox_Day3.setText(com.trolltech.qt.core.QCoreApplication.translate("GameSettings", "Sunday", null));
        label_Name_3.setText(com.trolltech.qt.core.QCoreApplication.translate("GameSettings", "Position", null));
    } // retranslateUi

}


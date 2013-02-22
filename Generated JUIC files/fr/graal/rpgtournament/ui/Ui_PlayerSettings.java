/********************************************************************************
** Form generated from reading ui file 'PlayersSettings.jui'
**
** Created: ven. 22. févr. 22:13:34 2013
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package fr.graal.rpgtournament.ui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_PlayerSettings implements com.trolltech.qt.QUiForm<QDialog>
{
    public QAction actionAddPlayer;
    public QGridLayout gridLayout_3;
    public QGroupBox groupBox_Required;
    public QGridLayout gridLayout;
    public QLabel label_Name;
    public QLineEdit lineEdit_LastName;
    public QLabel label_Email;
    public QLineEdit lineEdit_FirstName;
    public QLabel label_Email_2;
    public QLineEdit lineEdit_Pseudo;
    public QLabel label_Email_3;
    public QDateEdit dateEdit_Born;
    public QLabel label_Email_4;
    public QSpacerItem horizontalSpacer;
    public QLabel label_Email_9;
    public QRadioButton radioButton;
    public QRadioButton radioButton_2;
    public QSpacerItem horizontalSpacer_2;
    public QSpacerItem horizontalSpacer_3;
    public QCheckBox checkBox_Paid;
    public QGroupBox groupBox;
    public QGridLayout gridLayout_8;
    public QTabWidget gamesTabWidget;
    public QWidget tab;
    public QGridLayout gridLayout_6;
    public QTableWidget tableWidget0;
    public QWidget tab_2;
    public QGridLayout gridLayout_7;
    public QTableWidget tableWidget1;
    public QWidget tab_3;
    public QGridLayout gridLayout_5;
    public QTableWidget tableWidget2;
    public QGroupBox groupBox_Required_2;
    public QGridLayout gridLayout_2;
    public QLabel label_Name_2;
    public QLineEdit lineEdit_Address;
    public QLabel label_Email_5;
    public QLineEdit lineEdit_PostalCode;
    public QLabel label_Email_6;
    public QLineEdit lineEdit_City;
    public QLabel label_Email_7;
    public QLineEdit lineEdit_Email;
    public QLabel label_Email_8;
    public QLineEdit lineEdit_Phone;
    public QCheckBox checkBox_Spam;
    public QGroupBox groupBox_Optional;
    public QGridLayout gridLayout_4;
    public QLabel label_What;
    public QLineEdit lineEdit_YearsOfRPG;
    public QLabel label_Profession;
    public QComboBox comboBox_Club;
    public QDialogButtonBox buttonBox;
    public QFrame line;
    public QDateEdit dateEdit;
    public QLabel label;
    public QSpacerItem horizontalSpacer_4;

    public Ui_PlayerSettings() { super(); }

    public void setupUi(QDialog PlayerSettings)
    {
        PlayerSettings.setObjectName("PlayerSettings");
        PlayerSettings.resize(new QSize(789, 490).expandedTo(PlayerSettings.minimumSizeHint()));
        PlayerSettings.setModal(true);
        actionAddPlayer = new QAction(PlayerSettings);
        actionAddPlayer.setObjectName("actionAddPlayer");
        gridLayout_3 = new QGridLayout(PlayerSettings);
        gridLayout_3.setObjectName("gridLayout_3");
        groupBox_Required = new QGroupBox(PlayerSettings);
        groupBox_Required.setObjectName("groupBox_Required");
        gridLayout = new QGridLayout(groupBox_Required);
        gridLayout.setObjectName("gridLayout");
        label_Name = new QLabel(groupBox_Required);
        label_Name.setObjectName("label_Name");

        gridLayout.addWidget(label_Name, 0, 0, 1, 1);

        lineEdit_LastName = new QLineEdit(groupBox_Required);
        lineEdit_LastName.setObjectName("lineEdit_LastName");

        gridLayout.addWidget(lineEdit_LastName, 0, 1, 1, 6);

        label_Email = new QLabel(groupBox_Required);
        label_Email.setObjectName("label_Email");

        gridLayout.addWidget(label_Email, 1, 0, 1, 1);

        lineEdit_FirstName = new QLineEdit(groupBox_Required);
        lineEdit_FirstName.setObjectName("lineEdit_FirstName");

        gridLayout.addWidget(lineEdit_FirstName, 1, 1, 1, 6);

        label_Email_2 = new QLabel(groupBox_Required);
        label_Email_2.setObjectName("label_Email_2");

        gridLayout.addWidget(label_Email_2, 2, 0, 1, 1);

        lineEdit_Pseudo = new QLineEdit(groupBox_Required);
        lineEdit_Pseudo.setObjectName("lineEdit_Pseudo");

        gridLayout.addWidget(lineEdit_Pseudo, 2, 1, 1, 6);

        label_Email_3 = new QLabel(groupBox_Required);
        label_Email_3.setObjectName("label_Email_3");

        gridLayout.addWidget(label_Email_3, 3, 0, 1, 1);

        dateEdit_Born = new QDateEdit(groupBox_Required);
        dateEdit_Born.setObjectName("dateEdit_Born");

        gridLayout.addWidget(dateEdit_Born, 3, 1, 1, 3);

        label_Email_4 = new QLabel(groupBox_Required);
        label_Email_4.setObjectName("label_Email_4");

        gridLayout.addWidget(label_Email_4, 3, 4, 1, 1);

        horizontalSpacer = new QSpacerItem(186, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer, 3, 5, 1, 2);

        label_Email_9 = new QLabel(groupBox_Required);
        label_Email_9.setObjectName("label_Email_9");

        gridLayout.addWidget(label_Email_9, 4, 0, 1, 1);

        radioButton = new QRadioButton(groupBox_Required);
        radioButton.setObjectName("radioButton");
        radioButton.setAutoFillBackground(false);
        radioButton.setChecked(true);

        gridLayout.addWidget(radioButton, 4, 1, 1, 1);

        radioButton_2 = new QRadioButton(groupBox_Required);
        radioButton_2.setObjectName("radioButton_2");
        radioButton_2.setChecked(false);

        gridLayout.addWidget(radioButton_2, 4, 2, 1, 1);

        horizontalSpacer_2 = new QSpacerItem(224, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer_2, 4, 3, 1, 4);

        horizontalSpacer_3 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer_3, 5, 0, 1, 6);

        checkBox_Paid = new QCheckBox(groupBox_Required);
        checkBox_Paid.setObjectName("checkBox_Paid");

        gridLayout.addWidget(checkBox_Paid, 5, 6, 1, 1);


        gridLayout_3.addWidget(groupBox_Required, 0, 0, 1, 1);

        groupBox = new QGroupBox(PlayerSettings);
        groupBox.setObjectName("groupBox");
        gridLayout_8 = new QGridLayout(groupBox);
        gridLayout_8.setObjectName("gridLayout_8");
        gamesTabWidget = new QTabWidget(groupBox);
        gamesTabWidget.setObjectName("gamesTabWidget");
        tab = new QWidget();
        tab.setObjectName("tab");
        gridLayout_6 = new QGridLayout(tab);
        gridLayout_6.setObjectName("gridLayout_6");
        tableWidget0 = new QTableWidget(tab);
        tableWidget0.setObjectName("tableWidget0");
        tableWidget0.setSortingEnabled(true);

        gridLayout_6.addWidget(tableWidget0, 0, 0, 1, 1);

        gamesTabWidget.addTab(tab, com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Friday", null));
        tab_2 = new QWidget();
        tab_2.setObjectName("tab_2");
        gridLayout_7 = new QGridLayout(tab_2);
        gridLayout_7.setObjectName("gridLayout_7");
        tableWidget1 = new QTableWidget(tab_2);
        tableWidget1.setObjectName("tableWidget1");
        tableWidget1.setSortingEnabled(true);

        gridLayout_7.addWidget(tableWidget1, 0, 0, 1, 1);

        gamesTabWidget.addTab(tab_2, com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Saturday", null));
        tab_3 = new QWidget();
        tab_3.setObjectName("tab_3");
        gridLayout_5 = new QGridLayout(tab_3);
        gridLayout_5.setObjectName("gridLayout_5");
        tableWidget2 = new QTableWidget(tab_3);
        tableWidget2.setObjectName("tableWidget2");
        tableWidget2.setSortingEnabled(true);

        gridLayout_5.addWidget(tableWidget2, 0, 0, 1, 1);

        gamesTabWidget.addTab(tab_3, com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Sunday", null));

        gridLayout_8.addWidget(gamesTabWidget, 0, 0, 1, 1);


        gridLayout_3.addWidget(groupBox, 0, 1, 3, 4);

        groupBox_Required_2 = new QGroupBox(PlayerSettings);
        groupBox_Required_2.setObjectName("groupBox_Required_2");
        gridLayout_2 = new QGridLayout(groupBox_Required_2);
        gridLayout_2.setObjectName("gridLayout_2");
        label_Name_2 = new QLabel(groupBox_Required_2);
        label_Name_2.setObjectName("label_Name_2");

        gridLayout_2.addWidget(label_Name_2, 0, 0, 1, 1);

        lineEdit_Address = new QLineEdit(groupBox_Required_2);
        lineEdit_Address.setObjectName("lineEdit_Address");

        gridLayout_2.addWidget(lineEdit_Address, 0, 1, 1, 3);

        label_Email_5 = new QLabel(groupBox_Required_2);
        label_Email_5.setObjectName("label_Email_5");

        gridLayout_2.addWidget(label_Email_5, 1, 0, 1, 1);

        lineEdit_PostalCode = new QLineEdit(groupBox_Required_2);
        lineEdit_PostalCode.setObjectName("lineEdit_PostalCode");

        gridLayout_2.addWidget(lineEdit_PostalCode, 1, 1, 1, 1);

        label_Email_6 = new QLabel(groupBox_Required_2);
        label_Email_6.setObjectName("label_Email_6");

        gridLayout_2.addWidget(label_Email_6, 1, 2, 1, 1);

        lineEdit_City = new QLineEdit(groupBox_Required_2);
        lineEdit_City.setObjectName("lineEdit_City");

        gridLayout_2.addWidget(lineEdit_City, 1, 3, 1, 1);

        label_Email_7 = new QLabel(groupBox_Required_2);
        label_Email_7.setObjectName("label_Email_7");

        gridLayout_2.addWidget(label_Email_7, 2, 0, 1, 1);

        lineEdit_Email = new QLineEdit(groupBox_Required_2);
        lineEdit_Email.setObjectName("lineEdit_Email");

        gridLayout_2.addWidget(lineEdit_Email, 2, 1, 1, 3);

        label_Email_8 = new QLabel(groupBox_Required_2);
        label_Email_8.setObjectName("label_Email_8");

        gridLayout_2.addWidget(label_Email_8, 3, 0, 1, 1);

        lineEdit_Phone = new QLineEdit(groupBox_Required_2);
        lineEdit_Phone.setObjectName("lineEdit_Phone");

        gridLayout_2.addWidget(lineEdit_Phone, 3, 1, 1, 3);

        checkBox_Spam = new QCheckBox(groupBox_Required_2);
        checkBox_Spam.setObjectName("checkBox_Spam");
        checkBox_Spam.setChecked(false);

        gridLayout_2.addWidget(checkBox_Spam, 4, 3, 1, 1);


        gridLayout_3.addWidget(groupBox_Required_2, 1, 0, 2, 1);

        groupBox_Optional = new QGroupBox(PlayerSettings);
        groupBox_Optional.setObjectName("groupBox_Optional");
        groupBox_Optional.setEnabled(true);
        groupBox_Optional.setCheckable(true);
        groupBox_Optional.setChecked(false);
        gridLayout_4 = new QGridLayout(groupBox_Optional);
        gridLayout_4.setObjectName("gridLayout_4");
        label_What = new QLabel(groupBox_Optional);
        label_What.setObjectName("label_What");

        gridLayout_4.addWidget(label_What, 0, 0, 1, 1);

        lineEdit_YearsOfRPG = new QLineEdit(groupBox_Optional);
        lineEdit_YearsOfRPG.setObjectName("lineEdit_YearsOfRPG");

        gridLayout_4.addWidget(lineEdit_YearsOfRPG, 0, 1, 1, 1);

        label_Profession = new QLabel(groupBox_Optional);
        label_Profession.setObjectName("label_Profession");

        gridLayout_4.addWidget(label_Profession, 1, 0, 1, 1);

        comboBox_Club = new QComboBox(groupBox_Optional);
        comboBox_Club.setObjectName("comboBox_Club");
        comboBox_Club.setEditable(true);

        gridLayout_4.addWidget(comboBox_Club, 1, 1, 1, 1);


        gridLayout_3.addWidget(groupBox_Optional, 3, 0, 1, 1);

        buttonBox = new QDialogButtonBox(PlayerSettings);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));

        gridLayout_3.addWidget(buttonBox, 4, 1, 1, 1);

        line = new QFrame(PlayerSettings);
        line.setObjectName("line");
        line.setFrameShape(QFrame.Shape.HLine);
        line.setFrameShadow(QFrame.Shadow.Sunken);

        gridLayout_3.addWidget(line, 5, 0, 1, 5);

        dateEdit = new QDateEdit(PlayerSettings);
        dateEdit.setObjectName("dateEdit");

        gridLayout_3.addWidget(dateEdit, 3, 4, 1, 1);

        label = new QLabel(PlayerSettings);
        label.setObjectName("label");

        gridLayout_3.addWidget(label, 3, 3, 1, 1);

        horizontalSpacer_4 = new QSpacerItem(206, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_3.addItem(horizontalSpacer_4, 3, 1, 1, 1);

        QWidget.setTabOrder(lineEdit_LastName, lineEdit_FirstName);
        QWidget.setTabOrder(lineEdit_FirstName, lineEdit_Pseudo);
        QWidget.setTabOrder(lineEdit_Pseudo, dateEdit_Born);
        QWidget.setTabOrder(dateEdit_Born, radioButton);
        QWidget.setTabOrder(radioButton, radioButton_2);
        QWidget.setTabOrder(radioButton_2, checkBox_Paid);
        QWidget.setTabOrder(checkBox_Paid, lineEdit_Address);
        QWidget.setTabOrder(lineEdit_Address, lineEdit_PostalCode);
        QWidget.setTabOrder(lineEdit_PostalCode, lineEdit_City);
        QWidget.setTabOrder(lineEdit_City, lineEdit_Email);
        QWidget.setTabOrder(lineEdit_Email, lineEdit_Phone);
        QWidget.setTabOrder(lineEdit_Phone, checkBox_Spam);
        QWidget.setTabOrder(checkBox_Spam, groupBox_Optional);
        QWidget.setTabOrder(groupBox_Optional, lineEdit_YearsOfRPG);
        QWidget.setTabOrder(lineEdit_YearsOfRPG, comboBox_Club);
        QWidget.setTabOrder(comboBox_Club, tableWidget0);
        QWidget.setTabOrder(tableWidget0, tableWidget2);
        QWidget.setTabOrder(tableWidget2, tableWidget1);
        QWidget.setTabOrder(tableWidget1, buttonBox);
        retranslateUi(PlayerSettings);
        buttonBox.accepted.connect(PlayerSettings, "accept()");
        buttonBox.rejected.connect(PlayerSettings, "reject()");

        gamesTabWidget.setCurrentIndex(0);


        PlayerSettings.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog PlayerSettings)
    {
        PlayerSettings.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Dialog", null));
        actionAddPlayer.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "addPlayer", null));
        actionAddPlayer.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Add a new player", null));
        groupBox_Required.setTitle(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Personnal Informations", null));
        label_Name.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Last Name", null));
        label_Email.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "First Name", null));
        label_Email_2.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Pseudo", null));
        label_Email_3.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Born", null));
        label_Email_4.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Age", null));
        label_Email_9.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Sex", null));
        radioButton.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "M", null));
        radioButton_2.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "F", null));
        checkBox_Paid.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Inscription pay\u00e9e", null));
        groupBox.setTitle(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "GroupBox", null));
        tableWidget0.clear();
        tableWidget0.setColumnCount(2);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "MJ", null));
        tableWidget0.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "PJ", null));
        tableWidget0.setHorizontalHeaderItem(1, __colItem1);
        tableWidget0.setRowCount(0);
        gamesTabWidget.setTabText(gamesTabWidget.indexOf(tab), com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Friday", null));
        tableWidget1.clear();
        tableWidget1.setColumnCount(2);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "MJ", null));
        tableWidget1.setHorizontalHeaderItem(0, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "PJ", null));
        tableWidget1.setHorizontalHeaderItem(1, __colItem3);
        tableWidget1.setRowCount(0);
        gamesTabWidget.setTabText(gamesTabWidget.indexOf(tab_2), com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Saturday", null));
        tableWidget2.clear();
        tableWidget2.setColumnCount(2);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "MJ", null));
        tableWidget2.setHorizontalHeaderItem(0, __colItem4);

        QTableWidgetItem __colItem5 = new QTableWidgetItem();
        __colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "PJ", null));
        tableWidget2.setHorizontalHeaderItem(1, __colItem5);
        tableWidget2.setRowCount(0);
        gamesTabWidget.setTabText(gamesTabWidget.indexOf(tab_3), com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Sunday", null));
        groupBox_Required_2.setTitle(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Contact Informations", null));
        label_Name_2.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Address", null));
        label_Email_5.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Postal Code", null));
        label_Email_6.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "City", null));
        label_Email_7.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Email", null));
        label_Email_8.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Phone", null));
        checkBox_Spam.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Send me SPAM", null));
        groupBox_Optional.setTitle(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Optional", null));
        label_What.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Years of RPG", null));
        label_Profession.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Club", null));
        comboBox_Club.clear();
        comboBox_Club.addItem("");
        comboBox_Club.addItem(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Superstar", null));
        comboBox_Club.addItem(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Programmer", null));
        comboBox_Club.addItem(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Teacher", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("PlayerSettings", "Date d'inscription", null));
    } // retranslateUi

}


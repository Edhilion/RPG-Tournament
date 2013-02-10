/********************************************************************************
** Form generated from reading ui file 'RPGTournamentManager.jui'
**
** Created: dim. 10. févr. 13:03:23 2013
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package fr.graal.rpgtournament;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_RPGTournamentManager implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction actionNew_Tournament;
    public QAction actionOpen_Tournement;
    public QAction actionSave_Tournament;
    public QAction actionClose;
    public QAction actionAdd_Player;
    public QAction actionShow_Players;
    public QAction actionAdd_Round;
    public QAction actionShow_Rounds;
    public QAction actionGenerate_Round;
    public QAction actionAdd_Game;
    public QAction actionPer_Round;
    public QAction actionAll;
    public QAction actionGenerate_Results;
    public QAction actionPreferences;
    public QAction actionUpdateFridayPlayer;
    public QAction actionUpdateSaturdayPlayer;
    public QAction actionUpdateSundayPlayer;
    public QAction actionUpdateFridayGames;
    public QAction actionUpdateSaturdayGames;
    public QAction actionUpdateSundayGames;
    public QAction actionUpdatePlayer;
    public QWidget centralwidget;
    public QGridLayout gridLayout_2;
    public QTabWidget mainTabWidget;
    public QWidget tab;
    public QGridLayout gridLayout_5;
    public QTableWidget allPlayersTableWidget;
    public QWidget tab_2;
    public QGridLayout gridLayout;
    public QGroupBox groupBox;
    public QGridLayout gridLayout_7;
    public QTableWidget fridayTableWidget;
    public QGroupBox groupBox_6;
    public QGridLayout gridLayout_6;
    public QSpacerItem verticalSpacer_7;
    public QTableWidget fridayGamesTableWidget;
    public QSpacerItem verticalSpacer_8;
    public QLabel label_7;
    public QLabel label_8;
    public QLineEdit fridayGMLineEdit;
    public QLabel label_9;
    public QLineEdit fridayPLineEdit;
    public QSpacerItem verticalSpacer_9;
    public QWidget tab_3;
    public QGridLayout gridLayout_4;
    public QGroupBox groupBox_2;
    public QGridLayout gridLayout_8;
    public QTableWidget saturdayTableWidget;
    public QGroupBox groupBox_5;
    public QGridLayout gridLayout_9;
    public QSpacerItem verticalSpacer_4;
    public QTableWidget saturdayGamesTableWidget;
    public QSpacerItem verticalSpacer_5;
    public QLabel label_4;
    public QLabel label_5;
    public QLineEdit saturdayGMLineEdit;
    public QLabel label_6;
    public QLineEdit saturdayPLineEdit;
    public QSpacerItem verticalSpacer_6;
    public QWidget tab_4;
    public QGridLayout gridLayout_3;
    public QGroupBox groupBox_3;
    public QGridLayout gridLayout_10;
    public QTableWidget sundayTableWidget;
    public QGroupBox groupBox_4;
    public QGridLayout gridLayout_11;
    public QSpacerItem verticalSpacer;
    public QTableWidget sundayGamesTableWidget;
    public QSpacerItem verticalSpacer_2;
    public QLabel label;
    public QLabel label_2;
    public QLineEdit sundayGMLineEdit;
    public QLabel label_3;
    public QLineEdit sundayPLineEdit;
    public QSpacerItem verticalSpacer_3;
    public QMenuBar menubar;
    public QMenu menuFile;
    public QMenu menuPlayers;
    public QMenu menuRounds;
    public QMenu menuGames;
    public QMenu menuShow_Games;
    public QMenu menuResults;
    public QStatusBar statusbar;
    public QToolBar toolBar;

    public Ui_RPGTournamentManager() { super(); }

    public void setupUi(QMainWindow RPGTournamentManager)
    {
        RPGTournamentManager.setObjectName("RPGTournamentManager");
        RPGTournamentManager.resize(new QSize(912, 650).expandedTo(RPGTournamentManager.minimumSizeHint()));
        actionNew_Tournament = new QAction(RPGTournamentManager);
        actionNew_Tournament.setObjectName("actionNew_Tournament");
        actionOpen_Tournement = new QAction(RPGTournamentManager);
        actionOpen_Tournement.setObjectName("actionOpen_Tournement");
        actionSave_Tournament = new QAction(RPGTournamentManager);
        actionSave_Tournament.setObjectName("actionSave_Tournament");
        actionClose = new QAction(RPGTournamentManager);
        actionClose.setObjectName("actionClose");
        actionAdd_Player = new QAction(RPGTournamentManager);
        actionAdd_Player.setObjectName("actionAdd_Player");
        actionShow_Players = new QAction(RPGTournamentManager);
        actionShow_Players.setObjectName("actionShow_Players");
        actionAdd_Round = new QAction(RPGTournamentManager);
        actionAdd_Round.setObjectName("actionAdd_Round");
        actionShow_Rounds = new QAction(RPGTournamentManager);
        actionShow_Rounds.setObjectName("actionShow_Rounds");
        actionGenerate_Round = new QAction(RPGTournamentManager);
        actionGenerate_Round.setObjectName("actionGenerate_Round");
        actionAdd_Game = new QAction(RPGTournamentManager);
        actionAdd_Game.setObjectName("actionAdd_Game");
        actionPer_Round = new QAction(RPGTournamentManager);
        actionPer_Round.setObjectName("actionPer_Round");
        actionAll = new QAction(RPGTournamentManager);
        actionAll.setObjectName("actionAll");
        actionGenerate_Results = new QAction(RPGTournamentManager);
        actionGenerate_Results.setObjectName("actionGenerate_Results");
        actionPreferences = new QAction(RPGTournamentManager);
        actionPreferences.setObjectName("actionPreferences");
        actionUpdateFridayPlayer = new QAction(RPGTournamentManager);
        actionUpdateFridayPlayer.setObjectName("actionUpdateFridayPlayer");
        actionUpdateSaturdayPlayer = new QAction(RPGTournamentManager);
        actionUpdateSaturdayPlayer.setObjectName("actionUpdateSaturdayPlayer");
        actionUpdateSundayPlayer = new QAction(RPGTournamentManager);
        actionUpdateSundayPlayer.setObjectName("actionUpdateSundayPlayer");
        actionUpdateFridayGames = new QAction(RPGTournamentManager);
        actionUpdateFridayGames.setObjectName("actionUpdateFridayGames");
        actionUpdateSaturdayGames = new QAction(RPGTournamentManager);
        actionUpdateSaturdayGames.setObjectName("actionUpdateSaturdayGames");
        actionUpdateSundayGames = new QAction(RPGTournamentManager);
        actionUpdateSundayGames.setObjectName("actionUpdateSundayGames");
        actionUpdatePlayer = new QAction(RPGTournamentManager);
        actionUpdatePlayer.setObjectName("actionUpdatePlayer");
        centralwidget = new QWidget(RPGTournamentManager);
        centralwidget.setObjectName("centralwidget");
        gridLayout_2 = new QGridLayout(centralwidget);
        gridLayout_2.setObjectName("gridLayout_2");
        mainTabWidget = new QTabWidget(centralwidget);
        mainTabWidget.setObjectName("mainTabWidget");
        tab = new QWidget();
        tab.setObjectName("tab");
        gridLayout_5 = new QGridLayout(tab);
        gridLayout_5.setObjectName("gridLayout_5");
        allPlayersTableWidget = new QTableWidget(tab);
        allPlayersTableWidget.setObjectName("allPlayersTableWidget");
        allPlayersTableWidget.setSortingEnabled(true);

        gridLayout_5.addWidget(allPlayersTableWidget, 0, 0, 1, 1);

        mainTabWidget.addTab(tab, com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Tous les jours", null));
        tab_2 = new QWidget();
        tab_2.setObjectName("tab_2");
        gridLayout = new QGridLayout(tab_2);
        gridLayout.setObjectName("gridLayout");
        groupBox = new QGroupBox(tab_2);
        groupBox.setObjectName("groupBox");
        gridLayout_7 = new QGridLayout(groupBox);
        gridLayout_7.setObjectName("gridLayout_7");
        fridayTableWidget = new QTableWidget(groupBox);
        fridayTableWidget.setObjectName("fridayTableWidget");
        fridayTableWidget.setSortingEnabled(true);

        gridLayout_7.addWidget(fridayTableWidget, 0, 0, 1, 1);


        gridLayout.addWidget(groupBox, 0, 0, 1, 1);

        groupBox_6 = new QGroupBox(tab_2);
        groupBox_6.setObjectName("groupBox_6");
        gridLayout_6 = new QGridLayout(groupBox_6);
        gridLayout_6.setObjectName("gridLayout_6");
        verticalSpacer_7 = new QSpacerItem(20, 400, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_6.addItem(verticalSpacer_7, 0, 0, 1, 1);

        fridayGamesTableWidget = new QTableWidget(groupBox_6);
        fridayGamesTableWidget.setObjectName("fridayGamesTableWidget");
        fridayGamesTableWidget.setSortingEnabled(true);

        gridLayout_6.addWidget(fridayGamesTableWidget, 0, 1, 1, 6);

        verticalSpacer_8 = new QSpacerItem(20, 26, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_6.addItem(verticalSpacer_8, 1, 4, 1, 1);

        label_7 = new QLabel(groupBox_6);
        label_7.setObjectName("label_7");

        gridLayout_6.addWidget(label_7, 2, 1, 1, 1);

        label_8 = new QLabel(groupBox_6);
        label_8.setObjectName("label_8");

        gridLayout_6.addWidget(label_8, 2, 2, 1, 1);

        fridayGMLineEdit = new QLineEdit(groupBox_6);
        fridayGMLineEdit.setObjectName("fridayGMLineEdit");
        fridayGMLineEdit.setReadOnly(true);

        gridLayout_6.addWidget(fridayGMLineEdit, 2, 3, 1, 2);

        label_9 = new QLabel(groupBox_6);
        label_9.setObjectName("label_9");

        gridLayout_6.addWidget(label_9, 2, 5, 1, 1);

        fridayPLineEdit = new QLineEdit(groupBox_6);
        fridayPLineEdit.setObjectName("fridayPLineEdit");
        fridayPLineEdit.setReadOnly(true);

        gridLayout_6.addWidget(fridayPLineEdit, 2, 6, 1, 1);

        verticalSpacer_9 = new QSpacerItem(20, 25, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_6.addItem(verticalSpacer_9, 3, 4, 1, 1);


        gridLayout.addWidget(groupBox_6, 0, 1, 1, 1);

        mainTabWidget.addTab(tab_2, com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Vendredi", null));
        tab_3 = new QWidget();
        tab_3.setObjectName("tab_3");
        gridLayout_4 = new QGridLayout(tab_3);
        gridLayout_4.setObjectName("gridLayout_4");
        groupBox_2 = new QGroupBox(tab_3);
        groupBox_2.setObjectName("groupBox_2");
        gridLayout_8 = new QGridLayout(groupBox_2);
        gridLayout_8.setObjectName("gridLayout_8");
        saturdayTableWidget = new QTableWidget(groupBox_2);
        saturdayTableWidget.setObjectName("saturdayTableWidget");
        saturdayTableWidget.setSortingEnabled(true);

        gridLayout_8.addWidget(saturdayTableWidget, 0, 0, 1, 1);


        gridLayout_4.addWidget(groupBox_2, 0, 0, 1, 1);

        groupBox_5 = new QGroupBox(tab_3);
        groupBox_5.setObjectName("groupBox_5");
        gridLayout_9 = new QGridLayout(groupBox_5);
        gridLayout_9.setObjectName("gridLayout_9");
        verticalSpacer_4 = new QSpacerItem(20, 400, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_9.addItem(verticalSpacer_4, 0, 0, 1, 1);

        saturdayGamesTableWidget = new QTableWidget(groupBox_5);
        saturdayGamesTableWidget.setObjectName("saturdayGamesTableWidget");
        saturdayGamesTableWidget.setSortingEnabled(true);

        gridLayout_9.addWidget(saturdayGamesTableWidget, 0, 1, 1, 6);

        verticalSpacer_5 = new QSpacerItem(20, 26, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_9.addItem(verticalSpacer_5, 1, 4, 1, 1);

        label_4 = new QLabel(groupBox_5);
        label_4.setObjectName("label_4");

        gridLayout_9.addWidget(label_4, 2, 1, 1, 1);

        label_5 = new QLabel(groupBox_5);
        label_5.setObjectName("label_5");

        gridLayout_9.addWidget(label_5, 2, 2, 1, 1);

        saturdayGMLineEdit = new QLineEdit(groupBox_5);
        saturdayGMLineEdit.setObjectName("saturdayGMLineEdit");
        saturdayGMLineEdit.setReadOnly(true);

        gridLayout_9.addWidget(saturdayGMLineEdit, 2, 3, 1, 2);

        label_6 = new QLabel(groupBox_5);
        label_6.setObjectName("label_6");

        gridLayout_9.addWidget(label_6, 2, 5, 1, 1);

        saturdayPLineEdit = new QLineEdit(groupBox_5);
        saturdayPLineEdit.setObjectName("saturdayPLineEdit");
        saturdayPLineEdit.setReadOnly(true);

        gridLayout_9.addWidget(saturdayPLineEdit, 2, 6, 1, 1);

        verticalSpacer_6 = new QSpacerItem(20, 25, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_9.addItem(verticalSpacer_6, 3, 4, 1, 1);


        gridLayout_4.addWidget(groupBox_5, 0, 1, 1, 1);

        mainTabWidget.addTab(tab_3, com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Samedi", null));
        tab_4 = new QWidget();
        tab_4.setObjectName("tab_4");
        gridLayout_3 = new QGridLayout(tab_4);
        gridLayout_3.setObjectName("gridLayout_3");
        groupBox_3 = new QGroupBox(tab_4);
        groupBox_3.setObjectName("groupBox_3");
        gridLayout_10 = new QGridLayout(groupBox_3);
        gridLayout_10.setObjectName("gridLayout_10");
        sundayTableWidget = new QTableWidget(groupBox_3);
        sundayTableWidget.setObjectName("sundayTableWidget");
        sundayTableWidget.setSortingEnabled(true);

        gridLayout_10.addWidget(sundayTableWidget, 0, 0, 1, 1);


        gridLayout_3.addWidget(groupBox_3, 0, 0, 1, 1);

        groupBox_4 = new QGroupBox(tab_4);
        groupBox_4.setObjectName("groupBox_4");
        gridLayout_11 = new QGridLayout(groupBox_4);
        gridLayout_11.setObjectName("gridLayout_11");
        verticalSpacer = new QSpacerItem(20, 400, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_11.addItem(verticalSpacer, 0, 0, 1, 1);

        sundayGamesTableWidget = new QTableWidget(groupBox_4);
        sundayGamesTableWidget.setObjectName("sundayGamesTableWidget");
        sundayGamesTableWidget.setSortingEnabled(true);

        gridLayout_11.addWidget(sundayGamesTableWidget, 0, 1, 1, 6);

        verticalSpacer_2 = new QSpacerItem(20, 27, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_11.addItem(verticalSpacer_2, 1, 4, 1, 1);

        label = new QLabel(groupBox_4);
        label.setObjectName("label");

        gridLayout_11.addWidget(label, 2, 1, 1, 1);

        label_2 = new QLabel(groupBox_4);
        label_2.setObjectName("label_2");

        gridLayout_11.addWidget(label_2, 2, 2, 1, 1);

        sundayGMLineEdit = new QLineEdit(groupBox_4);
        sundayGMLineEdit.setObjectName("sundayGMLineEdit");
        sundayGMLineEdit.setReadOnly(true);

        gridLayout_11.addWidget(sundayGMLineEdit, 2, 3, 1, 2);

        label_3 = new QLabel(groupBox_4);
        label_3.setObjectName("label_3");

        gridLayout_11.addWidget(label_3, 2, 5, 1, 1);

        sundayPLineEdit = new QLineEdit(groupBox_4);
        sundayPLineEdit.setObjectName("sundayPLineEdit");
        sundayPLineEdit.setReadOnly(true);

        gridLayout_11.addWidget(sundayPLineEdit, 2, 6, 1, 1);

        verticalSpacer_3 = new QSpacerItem(20, 27, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_11.addItem(verticalSpacer_3, 3, 4, 1, 1);


        gridLayout_3.addWidget(groupBox_4, 0, 1, 1, 1);

        mainTabWidget.addTab(tab_4, com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Dimanche", null));

        gridLayout_2.addWidget(mainTabWidget, 0, 0, 1, 1);

        RPGTournamentManager.setCentralWidget(centralwidget);
        menubar = new QMenuBar(RPGTournamentManager);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 912, 22));
        menuFile = new QMenu(menubar);
        menuFile.setObjectName("menuFile");
        menuPlayers = new QMenu(menubar);
        menuPlayers.setObjectName("menuPlayers");
        menuRounds = new QMenu(menubar);
        menuRounds.setObjectName("menuRounds");
        menuGames = new QMenu(menubar);
        menuGames.setObjectName("menuGames");
        menuShow_Games = new QMenu(menuGames);
        menuShow_Games.setObjectName("menuShow_Games");
        menuResults = new QMenu(menubar);
        menuResults.setObjectName("menuResults");
        RPGTournamentManager.setMenuBar(menubar);
        statusbar = new QStatusBar(RPGTournamentManager);
        statusbar.setObjectName("statusbar");
        RPGTournamentManager.setStatusBar(statusbar);
        toolBar = new QToolBar(RPGTournamentManager);
        toolBar.setObjectName("toolBar");
        RPGTournamentManager.addToolBar(com.trolltech.qt.core.Qt.ToolBarArea.TopToolBarArea, toolBar);

        menubar.addAction(menuFile.menuAction());
        menubar.addAction(menuPlayers.menuAction());
        menubar.addAction(menuRounds.menuAction());
        menubar.addAction(menuGames.menuAction());
        menubar.addAction(menuResults.menuAction());
        menuFile.addAction(actionNew_Tournament);
        menuFile.addAction(actionOpen_Tournement);
        menuFile.addSeparator();
        menuFile.addAction(actionSave_Tournament);
        menuFile.addSeparator();
        menuFile.addAction(actionClose);
        menuPlayers.addAction(actionAdd_Player);
        menuPlayers.addAction(actionShow_Players);
        menuRounds.addAction(actionAdd_Round);
        menuRounds.addAction(actionShow_Rounds);
        menuRounds.addSeparator();
        menuRounds.addAction(actionGenerate_Round);
        menuGames.addAction(actionAdd_Game);
        menuGames.addAction(menuShow_Games.menuAction());
        menuShow_Games.addAction(actionPer_Round);
        menuShow_Games.addAction(actionAll);
        menuResults.addAction(actionGenerate_Results);
        menuResults.addAction(actionPreferences);
        retranslateUi(RPGTournamentManager);
        fridayGamesTableWidget.cellChanged.connect(actionUpdateFridayPlayer, "trigger()");
        saturdayGamesTableWidget.cellChanged.connect(actionUpdateSaturdayPlayer, "trigger()");
        sundayGamesTableWidget.cellChanged.connect(actionUpdateSundayPlayer, "trigger()");
        fridayTableWidget.cellClicked.connect(actionUpdateFridayGames, "trigger()");
        saturdayTableWidget.cellClicked.connect(actionUpdateSaturdayGames, "trigger()");
        sundayTableWidget.cellClicked.connect(actionUpdateSundayGames, "trigger()");
        fridayTableWidget.cellChanged.connect(actionUpdateFridayPlayer, "trigger()");
        saturdayTableWidget.cellChanged.connect(actionUpdateSaturdayPlayer, "trigger()");
        sundayTableWidget.cellChanged.connect(actionUpdateSundayPlayer, "trigger()");
        allPlayersTableWidget.cellChanged.connect(actionUpdatePlayer, "trigger()");

        mainTabWidget.setCurrentIndex(0);


        RPGTournamentManager.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow RPGTournamentManager)
    {
        RPGTournamentManager.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "MainWindow", null));
        actionNew_Tournament.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "New Tournament", null));
        actionOpen_Tournement.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Open Tournement", null));
        actionSave_Tournament.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Save Tournament", null));
        actionClose.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Close", null));
        actionAdd_Player.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Add Player", null));
        actionShow_Players.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Show Players", null));
        actionAdd_Round.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Add Round", null));
        actionShow_Rounds.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Show Rounds", null));
        actionGenerate_Round.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Generate Round", null));
        actionAdd_Game.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Add Game", null));
        actionPer_Round.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Per Round", null));
        actionAll.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "All", null));
        actionGenerate_Results.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Generate Results", null));
        actionPreferences.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Preferences", null));
        actionUpdateFridayPlayer.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "updateFridayPlayer", null));
        actionUpdateSaturdayPlayer.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "updateSaturdayPlayer", null));
        actionUpdateSundayPlayer.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "updateSundayPlayer", null));
        actionUpdateFridayGames.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "updateFridayGames", null));
        actionUpdateSaturdayGames.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "updateSaturdayGames", null));
        actionUpdateSundayGames.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "updateSundayGames", null));
        actionUpdatePlayer.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "updatePlayer", null));
        allPlayersTableWidget.clear();
        allPlayersTableWidget.setColumnCount(7);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Last Name", null));
        allPlayersTableWidget.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "First Name", null));
        allPlayersTableWidget.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "MJ", null));
        allPlayersTableWidget.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "PJ", null));
        allPlayersTableWidget.setHorizontalHeaderItem(3, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Note", null));
        allPlayersTableWidget.setHorizontalHeaderItem(4, __colItem4);

        QTableWidgetItem __colItem5 = new QTableWidgetItem();
        __colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Type", null));
        allPlayersTableWidget.setHorizontalHeaderItem(5, __colItem5);

        QTableWidgetItem __colItem6 = new QTableWidgetItem();
        __colItem6.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Paid", null));
        allPlayersTableWidget.setHorizontalHeaderItem(6, __colItem6);
        allPlayersTableWidget.setRowCount(0);
        mainTabWidget.setTabText(mainTabWidget.indexOf(tab), com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Tous les jours", null));
        groupBox.setTitle(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Players", null));
        fridayTableWidget.clear();
        fridayTableWidget.setColumnCount(4);

        QTableWidgetItem __colItem7 = new QTableWidgetItem();
        __colItem7.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Last Name", null));
        fridayTableWidget.setHorizontalHeaderItem(0, __colItem7);

        QTableWidgetItem __colItem8 = new QTableWidgetItem();
        __colItem8.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "First Name", null));
        fridayTableWidget.setHorizontalHeaderItem(1, __colItem8);

        QTableWidgetItem __colItem9 = new QTableWidgetItem();
        __colItem9.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Note", null));
        fridayTableWidget.setHorizontalHeaderItem(2, __colItem9);

        QTableWidgetItem __colItem10 = new QTableWidgetItem();
        __colItem10.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Game", null));
        fridayTableWidget.setHorizontalHeaderItem(3, __colItem10);
        fridayTableWidget.setRowCount(0);
        groupBox_6.setTitle(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "GroupBox", null));
        fridayGamesTableWidget.clear();
        fridayGamesTableWidget.setColumnCount(2);

        QTableWidgetItem __colItem11 = new QTableWidgetItem();
        __colItem11.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "MJ", null));
        fridayGamesTableWidget.setHorizontalHeaderItem(0, __colItem11);

        QTableWidgetItem __colItem12 = new QTableWidgetItem();
        __colItem12.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "PJ", null));
        fridayGamesTableWidget.setHorizontalHeaderItem(1, __colItem12);
        fridayGamesTableWidget.setRowCount(8);

        QTableWidgetItem __rowItem = new QTableWidgetItem();
        __rowItem.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Yggdrasill", null));
        fridayGamesTableWidget.setVerticalHeaderItem(0, __rowItem);

        QTableWidgetItem __rowItem1 = new QTableWidgetItem();
        __rowItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Crimes", null));
        fridayGamesTableWidget.setVerticalHeaderItem(1, __rowItem1);

        QTableWidgetItem __rowItem2 = new QTableWidgetItem();
        __rowItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "B.I.A.", null));
        fridayGamesTableWidget.setVerticalHeaderItem(2, __rowItem2);

        QTableWidgetItem __rowItem3 = new QTableWidgetItem();
        __rowItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "ShadowRun", null));
        fridayGamesTableWidget.setVerticalHeaderItem(3, __rowItem3);

        QTableWidgetItem __rowItem4 = new QTableWidgetItem();
        __rowItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Mind Dagger", null));
        fridayGamesTableWidget.setVerticalHeaderItem(4, __rowItem4);

        QTableWidgetItem __rowItem5 = new QTableWidgetItem();
        __rowItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Jeu surprise", null));
        fridayGamesTableWidget.setVerticalHeaderItem(5, __rowItem5);

        QTableWidgetItem __rowItem6 = new QTableWidgetItem();
        __rowItem6.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Ombres d'Esteren", null));
        fridayGamesTableWidget.setVerticalHeaderItem(6, __rowItem6);

        QTableWidgetItem __rowItem7 = new QTableWidgetItem();
        __rowItem7.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Tenga", null));
        fridayGamesTableWidget.setVerticalHeaderItem(7, __rowItem7);

        QTableWidgetItem __item = new QTableWidgetItem();
        __item.setText("");
        fridayGamesTableWidget.setItem(2, 0, __item);

        QTableWidgetItem __item1 = new QTableWidgetItem();
        __item1.setText("");
        fridayGamesTableWidget.setItem(2, 1, __item1);
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Total", null));
        label_8.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "MJ", null));
        label_9.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "PJ", null));
        mainTabWidget.setTabText(mainTabWidget.indexOf(tab_2), com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Vendredi", null));
        groupBox_2.setTitle(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Players", null));
        saturdayTableWidget.clear();
        saturdayTableWidget.setColumnCount(4);

        QTableWidgetItem __colItem13 = new QTableWidgetItem();
        __colItem13.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Last Name", null));
        saturdayTableWidget.setHorizontalHeaderItem(0, __colItem13);

        QTableWidgetItem __colItem14 = new QTableWidgetItem();
        __colItem14.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "First Name", null));
        saturdayTableWidget.setHorizontalHeaderItem(1, __colItem14);

        QTableWidgetItem __colItem15 = new QTableWidgetItem();
        __colItem15.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Note", null));
        saturdayTableWidget.setHorizontalHeaderItem(2, __colItem15);

        QTableWidgetItem __colItem16 = new QTableWidgetItem();
        __colItem16.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Game", null));
        saturdayTableWidget.setHorizontalHeaderItem(3, __colItem16);
        saturdayTableWidget.setRowCount(0);
        groupBox_5.setTitle(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "GroupBox", null));
        saturdayGamesTableWidget.clear();
        saturdayGamesTableWidget.setColumnCount(2);

        QTableWidgetItem __colItem17 = new QTableWidgetItem();
        __colItem17.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "MJ", null));
        saturdayGamesTableWidget.setHorizontalHeaderItem(0, __colItem17);

        QTableWidgetItem __colItem18 = new QTableWidgetItem();
        __colItem18.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "PJ", null));
        saturdayGamesTableWidget.setHorizontalHeaderItem(1, __colItem18);
        saturdayGamesTableWidget.setRowCount(8);

        QTableWidgetItem __rowItem8 = new QTableWidgetItem();
        __rowItem8.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Oikoum\u00e9n\u00e8", null));
        saturdayGamesTableWidget.setVerticalHeaderItem(0, __rowItem8);

        QTableWidgetItem __rowItem9 = new QTableWidgetItem();
        __rowItem9.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Warhammer", null));
        saturdayGamesTableWidget.setVerticalHeaderItem(1, __rowItem9);

        QTableWidgetItem __rowItem10 = new QTableWidgetItem();
        __rowItem10.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Appel de Cthulhu", null));
        saturdayGamesTableWidget.setVerticalHeaderItem(2, __rowItem10);

        QTableWidgetItem __rowItem11 = new QTableWidgetItem();
        __rowItem11.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Metal Adventures", null));
        saturdayGamesTableWidget.setVerticalHeaderItem(3, __rowItem11);

        QTableWidgetItem __rowItem12 = new QTableWidgetItem();
        __rowItem12.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Jeu surprise", null));
        saturdayGamesTableWidget.setVerticalHeaderItem(4, __rowItem12);

        QTableWidgetItem __rowItem13 = new QTableWidgetItem();
        __rowItem13.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Mind Dagger", null));
        saturdayGamesTableWidget.setVerticalHeaderItem(5, __rowItem13);

        QTableWidgetItem __rowItem14 = new QTableWidgetItem();
        __rowItem14.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Ombres d'Esteren", null));
        saturdayGamesTableWidget.setVerticalHeaderItem(6, __rowItem14);

        QTableWidgetItem __rowItem15 = new QTableWidgetItem();
        __rowItem15.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Tenga", null));
        saturdayGamesTableWidget.setVerticalHeaderItem(7, __rowItem15);

        QTableWidgetItem __item2 = new QTableWidgetItem();
        __item2.setText("");
        saturdayGamesTableWidget.setItem(2, 0, __item2);

        QTableWidgetItem __item3 = new QTableWidgetItem();
        __item3.setText("");
        saturdayGamesTableWidget.setItem(2, 1, __item3);
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Total", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "MJ", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "PJ", null));
        mainTabWidget.setTabText(mainTabWidget.indexOf(tab_3), com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Samedi", null));
        groupBox_3.setTitle(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Players", null));
        sundayTableWidget.clear();
        sundayTableWidget.setColumnCount(4);

        QTableWidgetItem __colItem19 = new QTableWidgetItem();
        __colItem19.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Last Name", null));
        sundayTableWidget.setHorizontalHeaderItem(0, __colItem19);

        QTableWidgetItem __colItem20 = new QTableWidgetItem();
        __colItem20.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "First Name", null));
        sundayTableWidget.setHorizontalHeaderItem(1, __colItem20);

        QTableWidgetItem __colItem21 = new QTableWidgetItem();
        __colItem21.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Note", null));
        sundayTableWidget.setHorizontalHeaderItem(2, __colItem21);

        QTableWidgetItem __colItem22 = new QTableWidgetItem();
        __colItem22.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Game", null));
        sundayTableWidget.setHorizontalHeaderItem(3, __colItem22);
        sundayTableWidget.setRowCount(0);
        groupBox_4.setTitle(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "GroupBox", null));
        sundayGamesTableWidget.clear();
        sundayGamesTableWidget.setColumnCount(2);

        QTableWidgetItem __colItem23 = new QTableWidgetItem();
        __colItem23.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "MJ", null));
        sundayGamesTableWidget.setHorizontalHeaderItem(0, __colItem23);

        QTableWidgetItem __colItem24 = new QTableWidgetItem();
        __colItem24.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "PJ", null));
        sundayGamesTableWidget.setHorizontalHeaderItem(1, __colItem24);
        sundayGamesTableWidget.setRowCount(10);

        QTableWidgetItem __rowItem16 = new QTableWidgetItem();
        __rowItem16.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Donjons et Dragons 4", null));
        sundayGamesTableWidget.setVerticalHeaderItem(0, __rowItem16);

        QTableWidgetItem __rowItem17 = new QTableWidgetItem();
        __rowItem17.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Pathfinder", null));
        sundayGamesTableWidget.setVerticalHeaderItem(1, __rowItem17);

        QTableWidgetItem __rowItem18 = new QTableWidgetItem();
        __rowItem18.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Capharna\u00fcm", null));
        sundayGamesTableWidget.setVerticalHeaderItem(2, __rowItem18);

        QTableWidgetItem __rowItem19 = new QTableWidgetItem();
        __rowItem19.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Hellywood", null));
        sundayGamesTableWidget.setVerticalHeaderItem(3, __rowItem19);

        QTableWidgetItem __rowItem20 = new QTableWidgetItem();
        __rowItem20.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Dark Heresy", null));
        sundayGamesTableWidget.setVerticalHeaderItem(4, __rowItem20);

        QTableWidgetItem __rowItem21 = new QTableWidgetItem();
        __rowItem21.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Rogue Trader", null));
        sundayGamesTableWidget.setVerticalHeaderItem(5, __rowItem21);

        QTableWidgetItem __rowItem22 = new QTableWidgetItem();
        __rowItem22.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Jeu surprise", null));
        sundayGamesTableWidget.setVerticalHeaderItem(6, __rowItem22);

        QTableWidgetItem __rowItem23 = new QTableWidgetItem();
        __rowItem23.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Mind Dagger", null));
        sundayGamesTableWidget.setVerticalHeaderItem(7, __rowItem23);

        QTableWidgetItem __rowItem24 = new QTableWidgetItem();
        __rowItem24.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Ombres d'Esteren", null));
        sundayGamesTableWidget.setVerticalHeaderItem(8, __rowItem24);

        QTableWidgetItem __rowItem25 = new QTableWidgetItem();
        __rowItem25.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Tenga", null));
        sundayGamesTableWidget.setVerticalHeaderItem(9, __rowItem25);

        QTableWidgetItem __item4 = new QTableWidgetItem();
        __item4.setText("");
        sundayGamesTableWidget.setItem(2, 0, __item4);

        QTableWidgetItem __item5 = new QTableWidgetItem();
        __item5.setText("");
        sundayGamesTableWidget.setItem(2, 1, __item5);
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Total", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "MJ", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "PJ", null));
        mainTabWidget.setTabText(mainTabWidget.indexOf(tab_4), com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Dimanche", null));
        menuFile.setTitle(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "File", null));
        menuPlayers.setTitle(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Players", null));
        menuRounds.setTitle(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Rounds", null));
        menuGames.setTitle(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Games", null));
        menuShow_Games.setTitle(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Show Games", null));
        menuResults.setTitle(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "Results", null));
        toolBar.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("RPGTournamentManager", "toolBar", null));
    } // retranslateUi

}


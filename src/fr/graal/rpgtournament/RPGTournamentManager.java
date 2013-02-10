package fr.graal.rpgtournament;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import com.trolltech.qt.core.QDateTime;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.*;

import fr.graal.rpgtournament.Person;

public class RPGTournamentManager extends QMainWindow {

	/************************/
	/**     Attributes     **/
	/************************/
	
	/****************/
	/**     UI     **/
	
	/* The main UI manager */
    Ui_RPGTournamentManager ui = new Ui_RPGTournamentManager();
    MainDataManager mainDataManager = new MainDataManager();
    
    //private Tournament tournament;
    private TournamentSchedule tournamentSchedule;


    public static void main(String[] args) {
        QApplication.initialize(args);

        RPGTournamentManager testRPGTournamentManager = new RPGTournamentManager();
        testRPGTournamentManager.show();

        QApplication.exec();
    }

    public RPGTournamentManager() {
        ui.setupUi(this);
        this.initActions();
        this.initGamesGrids();
        //this.tournament = new Tournament();
    }

    public RPGTournamentManager(QWidget parent) {
        super(parent);
        ui.setupUi(this);
        this.initActions();
        this.initGamesGrids();
        //this.tournament = new Tournament();
    }
    
    private void initActions() {
    	/** File **/
    	/* New Tournament */
    	ui.actionNew_Tournament.setShortcut(tr("Ctrl+N"));
    	ui.actionNew_Tournament.setStatusTip(tr("Create a new tournament"));
    	ui.actionNew_Tournament.triggered.connect(this, "newTournament()");
    	/* Open Tournament */
    	ui.actionOpen_Tournement.setShortcut(tr("Ctrl+O"));
    	ui.actionOpen_Tournement.setStatusTip(tr("Open a tournament"));
    	ui.actionOpen_Tournement.triggered.connect(this, "openTournament()");
    	/* Save Tournament */
    	ui.actionSave_Tournament.setShortcut(tr("Ctrl+S"));
    	ui.actionSave_Tournament.setStatusTip(tr("Save the tournament"));
    	ui.actionSave_Tournament.triggered.connect(this, "saveTournament()");
    	/* Close */
    	ui.actionClose.setShortcut(tr("Alt+F4"));
    	ui.actionClose.setStatusTip(tr("Exit the application"));
    	ui.actionClose.triggered.connect(this, "close()");
    	
    	/** Players **/
    	/* New Player */
    	ui.actionAdd_Player.setShortcut(tr("Ctrl+P"));
    	ui.actionAdd_Player.setStatusTip(tr("Add a new player"));
    	ui.actionAdd_Player.triggered.connect(this, "addPlayer()");
    	/* Show Players */
    	ui.actionShow_Players.setStatusTip(tr("Show a list of all players"));
    	ui.actionShow_Players.triggered.connect(this, "showPlayers()");
    	
    	/** Rounds **/
    	/* Add Round */
    	ui.actionAdd_Round.setShortcut(tr("Ctrl+R"));
    	ui.actionAdd_Round.setStatusTip(tr("Add a new round"));
    	ui.actionAdd_Round.triggered.connect(this, "addRound()");
    	/* Show Rounds */
    	ui.actionShow_Rounds.setStatusTip(tr("Show all rounds in tabs"));
    	ui.actionShow_Rounds.triggered.connect(this, "showRounds()");
    	/* Generate Round */
    	ui.actionGenerate_Round.setStatusTip(tr("Map players with games for all rounds"));
    	ui.actionGenerate_Round.triggered.connect(this, "generateRounds()");
    	
    	/** Games **/
    	/* Add Game */
    	ui.actionAdd_Game.setShortcut(tr("Ctrl+G"));
    	ui.actionAdd_Game.setStatusTip(tr("Add a new game"));
    	ui.actionAdd_Game.triggered.connect(this, "addGame()");
    	/* Show Games Per Round */
    	ui.actionPer_Round.setStatusTip(tr("Show all games for a round"));
    	/* Show All Games */
    	ui.actionAll.setStatusTip(tr("Show all games"));
    	ui.actionAll.triggered.connect(this, "showGames()");
    	
    	/** Results **/
    	/* Generate Results */
    	ui.actionGenerate_Results.setStatusTip(tr("Generate the tournament results"));
    	ui.actionGenerate_Results.triggered.connect(this, "generateResults()");
    	/* Preferences */
    	ui.actionPreferences.setStatusTip(tr("Tournament settings"));
    	ui.actionPreferences.triggered.connect(this, "setPreferences()");
    	
    	
    	/** Others **/
    	/* Updates */
    	ui.actionUpdatePlayer.triggered.connect(this, "updatePlayer()");
    	ui.actionUpdateFridayPlayer.triggered.connect(this, "updateFridayPlayer()");
    	ui.actionUpdateSaturdayPlayer.triggered.connect(this, "updateSaturdayPlayer()");
    	ui.actionUpdateSundayPlayer.triggered.connect(this, "updateSundayPlayer()");

    	ui.actionUpdateFridayGames.triggered.connect(this, "updateFridayGames()");
    	ui.actionUpdateSaturdayGames.triggered.connect(this, "updateSaturdayGames()");
    	ui.actionUpdateSundayGames.triggered.connect(this, "updateSundayGames()");
    }
    
    public void initGamesGrids() {
    	QTableWidget gtw0 = ui.fridayGamesTableWidget;
    	QTableWidget gtw1 = ui.saturdayGamesTableWidget;
    	QTableWidget gtw2 = ui.sundayGamesTableWidget;
    	int dayOneSize, dayTwoSize, dayThreeSize;
    	int dayOneIndex, dayTwoIndex, dayThreeIndex;
		Collections.sort(mainDataManager.gameList);
		
		dayOneSize = gtw0.rowCount();
		dayTwoSize = gtw1.rowCount();
		dayThreeSize = gtw2.rowCount();
		
		for (int i=0; i < dayOneSize; i++) {
			gtw0.removeRow(0);
		}
		
		for (int i=0; i < dayTwoSize; i++) {
			gtw1.removeRow(0);
		}
		
		for (int i=0; i < dayThreeSize; i++) {
			gtw2.removeRow(0);
		}
		
		for (Game game : mainDataManager.gameList) {
			if (game.isDayOne()) {
				dayOneIndex = gtw0.rowCount();
				gtw0.insertRow(dayOneIndex);				
				gtw0.setVerticalHeaderItem(dayOneIndex, new QTableWidgetItem(game.getName()));
			}
			if (game.isDayTwo()) {
				dayTwoIndex = gtw1.rowCount();
				gtw1.insertRow(dayTwoIndex);				
				gtw1.setVerticalHeaderItem(dayTwoIndex, new QTableWidgetItem(game.getName()));
			}
			if (game.isDayThree()) {
				dayThreeIndex = gtw2.rowCount();
				gtw2.insertRow(dayThreeIndex);				
				gtw2.setVerticalHeaderItem(dayThreeIndex, new QTableWidgetItem(game.getName()));
			}
		}
    }
    
    
    /******************************/
    /** Actions functionalities **/
    
    public void newTournament () {
    	
    }
    
    public void openTournament () {
    	
    }
    
    public void saveTournament () {
    	
    }
    
    public void addPlayer () {
    	Ui_PlayerSettings playerDialog = new Ui_PlayerSettings();		
    	QDialog d = new QDialog(this);
    	playerDialog.setupUi(d);


		QTableWidget _qtw0 = playerDialog.tableWidget0;
		QTableWidget _qtw1 = playerDialog.tableWidget1;
		QTableWidget _qtw2 = playerDialog.tableWidget2;
		int dayOneSize, dayTwoSize, dayThreeSize;
		Collections.sort(mainDataManager.gameList);
		
		for (Game game : mainDataManager.gameList) {
			if (game.isDayOne()) {
				dayOneSize = _qtw0.rowCount();
				_qtw0.insertRow(dayOneSize);				
				_qtw0.setVerticalHeaderItem(dayOneSize, new QTableWidgetItem(game.getName()));
			}
			if (game.isDayTwo()) {
				dayTwoSize = _qtw1.rowCount();
				_qtw1.insertRow(dayTwoSize);				
				_qtw1.setVerticalHeaderItem(dayTwoSize, new QTableWidgetItem(game.getName()));
			}
			if (game.isDayThree()) {
				dayThreeSize = _qtw2.rowCount();
				_qtw2.insertRow(dayThreeSize);				
				_qtw2.setVerticalHeaderItem(dayThreeSize, new QTableWidgetItem(game.getName()));
			}
		}
		
    	Person p;
    	String t;
    	Hashtable<Integer,Round> rdList = new Hashtable<Integer,Round>();
    	Hashtable<Integer,String> gmGames;
    	Hashtable<Integer,String> pGames;
    	if (d.exec() == QDialog.DialogCode.Accepted.value()) {
    		// Attention, code moche dupliqué à refactorer !
    		// Première occurence
    		QTableWidget qtw0 = playerDialog.tableWidget0;
    		Round round0 = new Round();
    		gmGames = new Hashtable<Integer,String>();
    		pGames = new Hashtable<Integer,String>();
    		for (int i=0; i < qtw0.rowCount(); i++) {
    			if (qtw0.item(i, 1) != null) {
    				t = qtw0.item(i, 1).text();
    				if (t.compareTo("")!=0)
    					pGames.put(Integer.parseInt(t), qtw0.verticalHeaderItem(i).text());
    			}
    			if (qtw0.item(i, 0) != null) {
    				t = qtw0.item(i, 0).text();
    				if (t.compareTo("")!=0)
    					gmGames.put(Integer.parseInt(t), qtw0.verticalHeaderItem(i).text());
    			}
    		}
    		if (gmGames.size() > 0)
    			round0.setIsMaster();
    		else
    			round0.setIsPlayer();
    		round0.setGmGameList(gmGames);
    		round0.setPGameList(pGames);
    		if (gmGames.size()>0 || pGames.size()>0)
    			rdList.put(0, round0);    			
    		// Seconde occurence
    		QTableWidget qtw1 = playerDialog.tableWidget1;
    		Round round1 = new Round();
    		gmGames = new Hashtable<Integer,String>();
    		pGames = new Hashtable<Integer,String>();
    		for (int i=0; i < qtw1.rowCount(); i++) {
    			if (qtw1.item(i, 1) != null) {
    				t = qtw1.item(i, 1).text();
    				if (t.compareTo("")!=0)
    					pGames.put(Integer.parseInt(t), qtw1.verticalHeaderItem(i).text());
    			}
    			if (qtw1.item(i, 0) != null) {
    				t = qtw1.item(i, 0).text();
    				if (t.compareTo("")!=0)
    					gmGames.put(Integer.parseInt(t), qtw1.verticalHeaderItem(i).text());
    			}
    		}
    		if (gmGames.size() > 0)
    			round1.setIsMaster();
    		else
    			round1.setIsPlayer();
    		round1.setGmGameList(gmGames);
    		round1.setPGameList(pGames);
    		if (gmGames.size()>0 || pGames.size()>0)
    			rdList.put(1, round1);
    		// Troisième occurence
    		QTableWidget qtw2 = playerDialog.tableWidget2;
    		Round round2 = new Round();
    		gmGames = new Hashtable<Integer,String>();
    		pGames = new Hashtable<Integer,String>();
    		for (int i=0; i < qtw2.rowCount(); i++) {
    			if (qtw2.item(i, 1) != null) {
    				t = qtw2.item(i, 1).text();
    				if (t.compareTo("")!=0)
    					pGames.put(Integer.parseInt(t), qtw2.verticalHeaderItem(i).text());
    			}
    			if (qtw2.item(i, 0) != null) {
    				t = qtw2.item(i, 0).text();
    				if (t.compareTo("")!=0)
    					gmGames.put(Integer.parseInt(t), qtw2.verticalHeaderItem(i).text());
    			}
    		}
    		if (gmGames.size() > 0)
    			round2.setIsMaster();
    		else
    			round2.setIsPlayer();
    		round2.setGmGameList(gmGames);
    		round2.setPGameList(pGames);
    		if (gmGames.size()>0 || pGames.size()>0)	
    			rdList.put(2, round2);
    		
    		p = new Person(playerDialog.lineEdit_LastName.text(),
    				playerDialog.lineEdit_FirstName.text(),
    				(playerDialog.dateEdit_Born.dateTime().daysTo(QDateTime.currentDateTime()))/365,
    				playerDialog.radioButton.isChecked(),
    				playerDialog.lineEdit_Address.text(),
    				playerDialog.lineEdit_PostalCode.text(),
    				playerDialog.lineEdit_City.text(),
    				playerDialog.lineEdit_Phone.text(),
    				playerDialog.lineEdit_Email.text(),
    				null,
    				null,
    				playerDialog.checkBox_Spam.isChecked(),
    				Integer.parseInt(playerDialog.lineEdit_YearsOfRPG.text().length()>0?playerDialog.lineEdit_YearsOfRPG.text():"0"),
    				playerDialog.comboBox_Club.currentText().length()>0,
    				playerDialog.comboBox_Club.currentText(),
    				playerDialog.dateEdit.date().toString(Qt.DateFormat.SystemLocaleShortDate),
    				playerDialog.checkBox_Paid.isChecked(),
    				rdList);
    		mainDataManager.addPerson(p);
    		this.showPlayers();
    	}
    }
    
    public void showPlayers () {
		ArrayList<Person> list = mainDataManager.getPlayerList();
		QTableWidget aptw = ui.allPlayersTableWidget;
		QTableWidget frtw = ui.fridayTableWidget;
		QTableWidget satw = ui.saturdayTableWidget;
		QTableWidget sutw = ui.sundayTableWidget;
		
		this.initGamesGrids();
		
		int row = aptw.rowCount();
		for (int r=0; r<row; r++) {
			aptw.removeRow(row);
		}
		aptw.setRowCount(0);
		row = frtw.rowCount();
		for (int r=0; r<row; r++) {
			frtw.removeRow(row);
		}
		frtw.setRowCount(0);
		row = satw.rowCount();
		for (int r=0; r<row; r++) {
			satw.removeRow(row);
		}
		satw.setRowCount(0);
		row = sutw.rowCount();
		for (int r=0; r<row; r++) {
			sutw.removeRow(row);
		}
		sutw.setRowCount(0);
		
    	
    	Person curPerson;
    	int fridayGM=0, fridayPL=0, saturdayGM=0, saturdayPL=0, sundayGM=0, sundayPL=0;
    	for (int i=0; i < list.size(); i++) {
    		curPerson = (Person)list.get(i);
    		row = aptw.rowCount();
    		aptw.insertRow(row);
    		aptw.setSortingEnabled(false);
    		int plNb=0, gmNb=0;
    		for(int r=0; r<curPerson.getPlayerNotation().size(); r++) {
    			if (curPerson.getPlayerNotation().getNotation(r+1).getType() == Notation.PLAYER)
    				plNb++;
    			else if (curPerson.getPlayerNotation().getNotation(r+1).getType() == Notation.GAME_MASTER)
    				gmNb++;    				
    		}
    		aptw.setItem(i, 0, new QTableWidgetItem(curPerson.getName()));
    		aptw.setItem(i, 1, new QTableWidgetItem(curPerson.getFirstName()));
    		aptw.setItem(i, 2, new QTableWidgetItem(gmNb + ""));
    		aptw.setItem(i, 3, new QTableWidgetItem(plNb + ""));
    		aptw.setItem(i, 4, new QTableWidgetItem(getPlayerPosition(curPerson) + ""));
    		aptw.setItem(i, 5, new QTableWidgetItem(getPlayerType(curPerson)));
    		aptw.setItem(i, 6, new QTableWidgetItem(curPerson.alreadyPaid()?"Yes":"No"));
    		aptw.setSortingEnabled(true);
        	/* Fill FRIDAY */
    		if (curPerson.getRoundList().get(0) != null) {
        		row = frtw.rowCount();
	    		// Players
    			frtw.insertRow(row);
    			frtw.setSortingEnabled(false);
    			frtw.setItem(row, 0, new QTableWidgetItem(curPerson.getName()));
    			frtw.setItem(row, 1, new QTableWidgetItem(curPerson.getFirstName()));
    			frtw.setItem(row, 2, new QTableWidgetItem(curPerson.getPlayerNotation().getNotation(1).getNote() + ""));
    			frtw.setItem(row, 3, new QTableWidgetItem(curPerson.getPlayerNotation().getNotation(1).getGame()));
    			frtw.setSortingEnabled(true);
	    		// Totals
	    		if (curPerson.getRoundList().get(0).isMaster())
	    			fridayGM++;
	    		else
	    			fridayPL++;
    		}
        	/* Fill SATURDAY */
    		if (curPerson.getRoundList().get(1) != null) {
        		row = satw.rowCount();
    			satw.insertRow(row);
	    		satw.setSortingEnabled(false);
	    		satw.setItem(row, 0, new QTableWidgetItem(curPerson.getName()));
	    		satw.setItem(row, 1, new QTableWidgetItem(curPerson.getFirstName()));
	    		satw.setItem(row, 2, new QTableWidgetItem(curPerson.getPlayerNotation().getNotation(2).getNote() + ""));
	    		satw.setItem(row, 3, new QTableWidgetItem(curPerson.getPlayerNotation().getNotation(2).getGame()));
	    		satw.setSortingEnabled(true);
	    		// Totals
	    		if (curPerson.getRoundList().get(1).isMaster())
	    			saturdayGM++;
	    		else
	    			saturdayPL++;
    		}
        	/* Fill SUNDAY */
    		if (curPerson.getRoundList().get(2) != null) {
        		row = sutw.rowCount();
    			sutw.insertRow(row);
	    		sutw.setSortingEnabled(false);
	    		sutw.setItem(row, 0, new QTableWidgetItem(curPerson.getName()));
	    		sutw.setItem(row, 1, new QTableWidgetItem(curPerson.getFirstName()));
	    		sutw.setItem(row, 2, new QTableWidgetItem(curPerson.getPlayerNotation().getNotation(3).getNote() + ""));
	    		sutw.setItem(row, 3, new QTableWidgetItem(curPerson.getPlayerNotation().getNotation(3).getGame()));
	    		sutw.setSortingEnabled(true);
	    		// Totals
	    		if (curPerson.getRoundList().get(2).isMaster())
	    			sundayGM++;
	    		else
	    			sundayPL++;
    		}
    	}
    	ui.fridayGMLineEdit.setText("" + fridayGM);
    	ui.fridayPLineEdit.setText("" + fridayPL);
    	ui.saturdayGMLineEdit.setText("" + saturdayGM);
    	ui.saturdayPLineEdit.setText("" + saturdayPL);
    	ui.sundayGMLineEdit.setText("" + sundayGM);
    	ui.sundayPLineEdit.setText("" + sundayPL);
    	
    }
    

    
    public void updateFridayPlayer () {
    	/* Personal Info */
		QTableWidget qtw = ui.fridayTableWidget;
		if (qtw.selectedItems().size() > 0) {
	    	int row = qtw.selectedItems().get(0).row();
	    	String ln = qtw.item(row, 0).text();
	    	String fn = qtw.item(row, 1).text();
	    	Person player = mainDataManager.findPerson(ln, fn);
	    	if (player.getRoundList().get(0) != null) {
	    		if (qtw.item(row, 2).text().compareTo("")!=0)
	    			player.getPlayerNotation().getNotation(1).setNote(Integer.parseInt(qtw.item(row, 2).text()));
		    	player.getPlayerNotation().getNotation(1).setGame(qtw.item(row, 3).text());
	    	}
	    	
	    	/* Games */
	    	String t;
	    	Hashtable<Integer,Round> rdList = new Hashtable<Integer,Round>();
	    	Hashtable<Integer,String> gmGames;
	    	Hashtable<Integer,String> pGames;
			// Attention, code moche dupliqué à refactorer !
			// Première occurence
			Round round0 = new Round();
			QTableWidget qtw0 = ui.fridayGamesTableWidget;
			gmGames = new Hashtable<Integer,String>();
			pGames = new Hashtable<Integer,String>();
			for (int i=0; i < qtw0.rowCount(); i++) {
				if (qtw0.item(i, 1) != null) {
					t = qtw0.item(i, 1).text();
					if (t.compareTo("")!=0)
						pGames.put(Integer.parseInt(t), qtw0.verticalHeaderItem(i).text());
				}
				if (qtw0.item(i, 0) != null) {
					t = qtw0.item(i, 0).text();
					if (t.compareTo("")!=0)
						gmGames.put(Integer.parseInt(t), qtw0.verticalHeaderItem(i).text());
				}
			}
			if (gmGames.size() > 0)
				player.getRoundList().get(0).setIsMaster();
			else
				player.getRoundList().get(0).setIsPlayer();
			player.getRoundList().get(0).setGmGameList(gmGames);
			player.getRoundList().get(0).setPGameList(pGames);
			
			mainDataManager.savePerson(player);
		}
    }
    
    public void updateSaturdayPlayer () {
    	/* Personal Info */
		QTableWidget qtw = ui.saturdayTableWidget;
		if (qtw.selectedItems().size() > 0) {
	    	int row = qtw.selectedItems().get(0).row();
	    	String ln = qtw.item(row, 0).text();
	    	String fn = qtw.item(row, 1).text();
	    	Person player = mainDataManager.findPerson(ln, fn);
	    	if (player.getRoundList().get(1) != null) {
	    		if (qtw.item(row, 2).text().compareTo("")!=0)
	    			player.getPlayerNotation().getNotation(2).setNote(Integer.parseInt(qtw.item(row, 2).text()));
		    	player.getPlayerNotation().getNotation(2).setGame(qtw.item(row, 3).text());
	    	}
	    	
	    	/* Games */
	    	String t;
	    	Hashtable<Integer,Round> rdList = new Hashtable<Integer,Round>();
	    	Hashtable<Integer,String> gmGames;
	    	Hashtable<Integer,String> pGames;
			// Attention, code moche dupliqué à refactorer !
			// Première occurence
			Round round0 = new Round();
			QTableWidget qtw0 = ui.saturdayGamesTableWidget;
			gmGames = new Hashtable<Integer,String>();
			pGames = new Hashtable<Integer,String>();
			for (int i=0; i < qtw0.rowCount(); i++) {
				if (qtw0.item(i, 1) != null) {
					t = qtw0.item(i, 1).text();
					if (t.compareTo("")!=0)
						pGames.put(Integer.parseInt(t), qtw0.verticalHeaderItem(i).text());
				}
				if (qtw0.item(i, 0) != null) {
					t = qtw0.item(i, 0).text();
					if (t.compareTo("")!=0)
						gmGames.put(Integer.parseInt(t), qtw0.verticalHeaderItem(i).text());
				}
			}
			if (gmGames.size() > 0)
				player.getRoundList().get(1).setIsMaster();
			else
				player.getRoundList().get(1).setIsPlayer();
			player.getRoundList().get(1).setGmGameList(gmGames);
			player.getRoundList().get(1).setPGameList(pGames);
			
			mainDataManager.savePerson(player);
		}
    }
    
    public void updateSundayPlayer () {
    	/* Personal Info */
		QTableWidget qtw = ui.sundayTableWidget;
		if (qtw.selectedItems().size() > 0) {
	    	int row = qtw.selectedItems().get(0).row();
	    	String ln = qtw.item(row, 0).text();
	    	String fn = qtw.item(row, 1).text();
	    	Person player = mainDataManager.findPerson(ln, fn);
	    	if (player.getRoundList().get(2) != null) {
	    		if (qtw.item(row, 2).text().compareTo("")!=0)
	    			player.getPlayerNotation().getNotation(3).setNote(Integer.parseInt(qtw.item(row, 2).text()));
		    	player.getPlayerNotation().getNotation(3).setGame(qtw.item(row, 3).text());
	    	}
	    	
	    	/* Games */
	    	String t;
	    	Hashtable<Integer,Round> rdList = new Hashtable<Integer,Round>();
	    	Hashtable<Integer,String> gmGames;
	    	Hashtable<Integer,String> pGames;
			// Attention, code moche dupliqué à refactorer !
			// Première occurence
			Round round0 = new Round();
			QTableWidget qtw0 = ui.sundayGamesTableWidget;
			gmGames = new Hashtable<Integer,String>();
			pGames = new Hashtable<Integer,String>();
			for (int i=0; i < qtw0.rowCount(); i++) {
				if (qtw0.item(i, 1) != null) {
					t = qtw0.item(i, 1).text();
					if (t.compareTo("")!=0)
						pGames.put(Integer.parseInt(t), qtw0.verticalHeaderItem(i).text());
				}
				if (qtw0.item(i, 0) != null) {
					t = qtw0.item(i, 0).text();
					if (t.compareTo("")!=0)
						gmGames.put(Integer.parseInt(t), qtw0.verticalHeaderItem(i).text());
				}
			}
			if (gmGames.size() > 0)
				player.getRoundList().get(2).setIsMaster();
			else
				player.getRoundList().get(2).setIsPlayer();
			player.getRoundList().get(2).setGmGameList(gmGames);
			player.getRoundList().get(2).setPGameList(pGames);
			
			mainDataManager.savePerson(player);
		}
    }
    
    public void updateFridayGames () {
    	/* Personal Info */
		QTableWidget qtw = ui.fridayTableWidget;
		if (qtw.selectedItems().size() > 0) {
	    	int row = qtw.selectedItems().get(0).row();
	    	String ln = qtw.item(row, 0).text();
	    	String fn = qtw.item(row, 1).text();
	    	Person player = mainDataManager.findPerson(ln, fn);
	    	
	    	/* Games */
	    	Hashtable<Integer,String> gmGames = (Hashtable<Integer, String>) player.getRoundList().get(0).getGmGamesList();
	    	Hashtable<Integer,String> pGames = (Hashtable<Integer, String>) player.getRoundList().get(0).getPGamesList();
	    	
	    	QTableWidget gtw = ui.fridayGamesTableWidget;
			
	    	gtw.clearContents();
	    	String rowTitle;
	    	Integer key;
	    	for (int i=0; i < gtw.rowCount(); i++) {
	    		rowTitle = gtw.verticalHeaderItem(i).text();
	    		// GM Games
	    		Set<Integer> gmSet = gmGames.keySet();
	    	    Iterator<Integer> gmItr = gmSet.iterator();
	    	    while (gmItr.hasNext()) {
	    	    	key = gmItr.next();
	    	    	if ((key != null) && (gmGames.get(key).compareTo(rowTitle) == 0)) {
	    	    		gtw.setItem(i, 0, new QTableWidgetItem(key.toString()));
	    	    	}
	    	    }
	    	    // GM Games
	    		Set<Integer> plSet = pGames.keySet();
	    	    Iterator<Integer> plItr = plSet.iterator();
	    	    while (plItr.hasNext()) {
	    	    	key = plItr.next();
	    	    	if ((key != null) && (pGames.get(key).compareTo(rowTitle) == 0)) {
	    	    		gtw.setItem(i, 1, new QTableWidgetItem(key.toString()));
	    	    	}
	    	    }
	    	}  	
		}
    }
    
    public void updateSaturdayGames () {
    	/* Personal Info */
		QTableWidget qtw = ui.saturdayTableWidget;
		if (qtw.selectedItems().size() > 0) {
	    	int row = qtw.selectedItems().get(0).row();
	    	String ln = qtw.item(row, 0).text();
	    	String fn = qtw.item(row, 1).text();
	    	Person player = mainDataManager.findPerson(ln, fn);
	    	
	    	/* Games */
	    	Hashtable<Integer,String> gmGames = (Hashtable<Integer, String>) player.getRoundList().get(1).getGmGamesList();
	    	Hashtable<Integer,String> pGames = (Hashtable<Integer, String>) player.getRoundList().get(1).getPGamesList();
	    	
	    	QTableWidget gtw = ui.saturdayGamesTableWidget;
			
	    	gtw.clearContents();
	    	String rowTitle;
	    	Integer key;
	    	for (int i=0; i < gtw.rowCount(); i++) {
	    		rowTitle = gtw.verticalHeaderItem(i).text();
	    		// GM Games
	    		Set<Integer> gmSet = gmGames.keySet();
	    	    Iterator<Integer> gmItr = gmSet.iterator();
	    	    while (gmItr.hasNext()) {
	    	    	key = gmItr.next();
	    	    	if ((key != null) && (gmGames.get(key).compareTo(rowTitle) == 0)) {
	    	    		gtw.setItem(i, 0, new QTableWidgetItem(key.toString()));
	    	    	}
	    	    }
	    	    // GM Games
	    		Set<Integer> plSet = pGames.keySet();
	    	    Iterator<Integer> plItr = plSet.iterator();
	    	    while (plItr.hasNext()) {
	    	    	key = plItr.next();
	    	    	if ((key != null) && (pGames.get(key).compareTo(rowTitle) == 0)) {
	    	    		gtw.setItem(i, 1, new QTableWidgetItem(key.toString()));
	    	    	}
	    	    }
	    	}  	
		}
    }
    
    public void updateSundayGames () {
    	/* Personal Info */
		QTableWidget qtw = ui.sundayTableWidget;
		if (qtw.selectedItems().size() > 0) {
	    	int row = qtw.selectedItems().get(0).row();
	    	String ln = qtw.item(row, 0).text();
	    	String fn = qtw.item(row, 1).text();
	    	Person player = mainDataManager.findPerson(ln, fn);
	    	
	    	/* Games */
	    	Hashtable<Integer,String> gmGames = (Hashtable<Integer, String>) player.getRoundList().get(2).getGmGamesList();
	    	Hashtable<Integer,String> pGames = (Hashtable<Integer, String>) player.getRoundList().get(2).getPGamesList();
	    	
	    	QTableWidget gtw = ui.sundayGamesTableWidget;
			
			gtw.clearContents();
	    	String rowTitle;
	    	Integer key;
	    	for (int i=0; i < gtw.rowCount(); i++) {
	    		rowTitle = gtw.verticalHeaderItem(i).text();
	    		// GM Games
	    		Set<Integer> gmSet = gmGames.keySet();
	    	    Iterator<Integer> gmItr = gmSet.iterator();
	    	    while (gmItr.hasNext()) {
	    	    	key = gmItr.next();
	    	    	if ((key != null) && (gmGames.get(key).compareTo(rowTitle) == 0)) {
	    	    		gtw.setItem(i, 0, new QTableWidgetItem(key.toString()));
	    	    	}
	    	    }
	    	    // GM Games
	    		Set<Integer> plSet = pGames.keySet();
	    	    Iterator<Integer> plItr = plSet.iterator();
	    	    while (plItr.hasNext()) {
	    	    	key = plItr.next();
	    	    	if ((key != null) && (pGames.get(key).compareTo(rowTitle) == 0)) {
	    	    		gtw.setItem(i, 1, new QTableWidgetItem(key.toString()));
	    	    	}
	    	    }
	    	}  	
		}
    }
    
    public void addRound () {
    	
    }
    
    public void showRounds () {
    	Ui_RoundPrompt roundDialog = new Ui_RoundPrompt();
    	QDialog d = new QDialog(this);
    	roundDialog.setupUi(d);
    	if (tournamentSchedule != null) {
        	roundDialog.actionPrintFridayTables.triggered.connect(this, "printFridayTables()");
        	roundDialog.actionPrintSaturdayTables.triggered.connect(this, "printSaturdayTables()");
        	roundDialog.actionPrintSundayTables.triggered.connect(this, "printSundayTables()");
	    	roundDialog.fridayRoundTextBrowser.setText(tournamentSchedule.tableListToString(0));
	    	roundDialog.saturdayRoundTextBrowser.setText(tournamentSchedule.tableListToString(1));
	    	roundDialog.sundayRoundTextBrowser.setText(tournamentSchedule.tableListToString(2));
	    	if (d.exec() == QDialog.DialogCode.Accepted.value()) {
	    		//tournamentSchedule.save();    	
	    	}
    	}
    }
    
    public void generateRounds () {
    	tournamentSchedule = new TournamentSchedule();
    	tournamentSchedule.computeTournamentSchedule(RPGTournamentMngrConstants.nbrOfRound,mainDataManager.getPlayerList());
    	//
    	this.showRounds();
        //
    }
    
    public void addGame () {
    	Ui_GameSettings gameDialog = new Ui_GameSettings();
    	QDialog d = new QDialog(this);
    	gameDialog.setupUi(d);
    	Game g;
    	if (d.exec() == QDialog.DialogCode.Accepted.value()) {
    		g = new Game(gameDialog.lineEdit_gameName.text(),
    				gameDialog.checkBox_Day1.isChecked(),
    				gameDialog.checkBox_Day2.isChecked(),
    				gameDialog.checkBox_Day3.isChecked(), 
    				new Integer(gameDialog.lineEdit_gameIndex.text()));
    		mainDataManager.addGame(g);
    		this.showPlayers();
    	}
    }
    
    public void showGames () {
    	//setCentralWidget(widget);
    }
    
    public void generateResults () {
    	Ui_ResultsPrompt resultsDialog = new Ui_ResultsPrompt();
    	QDialog d = new QDialog(this);
    	resultsDialog.setupUi(d);
    	resultsDialog.resultsTabWidget.setTabText(0, "Classement MJ");
    	resultsDialog.resultsTabWidget.setTabText(1, "Classement PJ");
    	
    	//setCentralWidget(widget);
		ArrayList<Person> playerList = mainDataManager.getPlayerList();
		mainDataManager.pcList.removeAll(mainDataManager.pcList);
		mainDataManager.gmList.removeAll(mainDataManager.gmList);
		
		for (Person player : playerList) {
			if (player.getPlayerNoteAsPC().getNote() != 0) {
				mainDataManager.pcList.add(player);
			}
			if (player.getPlayerNoteAsGM().getNote() != 0) {
				mainDataManager.gmList.add(player);
			}
		}
		
		Collections.sort(mainDataManager.pcList, new PCComparator());
		Collections.sort(mainDataManager.gmList, new GMComparator());
		
		for (Person player : playerList) {
			int pci = mainDataManager.pcList.indexOf(player);
			int gmi = mainDataManager.gmList.indexOf(player);
			
			if (gmi != -1 && pci != -1) {
				if (pci < gmi) {
					// si le joueur est mieux classé PJ que MJ
					// on l'enlève de la liste des MJ
					mainDataManager.gmList.remove(player);
				} else {
					// si le joueur est mieux classé MJ que PJ (ou équivalent)
					// on l'enlève de la liste des PJ
					mainDataManager.pcList.remove(player);				
				}
			}
		}
		
		resultsDialog.actionPrintGMTables.triggered.connect(this, "printGMTables()");
		resultsDialog.actionPrintPCTables.triggered.connect(this, "printPCTables()");
		resultsDialog.gmResultsTextBrowser.setText(this.playerListToString(Notation.GAME_MASTER));
		resultsDialog.pcResultsTextBrowser.setText(this.playerListToString(Notation.PLAYER));
    	if (d.exec() == QDialog.DialogCode.Accepted.value()) {
    		//tournamentSchedule.save();    	
    	}
    }
    


	public String playerListToString(String type) {
		ArrayList<Person> playerList = new ArrayList<Person>();
		String returnedString = "";
		
		if (type.equals(Notation.PLAYER)) {
			playerList = mainDataManager.pcList;
		} else if (type.equals(Notation.GAME_MASTER)) {
			playerList = mainDataManager.gmList;
		} else {
			throw new IllegalArgumentException("Mauvais type");
		}
		
		if (!playerList.isEmpty()) {
			int i = 1;
			for (Person player : playerList) {
				returnedString += i + ". " + player.toString() + "\n";
				i++;
			}
		}
		return returnedString;
	}
    
    public int getPlayerPosition(Person player) {
		int pci = mainDataManager.pcList.indexOf(player);
		int gmi = mainDataManager.gmList.indexOf(player);
		
		return Math.max(pci, gmi) + 1;
    }
    

    
    public String getPlayerType(Person player) {
		int pci = mainDataManager.pcList.indexOf(player);
		int gmi = mainDataManager.gmList.indexOf(player);
		
		if (pci != -1 && gmi != -1) {
			if (pci < gmi) {
				return Notation.PLAYER;
			} else {
				return Notation.GAME_MASTER;
			}
		} else if (pci == -1 && gmi != -1) {
			return Notation.GAME_MASTER;
		} else if (pci != -1 && gmi == -1) {
			return Notation.PLAYER;
		} else {
			return "-";
		}
    }
    
    public void setPreferences () {
    	
    }
    
    public void updatePlayer () {
    	QTableWidget qtw = ui.allPlayersTableWidget;
		if (qtw.selectedItems().size() > 0) {
	    	int row = qtw.selectedItems().get(0).row();
	    	String ln = qtw.item(row, 0).text();
	    	String fn = qtw.item(row, 1).text();
	    	Person player = mainDataManager.findPerson(ln, fn);
	    	if (qtw.selectedItems().get(0).text().compareToIgnoreCase("Yes") == 0) {
	    		player.setAlreadyPaid(true);
	    	} else {
	    		player.setAlreadyPaid(false);
	    	}
			
			mainDataManager.savePerson(player);
		}
    }
    
    public void printFridayTables() {
    	
    	int nRound = 0;
    	ArrayList<Table> tableList = (ArrayList<Table>) tournamentSchedule.getTournamentSchedule().get(new Integer(0));
    	
    	PrinterJob printJob = PrinterJob.getPrinterJob ();
		Book book = new Book ();
		Vector printInBook = new Vector();
		Paper papier = new Paper();
		papier.setImageableArea(0.0, 0.0, papier.getWidth(), papier.getHeight());
		
		PageFormat documentPageFormat = new PageFormat  ();
		documentPageFormat.setOrientation (PageFormat.LANDSCAPE);
		documentPageFormat.setPaper(papier);
		  
		  
		//create printing list and add in printing book
		for (int j=0 ; j < tableList.size(); j++ ) {
			printInBook.add(new PrintRound (nRound,j,(Table) tableList.get(j)));
			book.append ((Printable) printInBook.elementAt(j), documentPageFormat);         
		}
		  
		printJob.setPageable (book); 
		 
		if (printJob.printDialog()) {
		   try {
		      printJob.print();  
		   } catch (Exception PrintException) {
		      PrintException.printStackTrace();
		   }        
		}  
    }
    
	public void printSaturdayTables() {
		int nRound = 1;
    	ArrayList<Table> tableList = (ArrayList<Table>) tournamentSchedule.getTournamentSchedule().get(new Integer(1));
    	
    	PrinterJob printJob = PrinterJob.getPrinterJob ();
		Book book = new Book ();
		Vector printInBook = new Vector();
		Paper papier = new Paper();
		papier.setImageableArea(0.0, 0.0, papier.getWidth(), papier.getHeight());
		
		PageFormat documentPageFormat = new PageFormat  ();
		documentPageFormat.setOrientation (PageFormat.LANDSCAPE);
		documentPageFormat.setPaper(papier);
		  
		  
		//create printing list and add in printing book
		for (int j=0 ; j < tableList.size(); j++ ) {
			printInBook.add(new PrintRound (nRound,j,(Table) tableList.get(j)));
			book.append ((Printable) printInBook.elementAt(j), documentPageFormat);         
		}
		  
		printJob.setPageable (book); 
		 
		if (printJob.printDialog()) {
		   try {
		      printJob.print();  
		   } catch (Exception PrintException) {
		      PrintException.printStackTrace();
		   }        
		}  
	 }
	
	public void printSundayTables() {
		int nRound = 2;
    	ArrayList<Table> tableList = (ArrayList<Table>) tournamentSchedule.getTournamentSchedule().get(new Integer(2));
    	
    	PrinterJob printJob = PrinterJob.getPrinterJob ();
		Book book = new Book ();
		Vector printInBook = new Vector();
		Paper papier = new Paper();
		papier.setImageableArea(0.0, 0.0, papier.getWidth(), papier.getHeight());
		
		PageFormat documentPageFormat = new PageFormat  ();
		documentPageFormat.setOrientation (PageFormat.LANDSCAPE);
		documentPageFormat.setPaper(papier);
		  
		  
		//create printing list and add in printing book
		for (int j=0 ; j < tableList.size(); j++ ) {
			printInBook.add(new PrintRound (nRound,j,(Table) tableList.get(j)));
			book.append ((Printable) printInBook.elementAt(j), documentPageFormat);         
		}
		  
		printJob.setPageable (book); 
		 
		if (printJob.printDialog()) {
		   try {
		      printJob.print();  
		   } catch (Exception PrintException) {
		      PrintException.printStackTrace();
		   }        
		}  
	}
	
	public void printPCTables() {
	}
	
	public void printGMTables() {
	}

    
}

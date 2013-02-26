package fr.graal.rpgtournament.ui;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.trolltech.qt.core.QDateTime;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QTableWidget;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;

import fr.graal.rpgtournament.RPGTournamentMngrConstants;
import fr.graal.rpgtournament.game.Game;
import fr.graal.rpgtournament.game.Table;
import fr.graal.rpgtournament.notation.Notation;
import fr.graal.rpgtournament.player.GMComparator;
import fr.graal.rpgtournament.player.PCComparator;
import fr.graal.rpgtournament.player.Player;
import fr.graal.rpgtournament.player.Player.Gender;
import fr.graal.rpgtournament.print.PrintRound;
import fr.graal.rpgtournament.tournament.Round;
import fr.graal.rpgtournament.tournament.RoundWishes;
import fr.graal.rpgtournament.tournament.TournamentSchedule;

public class RPGTournamentManager extends QMainWindow {

	/************************/
	/** Attributes **/
	/************************/

	/****************/
	/** UI **/

	/* The main UI manager */
	Ui_RPGTournamentManager ui = new Ui_RPGTournamentManager();
	MainDataManager mainDataManager = new MainDataManager();

	Map<Integer, RoundWidgets> roundWidgets = new HashMap<Integer, RoundWidgets>();

	// private Tournament tournament;
	private TournamentSchedule tournamentSchedule;

	private static final int FRIDAY_ROUND = 0;
	private static final int SATURDAY_ROUND = 1;
	private static final int SUNDAY_ROUND = 2;
	
	private static final String NO_NOTE = "-";

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
		this.initRoundWidgets();
		// this.tournament = new Tournament();
	}

	public RPGTournamentManager(QWidget parent) {
		super(parent);
		ui.setupUi(this);
		this.initActions();
		this.initGamesGrids();
		this.initRoundWidgets();
		// this.tournament = new Tournament();
	}

	private void initRoundWidgets() {
		// Friday
		RoundWidgets fridayWidgets = new RoundWidgets(FRIDAY_ROUND,
				ui.fridayPLineEdit, ui.fridayGMLineEdit, ui.fridayTableWidget);
		roundWidgets.put(FRIDAY_ROUND, fridayWidgets);
		// Saturday
		RoundWidgets saturdayWidgets = new RoundWidgets(SATURDAY_ROUND,
				ui.saturdayPLineEdit, ui.saturdayGMLineEdit,
				ui.saturdayTableWidget);
		roundWidgets.put(SATURDAY_ROUND, saturdayWidgets);
		// Sunday
		RoundWidgets sundayWidgets = new RoundWidgets(SUNDAY_ROUND,
				ui.sundayPLineEdit, ui.sundayGMLineEdit, ui.sundayTableWidget);
		roundWidgets.put(SUNDAY_ROUND, sundayWidgets);
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
		ui.actionGenerate_Round
				.setStatusTip(tr("Map players with games for all rounds"));
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
		ui.actionGenerate_Results
				.setStatusTip(tr("Generate the tournament results"));
		ui.actionGenerate_Results.triggered.connect(this, "generateResults()");
		/* Preferences */
		ui.actionPreferences.setStatusTip(tr("Tournament settings"));
		ui.actionPreferences.triggered.connect(this, "setPreferences()");

		/** Others **/
		/* Updates */
		ui.actionUpdatePlayer.triggered.connect(this, "updatePlayer()");
		ui.actionUpdateFridayPlayer.triggered.connect(this,
				"updateFridayPlayer()");
		ui.actionUpdateSaturdayPlayer.triggered.connect(this,
				"updateSaturdayPlayer()");
		ui.actionUpdateSundayPlayer.triggered.connect(this,
				"updateSundayPlayer()");

		ui.actionUpdateFridayGames.triggered.connect(this,
				"updateFridayGames()");
		ui.actionUpdateSaturdayGames.triggered.connect(this,
				"updateSaturdayGames()");
		ui.actionUpdateSundayGames.triggered.connect(this,
				"updateSundayGames()");
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

		for (int i = 0; i < dayOneSize; i++) {
			gtw0.removeRow(0);
		}

		for (int i = 0; i < dayTwoSize; i++) {
			gtw1.removeRow(0);
		}

		for (int i = 0; i < dayThreeSize; i++) {
			gtw2.removeRow(0);
		}

		for (Game game : mainDataManager.gameList) {
			if (game.isDayOne()) {
				dayOneIndex = gtw0.rowCount();
				gtw0.insertRow(dayOneIndex);
				gtw0.setVerticalHeaderItem(dayOneIndex, new QTableWidgetItem(
						game.getName()));
			}
			if (game.isDayTwo()) {
				dayTwoIndex = gtw1.rowCount();
				gtw1.insertRow(dayTwoIndex);
				gtw1.setVerticalHeaderItem(dayTwoIndex, new QTableWidgetItem(
						game.getName()));
			}
			if (game.isDayThree()) {
				dayThreeIndex = gtw2.rowCount();
				gtw2.insertRow(dayThreeIndex);
				gtw2.setVerticalHeaderItem(dayThreeIndex, new QTableWidgetItem(
						game.getName()));
			}
		}
	}

	/******************************/
	/** Actions functionalities **/

	public void newTournament() {

	}

	public void openTournament() {

	}

	public void saveTournament() {

	}

	public void addPlayer() {
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
				_qtw0.setVerticalHeaderItem(dayOneSize, new QTableWidgetItem(
						game.getName()));
			}
			if (game.isDayTwo()) {
				dayTwoSize = _qtw1.rowCount();
				_qtw1.insertRow(dayTwoSize);
				_qtw1.setVerticalHeaderItem(dayTwoSize, new QTableWidgetItem(
						game.getName()));
			}
			if (game.isDayThree()) {
				dayThreeSize = _qtw2.rowCount();
				_qtw2.insertRow(dayThreeSize);
				_qtw2.setVerticalHeaderItem(dayThreeSize, new QTableWidgetItem(
						game.getName()));
			}
		}

		Player player;
		String t;
		Hashtable<Integer, RoundWishes> rdList = new Hashtable<Integer, RoundWishes>();
		Hashtable<Integer, Game> gmGames;
		Hashtable<Integer, Game> pGames;
		if (d.exec() == QDialog.DialogCode.Accepted.value()) {
			// Attention, code moche dupliqué à refactorer !
			// Première occurence
			QTableWidget qtw0 = playerDialog.tableWidget0;
			RoundWishes round0 = new RoundWishes();
			gmGames = new Hashtable<Integer, Game>();
			pGames = new Hashtable<Integer, Game>();
			for (int i = 0; i < qtw0.rowCount(); i++) {
				String gameTitle = qtw0.verticalHeaderItem(i).text();
				Game game = loadGame(gameTitle);
				if (qtw0.item(i, 1) != null) {
					t = qtw0.item(i, 1).text();
					if (t.compareTo("") != 0)
						pGames.put(Integer.parseInt(t), game);
				}
				if (qtw0.item(i, 0) != null) {
					t = qtw0.item(i, 0).text();
					if (t.compareTo("") != 0)
						gmGames.put(Integer.parseInt(t), game);
				}
			}
			if (gmGames.size() > 0)
				round0.setIsMaster();
			else
				round0.setIsPlayer();
			round0.setGmGameList(gmGames);
			round0.setPGameList(pGames);
			if (gmGames.size() > 0 || pGames.size() > 0)
				rdList.put(0, round0);
			// Seconde occurence
			QTableWidget qtw1 = playerDialog.tableWidget1;
			RoundWishes round1 = new RoundWishes();
			gmGames = new Hashtable<Integer, Game>();
			pGames = new Hashtable<Integer, Game>();
			for (int i = 0; i < qtw1.rowCount(); i++) {
				String gameTitle = qtw1.verticalHeaderItem(i).text();
				Game game = loadGame(gameTitle);
				if (qtw1.item(i, 1) != null) {
					t = qtw1.item(i, 1).text();
					if (t.compareTo("") != 0)
						pGames.put(Integer.parseInt(t), game);
				}
				if (qtw1.item(i, 0) != null) {
					t = qtw1.item(i, 0).text();
					if (t.compareTo("") != 0)
						gmGames.put(Integer.parseInt(t), game);
				}
			}
			if (gmGames.size() > 0)
				round1.setIsMaster();
			else
				round1.setIsPlayer();
			round1.setGmGameList(gmGames);
			round1.setPGameList(pGames);
			if (gmGames.size() > 0 || pGames.size() > 0)
				rdList.put(1, round1);
			// Troisième occurence
			QTableWidget qtw2 = playerDialog.tableWidget2;
			RoundWishes round2 = new RoundWishes();
			gmGames = new Hashtable<Integer, Game>();
			pGames = new Hashtable<Integer, Game>();
			for (int i = 0; i < qtw2.rowCount(); i++) {
				String gameTitle = qtw2.verticalHeaderItem(i).text();
				Game game = loadGame(gameTitle);
				if (qtw2.item(i, 1) != null) {
					t = qtw2.item(i, 1).text();
					if (t.compareTo("") != 0)
						pGames.put(Integer.parseInt(t), game);
				}
				if (qtw2.item(i, 0) != null) {
					t = qtw2.item(i, 0).text();
					if (t.compareTo("") != 0)
						gmGames.put(Integer.parseInt(t), game);
				}
			}
			if (gmGames.size() > 0)
				round2.setIsMaster();
			else
				round2.setIsPlayer();
			round2.setGmGameList(gmGames);
			round2.setPGameList(pGames);
			if (gmGames.size() > 0 || pGames.size() > 0)
				rdList.put(2, round2);

			player = new Player(playerDialog.lineEdit_LastName.text(),
					playerDialog.lineEdit_FirstName.text(),
					playerDialog.lineEdit_Pseudo.text(),
					(playerDialog.dateEdit_Born.dateTime().daysTo(QDateTime
							.currentDateTime())) / 365,
					playerDialog.radioButton.isChecked() ? Gender.MALE
							: Gender.FEMALE,
					playerDialog.lineEdit_Address.text(),
					playerDialog.lineEdit_PostalCode.text(),
					playerDialog.lineEdit_City.text(),
					playerDialog.lineEdit_Phone.text(),
					playerDialog.lineEdit_Email.text(),
					playerDialog.checkBox_Spam.isChecked(),
					Integer.parseInt(playerDialog.lineEdit_YearsOfRPG.text()
							.length() > 0 ? playerDialog.lineEdit_YearsOfRPG
							.text() : "0"), playerDialog.comboBox_Club
							.currentText().length() > 0,
					playerDialog.comboBox_Club.currentText(),
					playerDialog.dateEdit.date().toString(
							Qt.DateFormat.SystemLocaleShortDate),
					playerDialog.checkBox_Paid.isChecked(), rdList);

			mainDataManager.addPerson(player);
			this.showPlayers();
		}
	}

	private void addPlayerToRoundPanel(int roundNumber, Player player) {
		RoundWidgets roundWidgets = this.roundWidgets.get(roundNumber);
		int numberOfGameMasters = 0;
		int numberOfPlayers = 0;
		if (player.getGameWishes().get(roundNumber) != null) {
			roundWidgets.insertPlayerInTable(player);
			// Totals
			if (player.getGameWishes().get(roundNumber).isMaster())
				numberOfGameMasters++;
			else
				numberOfPlayers++;
		}
		roundWidgets.getNumberOfGameMasters().setText("" + numberOfGameMasters);
		roundWidgets.getNumberOfPlayers().setText("" + numberOfPlayers);
	}

	public void showPlayers() {
		ArrayList<Player> list = mainDataManager.getPlayerList();
		QTableWidget aptw = ui.allPlayersTableWidget;
		QTableWidget frtw = ui.fridayTableWidget;
		QTableWidget satw = ui.saturdayTableWidget;
		QTableWidget sutw = ui.sundayTableWidget;

		this.initGamesGrids();

		int row = aptw.rowCount();
		for (int r = 0; r < row; r++) {
			aptw.removeRow(row);
		}
		aptw.setRowCount(0);
		row = frtw.rowCount();
		for (int r = 0; r < row; r++) {
			frtw.removeRow(row);
		}
		frtw.setRowCount(0);
		row = satw.rowCount();
		for (int r = 0; r < row; r++) {
			satw.removeRow(row);
		}
		satw.setRowCount(0);
		row = sutw.rowCount();
		for (int r = 0; r < row; r++) {
			sutw.removeRow(row);
		}
		sutw.setRowCount(0);

		Player currentPlayer;
		int fridayGM = 0, fridayPL = 0, saturdayGM = 0, saturdayPL = 0, sundayGM = 0, sundayPL = 0;
		for (int i = 0; i < list.size(); i++) {
			currentPlayer = (Player) list.get(i);
			row = aptw.rowCount();
			aptw.insertRow(row);
			aptw.setSortingEnabled(false);
			int plNb = 0, gmNb = 0;
			for (Notation notation : currentPlayer.getNotations().values()) {
				if (notation.getType().equals(Notation.PLAYER)) {
					plNb++;
				} else {
					gmNb++;
				}
			}
			aptw.setItem(i, 0,
					new QTableWidgetItem(currentPlayer.getLastname()));
			aptw.setItem(i, 1,
					new QTableWidgetItem(currentPlayer.getFirstname()));
			aptw.setItem(i, 2,
					new QTableWidgetItem(currentPlayer.getNickname()));
			aptw.setItem(i, 3, new QTableWidgetItem(gmNb + ""));
			aptw.setItem(i, 4, new QTableWidgetItem(plNb + ""));
			aptw.setItem(i, 5, new QTableWidgetItem(
					getPlayerPosition(currentPlayer) + ""));
			aptw.setItem(i, 6, new QTableWidgetItem(
					getPlayerType(currentPlayer)));
			aptw.setItem(i, 7,
					new QTableWidgetItem(currentPlayer.hasAlreadyPaid() ? "Yes"
							: "No"));
			aptw.setSortingEnabled(true);
			/* Fill FRIDAY */
			addPlayerToRoundPanel(FRIDAY_ROUND, currentPlayer);
			/* Fill SATURDAY */
			addPlayerToRoundPanel(SATURDAY_ROUND, currentPlayer);
			/* Fill SUNDAY */
			addPlayerToRoundPanel(SUNDAY_ROUND, currentPlayer);
		}
		ui.fridayGMLineEdit.setText("" + fridayGM);
		ui.fridayPLineEdit.setText("" + fridayPL);
		ui.saturdayGMLineEdit.setText("" + saturdayGM);
		ui.saturdayPLineEdit.setText("" + saturdayPL);
		ui.sundayGMLineEdit.setText("" + sundayGM);
		ui.sundayPLineEdit.setText("" + sundayPL);

	}

	public void updateFridayPlayer() {
		/* Personal Info */
		QTableWidget qtw = ui.fridayTableWidget;
		if (qtw.selectedItems().size() > 0) {
			int row = qtw.selectedItems().get(0).row();

			String lastname = qtw.item(row, 0).text();
			String firstname = qtw.item(row, 1).text();
			Player player = mainDataManager.findPlayer(lastname, firstname,
					null);

			String gameTitle = qtw.item(row, 3).text();
			Game game = new Game(gameTitle);

			if (player.getGameWishes().get(0) != null &&
					player.getNotations().get(0) != null) {
				if (qtw.item(row, 2).text().compareTo(NO_NOTE) != 0)
					player.getNotations().get(0)
							.setNote(Integer.parseInt(qtw.item(row, 2).text()));
				player.getNotations().get(0).setGame(game);
			}

			/* Games */
			String t;
			Hashtable<Integer, Game> gmGames = new Hashtable<Integer, Game>();
			Hashtable<Integer, Game> pGames = new Hashtable<Integer, Game>();
			// Attention, code moche dupliqué à refactorer !
			// Première occurence
			QTableWidget qtw0 = ui.fridayGamesTableWidget;
			gmGames = new Hashtable<Integer, Game>();
			pGames = new Hashtable<Integer, Game>();
			for (int i = 0; i < qtw0.rowCount(); i++) {
				String currentGameTitle = qtw0.verticalHeaderItem(i).text();
				Game currentGame = new Game(currentGameTitle);
				if (qtw0.item(i, 1) != null) {
					t = qtw0.item(i, 1).text();
					if (t.compareTo("") != 0)
						pGames.put(Integer.parseInt(t), currentGame);
				}
				if (qtw0.item(i, 0) != null) {
					t = qtw0.item(i, 0).text();
					if (t.compareTo("") != 0)
						gmGames.put(Integer.parseInt(t), currentGame);
				}
			}
			if (gmGames.size() > 0)
				player.getGameWishes().get(0).setIsMaster();
			else
				player.getGameWishes().get(0).setIsPlayer();
			player.getGameWishes().get(0).setGmGameList(gmGames);
			player.getGameWishes().get(0).setPGameList(pGames);

			mainDataManager.savePlayer(player);
		}
	}

	public void updateSaturdayPlayer() {
		/* Personal Info */
		QTableWidget qtw = ui.saturdayTableWidget;
		if (qtw.selectedItems().size() > 0) {
			int row = qtw.selectedItems().get(0).row();
			String lastname = qtw.item(row, 0).text();
			String firstname = qtw.item(row, 1).text();
			Player player = mainDataManager.findPlayer(lastname, firstname,
					null);

			String gameTitle = qtw.item(row, 3).text();
			Game game = new Game(gameTitle);

			if (player.getGameWishes().get(1) != null &&
					player.getNotations().get(1) != null) {
				if (qtw.item(row, 2).text().compareTo(NO_NOTE) != 0)
					player.getNotations().get(1)
							.setNote(Integer.parseInt(qtw.item(row, 2).text()));
				player.getNotations().get(1).setGame(game);
			}

			/* Games */
			String t;
			Hashtable<Integer, Game> gmGames = new Hashtable<Integer, Game>();
			Hashtable<Integer, Game> pGames = new Hashtable<Integer, Game>();
			// Attention, code moche dupliqué à refactorer !
			// Première occurence
			QTableWidget qtw0 = ui.saturdayGamesTableWidget;
			for (int i = 0; i < qtw0.rowCount(); i++) {
				String currentGameTitle = qtw0.verticalHeaderItem(i).text();
				Game currentGame = new Game(currentGameTitle);
				if (qtw0.item(i, 1) != null) {
					t = qtw0.item(i, 1).text();
					if (t.compareTo("") != 0)
						pGames.put(Integer.parseInt(t), currentGame);
				}
				if (qtw0.item(i, 0) != null) {
					t = qtw0.item(i, 0).text();
					if (t.compareTo("") != 0)
						gmGames.put(Integer.parseInt(t), currentGame);
				}
			}
			if (gmGames.size() > 0)
				player.getGameWishes().get(1).setIsMaster();
			else
				player.getGameWishes().get(1).setIsPlayer();
			player.getGameWishes().get(1).setGmGameList(gmGames);
			player.getGameWishes().get(1).setPGameList(pGames);

			mainDataManager.savePlayer(player);
		}
	}

	public void updateSundayPlayer() {
		/* Personal Info */
		QTableWidget qtw = ui.sundayTableWidget;
		if (qtw.selectedItems().size() > 0) {
			int row = qtw.selectedItems().get(0).row();
			String lastname = qtw.item(row, 0).text();
			String firstname = qtw.item(row, 1).text();
			Player player = mainDataManager.findPlayer(lastname, firstname,
					null);

			String gameTitle = qtw.item(row, 3).text();
			Game game = new Game(gameTitle);

			if (player.getGameWishes().get(2) != null &&
					player.getNotations().get(2) != null) {
				if (qtw.item(row, 2).text().compareTo(NO_NOTE) != 0)
					player.getNotations().get(2)
							.setNote(Integer.parseInt(qtw.item(row, 2).text()));
				player.getNotations().get(2).setGame(game);
			}

			/* Games */
			String t;
			Hashtable<Integer, Game> gmGames = new Hashtable<Integer, Game>();
			Hashtable<Integer, Game> pGames = new Hashtable<Integer, Game>();
			// Attention, code moche dupliqué à refactorer !
			// Première occurence
			QTableWidget qtw0 = ui.sundayGamesTableWidget;
			for (int i = 0; i < qtw0.rowCount(); i++) {
				String currentGameTitle = qtw0.verticalHeaderItem(i).text();
				Game currentGame = new Game(currentGameTitle);
				if (qtw0.item(i, 1) != null) {
					t = qtw0.item(i, 1).text();
					if (t.compareTo("") != 0)
						pGames.put(Integer.parseInt(t), currentGame);
				}
				if (qtw0.item(i, 0) != null) {
					t = qtw0.item(i, 0).text();
					if (t.compareTo("") != 0)
						gmGames.put(Integer.parseInt(t), currentGame);
				}
			}
			if (gmGames.size() > 0)
				player.getGameWishes().get(2).setIsMaster();
			else
				player.getGameWishes().get(2).setIsPlayer();
			player.getGameWishes().get(2).setGmGameList(gmGames);
			player.getGameWishes().get(2).setPGameList(pGames);

			mainDataManager.savePlayer(player);
		}
	}

	public void updateFridayGames() {
		/* Personal Info */
		QTableWidget qtw = ui.fridayTableWidget;
		if (qtw.selectedItems().size() > 0) {
			int row = qtw.selectedItems().get(0).row();
			String ln = qtw.item(row, 0).text();
			String fn = qtw.item(row, 1).text();
			Player player = mainDataManager.findPlayer(ln, fn, null);

			/* Games */
			Map<Integer, Game> gmGames = player.getGameWishes().get(0)
					.getGmGamesList();
			Map<Integer, Game> pGames = player.getGameWishes().get(0)
					.getPGamesList();

			QTableWidget gtw = ui.fridayGamesTableWidget;

			gtw.clearContents();
			String rowTitle;
			Integer key;
			for (int i = 0; i < gtw.rowCount(); i++) {
				rowTitle = gtw.verticalHeaderItem(i).text();
				Game game = loadGame(rowTitle);
				// GM Games
				Set<Integer> gmSet = gmGames.keySet();
				Iterator<Integer> gmItr = gmSet.iterator();
				while (gmItr.hasNext()) {
					key = gmItr.next();
					if ((key != null)
							&& gmGames.get(key).equals(game)) {
						gtw.setItem(i, 0, new QTableWidgetItem(key.toString()));
					}
				}
				// GM Games
				Set<Integer> plSet = pGames.keySet();
				Iterator<Integer> plItr = plSet.iterator();
				while (plItr.hasNext()) {
					key = plItr.next();
					if ((key != null) && pGames.equals(game)) {
						gtw.setItem(i, 1, new QTableWidgetItem(key.toString()));
					}
				}
			}
		}
	}

	public void updateSaturdayGames() {
		/* Personal Info */
		QTableWidget qtw = ui.saturdayTableWidget;
		if (qtw.selectedItems().size() > 0) {
			int row = qtw.selectedItems().get(0).row();
			String ln = qtw.item(row, 0).text();
			String fn = qtw.item(row, 1).text();
			Player player = mainDataManager.findPlayer(ln, fn, null);

			/* Games */
			Map<Integer, Game> gmGames = player.getGameWishes().get(1)
					.getGmGamesList();
			Map<Integer, Game> pGames = player.getGameWishes().get(1)
					.getPGamesList();

			QTableWidget gtw = ui.saturdayGamesTableWidget;

			gtw.clearContents();
			String rowTitle;
			Integer key;
			for (int i = 0; i < gtw.rowCount(); i++) {
				rowTitle = gtw.verticalHeaderItem(i).text();
				Game game = loadGame(rowTitle);
				// GM Games
				Set<Integer> gmSet = gmGames.keySet();
				Iterator<Integer> gmItr = gmSet.iterator();
				while (gmItr.hasNext()) {
					key = gmItr.next();
					if ((key != null)
							&& gmGames.get(key).equals(game)) {
						gtw.setItem(i, 0, new QTableWidgetItem(key.toString()));
					}
				}
				// GM Games
				Set<Integer> plSet = pGames.keySet();
				Iterator<Integer> plItr = plSet.iterator();
				while (plItr.hasNext()) {
					key = plItr.next();
					if ((key != null) && pGames.get(key).equals(game)) {
						gtw.setItem(i, 1, new QTableWidgetItem(key.toString()));
					}
				}
			}
		}
	}

	public void updateSundayGames() {
		/* Personal Info */
		QTableWidget qtw = ui.sundayTableWidget;
		if (qtw.selectedItems().size() > 0) {
			int row = qtw.selectedItems().get(0).row();
			String ln = qtw.item(row, 0).text();
			String fn = qtw.item(row, 1).text();
			Player player = mainDataManager.findPlayer(ln, fn, null);

			/* Games */
			Map<Integer, Game> gmGames = player.getGameWishes().get(2)
					.getGmGamesList();
			Map<Integer, Game> pGames = player.getGameWishes().get(2)
					.getPGamesList();

			QTableWidget gtw = ui.sundayGamesTableWidget;

			gtw.clearContents();
			String rowTitle;
			Integer key;
			for (int i = 0; i < gtw.rowCount(); i++) {
				rowTitle = gtw.verticalHeaderItem(i).text();
				Game game = loadGame(rowTitle);
				// GM Games
				Set<Integer> gmSet = gmGames.keySet();
				Iterator<Integer> gmItr = gmSet.iterator();
				while (gmItr.hasNext()) {
					key = gmItr.next();
					if ((key != null)
							&& gmGames.get(key).equals(game)) {
						gtw.setItem(i, 0, new QTableWidgetItem(key.toString()));
					}
				}
				// GM Games
				Set<Integer> plSet = pGames.keySet();
				Iterator<Integer> plItr = plSet.iterator();
				while (plItr.hasNext()) {
					key = plItr.next();
					if ((key != null) && pGames.get(key).equals(game)) {
						gtw.setItem(i, 1, new QTableWidgetItem(key.toString()));
					}
				}
			}
		}
	}

	public void addRound() {

	}

	public void showRounds() {
		Ui_RoundPrompt roundDialog = new Ui_RoundPrompt();
		QDialog d = new QDialog(this);
		roundDialog.setupUi(d);
		if (tournamentSchedule != null) {
			roundDialog.actionPrintFridayTables.triggered.connect(this,
					"printFridayTables()");
			roundDialog.actionPrintSaturdayTables.triggered.connect(this,
					"printSaturdayTables()");
			roundDialog.actionPrintSundayTables.triggered.connect(this,
					"printSundayTables()");
			roundDialog.fridayRoundTextBrowser.setText(tournamentSchedule
					.tableListToString(0));
			roundDialog.saturdayRoundTextBrowser.setText(tournamentSchedule
					.tableListToString(1));
			roundDialog.sundayRoundTextBrowser.setText(tournamentSchedule
					.tableListToString(2));
			if (d.exec() == QDialog.DialogCode.Accepted.value()) {
				// tournamentSchedule.save();
			}
		}
	}

	public void generateRounds() {
		tournamentSchedule = new TournamentSchedule();
		tournamentSchedule.computeTournamentSchedule(
				RPGTournamentMngrConstants.nbrOfRound,
				mainDataManager.getPlayerList());
		this.showRounds();
	}

	public void addGame() {
		Ui_GameSettings gameDialog = new Ui_GameSettings();
		QDialog d = new QDialog(this);
		gameDialog.setupUi(d);
		Game g;
		if (d.exec() == QDialog.DialogCode.Accepted.value()) {
			g = new Game(gameDialog.lineEdit_gameName.text(),
					gameDialog.checkBox_Day1.isChecked(),
					gameDialog.checkBox_Day2.isChecked(),
					gameDialog.checkBox_Day3.isChecked(), new Integer(
							gameDialog.lineEdit_gameIndex.text()));
			mainDataManager.addGame(g);
			this.showPlayers();
		}
	}

	public void showGames() {
		// setCentralWidget(widget);
	}

	public void generateResults() {
		Ui_ResultsPrompt resultsDialog = new Ui_ResultsPrompt();
		QDialog d = new QDialog(this);
		resultsDialog.setupUi(d);
		resultsDialog.resultsTabWidget.setTabText(0, "Classement MJ");
		resultsDialog.resultsTabWidget.setTabText(1, "Classement PJ");

		// setCentralWidget(widget);
		ArrayList<Player> playerList = mainDataManager.getPlayerList();
		mainDataManager.pcList.removeAll(mainDataManager.pcList);
		mainDataManager.gmList.removeAll(mainDataManager.gmList);

		for (Player player : playerList) {
			if (player.getPlayerFinalNoteAsPC().getNote() != 0) {
				mainDataManager.pcList.add(player);
			}
			if (player.getPlayerFinalNoteAsGM().getNote() != 0) {
				mainDataManager.gmList.add(player);
			}
		}

		Collections.sort(mainDataManager.pcList, new PCComparator());
		Collections.sort(mainDataManager.gmList, new GMComparator());

		for (Player player : playerList) {
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

		resultsDialog.actionPrintGMTables.triggered.connect(this,
				"printGMTables()");
		resultsDialog.actionPrintPCTables.triggered.connect(this,
				"printPCTables()");
		resultsDialog.gmResultsTextBrowser.setText(this
				.playerListToString(Notation.GAME_MASTER));
		resultsDialog.pcResultsTextBrowser.setText(this
				.playerListToString(Notation.PLAYER));
		if (d.exec() == QDialog.DialogCode.Accepted.value()) {
			// tournamentSchedule.save();
		}
	}

	public String playerListToString(String type) {
		ArrayList<Player> playerList = new ArrayList<Player>();
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
			for (Player player : playerList) {
				returnedString += i + ". " + player.toString() + "\n";
				i++;
			}
		}
		return returnedString;
	}

	public int getPlayerPosition(Player player) {
		int pci = mainDataManager.pcList.indexOf(player);
		int gmi = mainDataManager.gmList.indexOf(player);

		return Math.max(pci, gmi) + 1;
	}

	public String getPlayerType(Player player) {
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
			return NO_NOTE;
		}
	}

	public void setPreferences() {

	}

	public void updatePlayer() {
		QTableWidget qtw = ui.allPlayersTableWidget;
		if (qtw.selectedItems().size() > 0) {
			int row = qtw.selectedItems().get(0).row();
			String ln = qtw.item(row, 0).text();
			String fn = qtw.item(row, 1).text();
			Player player = mainDataManager.findPlayer(ln, fn, null);
			if (qtw.selectedItems().get(0).text().compareToIgnoreCase("Yes") == 0) {
				player.setAlreadyPaid(true);
			} else {
				player.setAlreadyPaid(false);
			}

			mainDataManager.savePlayer(player);
		}
	}

	public void printFridayTables() {

		int nRound = 0;
		Round round = tournamentSchedule.getRounds().get(0);

		PrinterJob printJob = PrinterJob.getPrinterJob();
		Book book = new Book();
		List<PrintRound> printInBook = new ArrayList<PrintRound>();
		Paper papier = new Paper();
		papier.setImageableArea(0.0, 0.0, papier.getWidth(), papier.getHeight());

		PageFormat documentPageFormat = new PageFormat();
		documentPageFormat.setOrientation(PageFormat.LANDSCAPE);
		documentPageFormat.setPaper(papier);

		// create printing list and add in printing book
		int tableNumber = 0;
		for (Table table : round.getTables()) {
			printInBook.add(new PrintRound(nRound, tableNumber, table));
			book.append((Printable) printInBook.get(tableNumber),
					documentPageFormat);
			tableNumber++;
		}

		printJob.setPageable(book);

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
		Round round = tournamentSchedule.getRounds().get(1);

		PrinterJob printJob = PrinterJob.getPrinterJob();
		Book book = new Book();
		List<PrintRound> printInBook = new ArrayList<PrintRound>();
		Paper papier = new Paper();
		papier.setImageableArea(0.0, 0.0, papier.getWidth(), papier.getHeight());

		PageFormat documentPageFormat = new PageFormat();
		documentPageFormat.setOrientation(PageFormat.LANDSCAPE);
		documentPageFormat.setPaper(papier);

		// create printing list and add in printing book
		int tableNumber = 0;
		for (Table table : round.getTables()) {
			printInBook.add(new PrintRound(nRound, tableNumber, table));
			book.append((Printable) printInBook.get(tableNumber),
					documentPageFormat);
			tableNumber++;
		}

		printJob.setPageable(book);

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
		Round round = tournamentSchedule.getRounds().get(2);

		PrinterJob printJob = PrinterJob.getPrinterJob();
		Book book = new Book();
		List<PrintRound> printInBook = new ArrayList<PrintRound>();
		Paper papier = new Paper();
		papier.setImageableArea(0.0, 0.0, papier.getWidth(), papier.getHeight());

		PageFormat documentPageFormat = new PageFormat();
		documentPageFormat.setOrientation(PageFormat.LANDSCAPE);
		documentPageFormat.setPaper(papier);

		// create printing list and add in printing book
		int tableNumber = 0;
		for (Table table : round.getTables()) {
			printInBook.add(new PrintRound(nRound, tableNumber, table));
			book.append((Printable) printInBook.get(tableNumber),
					documentPageFormat);
			tableNumber++;
		}

		printJob.setPageable(book);

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
	
	private Game loadGame(String gameTitle) {
		for (Game game : mainDataManager.gameList) {
			if (game.getName().equalsIgnoreCase(gameTitle)) {
				return game;
			}
		}
		return null;
	}

}

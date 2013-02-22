package fr.graal.rpgtournament.ui;

import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QTableWidget;
import com.trolltech.qt.gui.QTableWidgetItem;

import fr.graal.rpgtournament.player.Player;

public class RoundWidgets {

	private int roundNumber;
	private QLineEdit numberOfPlayers;
	private QLineEdit numberOfGameMasters;
	private QTableWidget tableOfAllPlayers;
	
	public RoundWidgets(int roundNumber, QLineEdit numberOfPlayers, QLineEdit numberOfGameMasters, QTableWidget tableOfAllPlayers) {
		this.roundNumber = roundNumber;
		this.numberOfPlayers = numberOfPlayers;
		this.numberOfGameMasters = numberOfGameMasters;
		this.tableOfAllPlayers = tableOfAllPlayers;
	}
	
	public void insertPlayerInTable(Player player) {
		int row = tableOfAllPlayers.rowCount();
		
		tableOfAllPlayers.insertRow(row);
		tableOfAllPlayers.setSortingEnabled(false);
		
		tableOfAllPlayers.setItem(row, 0,
				new QTableWidgetItem(player.getLastname()));
		tableOfAllPlayers.setItem(row, 1,
				new QTableWidgetItem(player.getFirstname()));
		tableOfAllPlayers.setItem(row, 2, new QTableWidgetItem(player.getRoundNoteAsString(roundNumber)));
		tableOfAllPlayers.setItem(row, 3, new QTableWidgetItem(player.getRoundGameName(roundNumber)));
		
		tableOfAllPlayers.setSortingEnabled(true);
	}

	public QLineEdit getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(QLineEdit numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public QLineEdit getNumberOfGameMasters() {
		return numberOfGameMasters;
	}

	public void setNumberOfGameMasters(QLineEdit numberOfGameMasters) {
		this.numberOfGameMasters = numberOfGameMasters;
	}

	public QTableWidget getTableOfAllPlayers() {
		return tableOfAllPlayers;
	}

	public void setTableOfAllPlayers(QTableWidget tableOfAllPlayers) {
		this.tableOfAllPlayers = tableOfAllPlayers;
	}
}

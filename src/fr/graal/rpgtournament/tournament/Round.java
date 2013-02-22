package fr.graal.rpgtournament.tournament;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import fr.graal.rpgtournament.RPGTournamentMngrConstants;
import fr.graal.rpgtournament.game.Table;
import fr.graal.rpgtournament.player.Player;

public class Round {

	private Set<Table> tables;
	private Set<Player> playersWithoutTable;
	
	public Round() {
		tables = new HashSet<Table>();
		playersWithoutTable = new HashSet<Player>();
	}
	
	public Round(Set<Table> tables, Set<Player> playersWithoutTable) {
		this.tables = tables;
		this.playersWithoutTable = playersWithoutTable;
	}
	
	public String getTablesAsString() {
		StringBuilder tablesAsString = new StringBuilder();
		int tableNumber = 1;
		
		if (CollectionUtils.isNotEmpty(tables)) {
			for (Table table : tables) {
				tablesAsString.append(table.asString(tableNumber++))
				.append("\n");
			}
		}
		return tablesAsString.toString();
	}
	
	public String playersWithoutTableAsString() {
		String returnedString = "";
		if (CollectionUtils.isNotEmpty(playersWithoutTable)) {
			for (Player player : playersWithoutTable) {
				returnedString = returnedString + "     -"
						+ player.getFullName() + "\n";
			}
		} else {
			returnedString = "     "
					+ RPGTournamentMngrConstants.Texts.getString("NoPlayer")
					+ "\n";
		}
		return returnedString;
	} 
	
	public void addTable(Table table) {
		tables.add(table);
	}	
	

	public Set<Table> getTables() {
		return tables;
	}

	public void setTables(Set<Table> tables) {
		this.tables = tables;
	}

	public Set<Player> getPlayersWithoutTable() {
		return playersWithoutTable;
	}

	public void setPlayersWithoutTable(Set<Player> playersWithoutTable) {
		this.playersWithoutTable = playersWithoutTable;
	}
}

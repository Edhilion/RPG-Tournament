package fr.evdb.rpgtournament.i18n;

import java.util.ListResourceBundle;

/**
 * <p>Titre : Tournoi JDR</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2003</p>
 * <p>Société : </p>
 * @author VAN DE BOR Eric
 * @version 1.0
 */

public class RPGTournamentManagerText extends ListResourceBundle {

////////////////////////////////////////////////////////////////////////////////

  public Object[][] getContents() {
    return contents;
  }

////////////////////////////////////////////////////////////////////////////////

  static final Object[][] contents = {
      {"RPGTournamentMngr", "RPG Tournament Manager"},
      {"PlayerList", "Player list"},
      {"PlayerDetails", "Player details"},
      {"PlayerGenInfoPnl","Player general information"},
      {"Name", "Name"},
      {"FirstName" , "Firstname"},
      {"Age" , "Age"},
      {"Adress", "Adress"},
      {"PostalCode", "ZipCode"},
      {"City", "City"},
      {"TelNumber","Phone number"},
      {"EmailAdress", "Email address"},
      {"IcqNumber", "ICQ number"},
      {"NsnAdress", "MSN adress"},
      {"PlayerRpgInfoPnl","RPG activities information"},
      {"HowlongPlaysRPG", "How long did he plays RPG (in year)"},
      {"IsClubMember","Is he member of a club"},
      {"ClubName","Club name"},
      {"PlayerTournInfoPnl", "Tournament information" },
      {"InscriptionDate", "Inscription date (DD/MM/YY)" },
      {"AlreadyPaid", "Already paid"},
      {"Round", "Round"},
      {"participateToRound","participate to this round"},
      {"master" , "master"},
      {"player" , "player"},
      {"ReceiveMail","The player don't want to receive any mail"},
      {"ClearAll", "Clear All"},
      {"CreatePlayer", "Create player"},
      {"UpdatePlayer", "Update player"},
      {"AddPlayer","Add Player"},
      {"RemovePlayer","Remove Player"},
      {"Total", "Total"},
      {"SaveNotation", "Save Notation"},
      {"PlayerNotation", "Player Notation"},
      {"MasterNotation", "Master Notation"},
      {"ImpCreaPlayWithSameName", "Impossible to create a player with the same name and first name than another player"},
      {"Error", "Error"},
      {"ImpUpdPlay", "Impossible to update, you have first to select a player"},
      {"ImpCreaPlayWithoutName", "Impossible to create a player without name"},
      {"ImpCreaPlayWithoutFirstName", "Impossible to create a player without first name"},
      {"IncorrectAge" , "Incorrect age"},
      {"YouShouldEnterAClubName", "You should enter a club name"},
	  {"computeRound", "Compute rounds"},
      {"printRound", "Print rounds"},
	  {"Rounds","Rounds"},
      {"Male","Male"},
      {"Female","Female"},
	  {"View","View"},
	  {"Select","Select"},
	  {"Table","Table"},
	  {"Game","Game"},
	  {"Master","Master"},
	  {"RPGTournamentPrintMngr","RPG printing manager"},
	  {"Print","Print"},
	  {"CanNotPrintComputeRoundFirst","Can not print, you should compute round first"},
	  {"AllTableRound", "All tables"},
	  {"OneTableRound", "Table number"},
	  {"Players" , "Players"},
	  {"RPGTournamentComputeRoundMngr", "RPG round manager"},
	  {"ComputeAllRound", "Compute all rounds"},
	  {"ComputeOneRound", "Compute round"},
	  {"PlayerListWithoutTable" , "Player list without table"},
	  {"NoPlayer", "No player"}
  };

////////////////////////////////////////////////////////////////////////////////

}

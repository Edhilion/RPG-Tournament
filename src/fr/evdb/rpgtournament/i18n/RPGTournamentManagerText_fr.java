package fr.evdb.rpgtournament.i18n;

import java.util.ListResourceBundle;

/**
 * <p>Titre : Tournoi JDR</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2003</p>
 * <p>Soci�t� : </p>
 * @author VAN DE BOR Eric
 * @version 1.0
 */

public class RPGTournamentManagerText_fr extends ListResourceBundle {

////////////////////////////////////////////////////////////////////////////////

  public Object[][] getContents() {
    return contents;
  }

////////////////////////////////////////////////////////////////////////////////

  static final Object[][] contents = {
      {"RPGTournamentMngr", "Gestionnaire Tournoi JDR"},
      {"PlayerList", "Liste joueurs"},
      {"PlayerDetails", "Details joueur"},
      {"PlayerGenInfoPnl","Information gen�rale du joueur"},
      {"Name", "Nom"},
      {"FirstName" , "Pr�nom"},
      {"Age" , "Age"},
      {"Sex" , "Sexe"},
      {"Adress", "Adresse"},
      {"PostalCode", "Code postal"},
      {"City", "Ville"},
      {"TelNumber","Numero de t�l�phone"},
      {"EmailAdress", "Adresse email"},
      {"IcqNumber", "Numero ICQ"},
      {"NsnAdress", "Adresse MSN"},
      {"PlayerRpgInfoPnl","Information sur l'activit� rolistique"},
      {"HowlongPlaysRPG", "Depuis combien de temps joues t il au jeux de roles (en ann�es)"},
      {"IsClubMember","Est il membre d'un club"},
      {"ClubName","Nom du club"},
      {"PlayerTournInfoPnl", "Infos tournoi" },
      {"InscriptionDate", "Date d'inscription (JJ/MM/AA)" },
      {"AlreadyPaid", "Inscription d�j� pay�e"},
      {"Round", "Ronde"},
      {"participateToRound","participe � cette ronde en tant que: "},
      {"master" , "maitre"},
      {"player" , "joueur"},
      {"ReceiveMail","Le joueur ne desire pas �tre inform� des futures activit�s des associations organisatrices"},
      {"ClearAll", "Effacer tout"},
      {"CreatePlayer", "Cr�er joueur"},
      {"UpdatePlayer", "Mise � jour joueur"},
      {"AddPlayer", "Ajouter joueur"},
      {"RemovePlayer", "Effacer joueur"},
      {"Total", "Total"},
      {"SaveNotation", "Sauvegarder Resultats"},
      {"PlayerNotation", "Notation Joueurs"},
      {"MasterNotation", "Notation MJ"},
      {"ImpCreaPlayWithSameName", "Impossible de cr�er un joueur avec le m�me nom et le m�me pr�nom qu'un autre joueur"},
      {"Error", "Erreur"},
      {"ImpUpdPlay", "Impossible de mettre � jour, vous devez d'abord selectionner un joueur"},
      {"ImpCreaPlayWithoutName", "Impossible de cr�er un joueur sans nom"},
      {"ImpCreaPlayWithoutFirstName", "Impossible de cr�er un joueur sans pr�nom"},
      {"IncorrectAge" , "Age incorrecte"},
      {"YouShouldEnterAClubName", "Vous devez saisir un nom de club"},
	  {"computeRound", "Former les rondes"},
      {"printRound", "Imprimer les rondes"},
      {"Rounds","Rondes"},
      {"Male","Masculin"},
      {"Female","F�minin"},
	  {"View","Visualisation"},
	  {"Select","Selection"},
	  {"Table","Table"},
	  {"Game","Jeux"},
	  {"Master" , "Ma�tre"},
	  {"RPGTournamentPrintMngr", "Gestionnaire d'impression JDR"},
	  {"Print","Imprimer"},
	  {"CanNotPrintComputeRoundFirst","Impossible d'imprimer, Vous devez d'abord former les rondes"},
	  {"AllTableRound", "Toutes les tables"},
	  {"OneTableRound", "Table numero"},
	  {"Players" , "Joueurs"},
	  {"RPGTournamentComputeRoundMngr", "Gestionnaire de ronde JDR"},
	  {"ComputeAllRound", "Former toutes les rondes"},
	  {"ComputeOneRound", "Former ronde"},
	  {"PlayerListWithoutTable" , "Liste de joueurs sans table"},
	  {"NoPlayer", "Aucun joueur"}
  };

////////////////////////////////////////////////////////////////////////////////

}

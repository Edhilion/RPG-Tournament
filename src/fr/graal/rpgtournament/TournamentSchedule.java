package fr.graal.rpgtournament;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import java.util.Hashtable;
import java.util.Collections;


/**
 * <p>Titre : Tournoi JDR</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2003</p>
 * <p>Société : </p>
 * @author VAN DE BOR Eric and VAN DE BOR Thomas
 * @version 1.0
 */

public class TournamentSchedule implements Serializable {

  protected Map tournamentSchedule;
  protected Map playerListWithoutTable;

  public TournamentSchedule() {
    System.out.println("création activée");
    tournamentSchedule = new Hashtable();
    playerListWithoutTable = new Hashtable();
  }

  public TournamentSchedule (ObjectInputStream ois) {
    this.readObject(ois);
  }
  
  public boolean isEmpty() {
  	return tournamentSchedule.isEmpty();
  }
  
  public Vector getPlayerListWithoutTable(int roundNbr) {
    return (Vector)playerListWithoutTable.get(new Integer(roundNbr));
  }

  public void addSchedule(Integer index, Vector schedule) {
    tournamentSchedule.put(index, schedule);
  }

  public Map getTournamentSchedule() {
    return tournamentSchedule;
  }

  public Vector getSchedule(int roundNbr) {
  	return (Vector)tournamentSchedule.get(new Integer(roundNbr));
  }
  
  public void debugTableList(ArrayList<Table> v,int det) {
    Table t;
    Person p;
    ArrayList<Person> playersList;
    if (!v.isEmpty()) {
      for (int i = 0; i < v.size(); i++) {
        t = v.get(i);
        System.out.println("Table: " + i + " - Master: " + t.getMaster().getName());
        if (det == 1) {
          System.out.println("Game: " + t.getGame());
          System.out.println("Player List: ");
          playersList = t.getPlayerList();
          debugPlayerList(playersList);
        }
      }
     }
    else {
      System.out.println("Liste table vide");
    }
   }

   public String tableListToString(int roundNbr) {
	   @SuppressWarnings("unchecked")
	ArrayList<Table> v = (ArrayList<Table>)tournamentSchedule.get(new Integer(roundNbr));
     Table t;
     ArrayList<Person> playersList;
     String returnedString = "";
     if (!v.isEmpty()) {
       for (int i = 0; i < v.size(); i++) {
         t = v.get(i);
         returnedString = returnedString +  RPGTournamentMngrConstants.Texts.getString("Table") + " " + (i+1) + "    -    " + t.getGame() + "\n";
         returnedString = returnedString +  RPGTournamentMngrConstants.Texts.getString("Master") + " : " + t.getMaster().getName() + " " + t.getMaster().getFirstName() + "\n";
         returnedString = returnedString +  RPGTournamentMngrConstants.Texts.getString("Players") + "\n";
         playersList = t.getPlayerList();
         returnedString = returnedString + playerListToString(playersList);
         returnedString = returnedString + "\n";
       }
     }
     returnedString = returnedString + "\n \n" + RPGTournamentMngrConstants.Texts.getString("PlayerListWithoutTable")+ " :\n";
     returnedString = returnedString + playerListToString((ArrayList<Person>)this.playerListWithoutTable.get(new Integer(roundNbr)));
     return returnedString;
   }

   public String playerListToString(ArrayList<Person> playersList) {
     String returnedString = "";
     Person p;
     if (!playersList.isEmpty()) {
       for (int j = 0; j < playersList.size(); j++) {
         p = playersList.get(j);
         returnedString = returnedString + "     -" + p.getName() + " " + p.getFirstName() + "\n";
       }
     }
     else {
       returnedString = "     " + RPGTournamentMngrConstants.Texts.getString("NoPlayer") + "\n";
     }
     return returnedString;
   }


    public void debugPlayerList(ArrayList<Person> playersList) {
      Person p;
      if (!playersList.isEmpty()) {
        for (int j = 0; j < playersList.size(); j++) {
          p = playersList.get(j);
          System.out.println("--"+p.getName() +" "+ p.getFirstName());
        }
      }
      else {
        System.out.println("Liste vide");
      }
    }

  public void computeTournamentSchedule(int nbOfRound, ArrayList arrayList) {
    for (int i=0; i<nbOfRound;i++) {
      try {
      	computeOneRound(i, arrayList);

        //Affichage du resultat
        //System.out.println("--------------------Resultat-------------");
        //debugTableList ((Vector)tournamentSchedule.get(new Integer(i)),1);
        //System.out.println("---------------------Joueur non placé----");
        //debugPlayerList (PlayerListWithoutTable);
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }


  public void computeOneRound(int roundNbr, ArrayList<Person> arrayList) throws Exception {
  	System.out.println("***** Debut Creation Ronde " + roundNbr + "*******************************");
  	
  	tournamentSchedule.put(new Integer(roundNbr), new ArrayList<Table>());
  	
  	ArrayList<Person> masterList = new ArrayList<Person>();
  	ArrayList<Person> playerList = new ArrayList<Person>();
  	ArrayList<Person> boyPlayerList = new ArrayList<Person>();

    int nbPeople = arrayList.size();
    Person p;
    for (int i = 0; i < nbPeople; i++) {
      p = (Person) arrayList.get(i);
      if (p.isRoundExist(roundNbr)) {
        if (( (Round) p.getRoundList().get(new Integer(roundNbr))).isMaster()) {
          masterList.add(p);
        } else {
        	if (p.getSex()) {
        		boyPlayerList.add(p);
        	} else {
        		playerList.add(p);
        	}
        }
      } else {
        System.out.println("Le joueur " + p.getName() + " " + p.getFirstName() + " n'as pas de ronde " + roundNbr + " definie");
      }
    }
    
    //Création de la liste des tables
    ArrayList<Table> tableList = new ArrayList<Table>();
    int nbMaster = masterList.size();
    Person master;
    for (int i = 0; i < nbMaster; i++) {
      master = (Person) masterList.get(i);
      if (( (Round) master.getRoundList().get(new Integer(roundNbr))).getGame(new Integer(1), true) != null) {
      	((ArrayList<Table>)tournamentSchedule.get(new Integer(roundNbr))).add(new Table(master ,master.getRoundList().get(new Integer(roundNbr)).getGame(new Integer(1), true)));
      	master.getPlayerNotation().getNotation(roundNbr+1).setGame(master.getRoundList().get(new Integer(roundNbr)).getGame(new Integer(1), true));
      	master.getPlayerNotation().getNotation(roundNbr+1).setType(Notation.GAME_MASTER);
      } else {
      	System.out.println(master.getName() + " " + master.getFirstName() + " definis comme Maitre pour la ronde " + roundNbr + " n'a pas de jeu parametré" );
      } 
    }
    //Triage des listes par ordre d'inscription
    Collections.sort(playerList);
    Collections.sort(boyPlayerList);
    //Fusion de la liste des filles avec les garçons
    playerList.addAll(boyPlayerList);
    ArrayList<Table> tableListPossible = new ArrayList<Table>();

    Person player;
    boolean playerPlaced = false;
    int nbPlayer = playerList.size();
    ArrayList<Person> tempPlayerListWithoutTable = new ArrayList<Person>();

    for (int i = 0; i < nbPlayer; i++) {
      player = (Person) playerList.get(i);
      System.out.println("---------------- Traitement de " + player.getName());
      playerPlaced = false;
      int j = 1;
      // pour chaque jeu
      int nbrOfGame = ((Round)(player.getRoundList().get(new Integer(roundNbr)))).getPGamesList().size();
      if  (nbrOfGame == 0) {
      	System.out.println(player.getName() + " n'a pas de jeu defini pour la ronde " + roundNbr);
      }
      while (j <= nbrOfGame && (!playerPlaced))  {
        tableListPossible.clear();
        @SuppressWarnings("unchecked")
		ArrayList<Table> table = (ArrayList<Table>) tournamentSchedule.get(new Integer(roundNbr));
        //réinintialisation de la liste des tables (en retirant les tables pleines)
        for (int k=0; k < table.size();k++) {
          if ( !table.get(k).isFivePlayer() ) {
            tableListPossible.add(table.get(k));
          }
        }
        //System.out.println("TTest 1");
        //debugTableList(tableListPossible,0);
        // test si le joueur a des tables disponibles par rapport au jeu selectionné.
        ArrayList<Table> tempVector = getAvailableTableOnGame(tableListPossible,( (Round) player.getRoundList().get(new Integer(roundNbr))).getGame(new Integer(j), false));
        tableListPossible = tempVector;
        //System.out.println("TTest 2");
        //debugTableList(tableListPossible,0);   
        // test si le joueur a déjà joué avec le même maître du jeu
        tempVector = getAvailableTableOnPreviousMaster(tableListPossible,player,roundNbr);
        if (!tempVector.isEmpty()) {
          //System.out.println("TTest 3"); 
          tableListPossible = tempVector;
          //debugTableList(tableListPossible,0);
          // test si le joueur est dans la bonne tranche d'age
          tempVector = getAvailableTableAge(tableListPossible, player.getAge());
	      if (!tempVector.isEmpty()) {
	        //System.out.println("TTest 4");
	        tableListPossible = tempVector;
	        //debugTableList(tableListPossible,0);
	        // test si il n y a pas d'autre fille sur la table
            if ( player.getSex() == false) {
              //System.out.println("TTest 5");
              tableListPossible = getAvailableFemaleTable(tableListPossible);
              //debugTableList(tableListPossible,0);
              // test s'il n'y a pas d'autre joueur du même club que lui
               if ( player.isClubMember()) {
                 //System.out.println("TTest 6");
                 tableListPossible = getAvailableTableClub(tableListPossible, player.getClubName());
                 //debugTableList(tableListPossible,0);
              }
            }   
          }
        }

        // test s'il le joueur peut être placé dans une table
        if ( !tableListPossible.isEmpty()) {
          if (tableListPossible.size()>1) {
            //Random rnd = new Random( );
            //((Table)tableListPossible.elementAt(rnd.nextInt(tableListPossible.size()))).addPlayer(player);
         	tableListPossible.get(tableMoreFilled(tableListPossible)).addPlayer(player);
          } else if (tableListPossible.size()==1) {
         	tableListPossible.get(0).addPlayer(player);
          }
          playerPlaced = true;
          player.getPlayerNotation().getNotation(roundNbr+1).setGame(tableListPossible.get(0).getGame());
          player.getPlayerNotation().getNotation(roundNbr+1).setType(Notation.PLAYER);
          System.out.println(player.getName()+ " placé");
        } else {
        	// si le joueur n'est pas placé
        	if (j == nbrOfGame) {
        		System.out.println(player.getName() + " non placé");
        		tempPlayerListWithoutTable.add(player);
        	}
        }
        j++;
        //debugTableList ((Vector)tournamentSchedule.get(new Integer(roundNbr)),1);
      }
    }
    this.playerListWithoutTable.put(new Integer(roundNbr), tempPlayerListWithoutTable);
    System.out.println("***** Fin Creation Ronde " + roundNbr + "*******************************");
  }

  @SuppressWarnings("unchecked")
protected ArrayList<Table> getAvailableTableOnPreviousMaster(ArrayList<Table> tableList, Person player, int roundNbr ) {
    if (roundNbr > 1) {
    	ArrayList<Table> resultListOfTable = new ArrayList<Table>();
      Person master;
      for (int j = roundNbr - 1; j > 0; j--) {
        master = findMasterInRound(player, j);
        if (master!=null) {
          int nbTable = tableList.size();
          for (int i = 0; i < nbTable; i++) {
            if (! ( (Table) tableList.get(i)).getMaster().equals(master)) {
              resultListOfTable.add(tableList.get(i));
            }
          }
        }
      }
      return resultListOfTable;
    } else {
      return (ArrayList<Table>)tableList.clone();
    }
  }

  private Person findMasterInRound(Person player, int roundNbr) {
    ArrayList<Table> tableList = (ArrayList<Table>)tournamentSchedule.get(new Integer(roundNbr));
    int nbTable = tableList.size();
    for (int i=0; i<nbTable; i++) {
      if ( ((Table)tableList.get(i)).containsPlayer(player) ) {
        return ((Table)tableList.get(i)).getMaster();
      }
    }
    return null;
  }


  protected ArrayList<Table> getAvailableTableOnGame(ArrayList<Table> tableList, String game) {
	  ArrayList<Table> resultListOfTable = new ArrayList<Table>();
    int nbTable = tableList.size();
    for (int i=0; i<nbTable; i++) {
      if (((Table)tableList.get(i)).getGame().equals(game)) {
        resultListOfTable.add(tableList.get(i));
      }
    }
    return resultListOfTable;
  }


  protected ArrayList<Table> getAvailableTableAge(ArrayList<Table> tableList, int playerAge) {
  	
	  ArrayList<Table> resultListOfTable = new ArrayList<Table>();
    int nbTable = tableList.size();
    for (int i=0; i<nbTable; i++) {
      int masterAge = ((Table)tableList.get(i)).getMaster().getAge();
      // Si le maitre a moins de 30 ans
      if (masterAge < 30) {
      	if ( (masterAge-4 <= playerAge) && (playerAge <= masterAge+4) )  {
        resultListOfTable.add(tableList.get(i));
        //System.out.println("Age maitre -30 ans");
      	}
      }
      else { 
      // Si le maitre a plus de 30 ans
      	if ( (masterAge-4 <= playerAge) && (playerAge <= masterAge+199) )  {
        resultListOfTable.add(tableList.get(i));
        //System.out.println("Age maitre +30 ans");
      	}
      }
    }
      
    return resultListOfTable;

  }


  protected ArrayList<Table> getAvailableTableClub(ArrayList<Table> tableList, String clubName) {
	  ArrayList<Table> resultListOfTable = new ArrayList<Table>();
    int nbTable = tableList.size();
    for (int i=0; i<nbTable; i++) {
    	ArrayList<Person> playerList = tableList.get(i).getPlayerList();
      int nbPlayer = playerList.size();
      int j=0;
      boolean clubFound = false;
      while ((j<nbPlayer) && (!clubFound)) {
        if ( ((Person)playerList.get(j)).getClubName().equals(clubName)) {
          clubFound=true;
        }
        j++;
      }
      if (!clubFound) {
        resultListOfTable.add(tableList.get(i));
      }
    }
    return resultListOfTable;
  }
  
  protected ArrayList<Table> getAvailableFemaleTable(ArrayList<Table> tableList) {
	  ArrayList<Table> resultListOfTable = new ArrayList<Table>();
    int nbTable = tableList.size();
    for (int i=0; i<nbTable; i++) {
    	ArrayList<Person> playerList = tableList.get(i).getPlayerList();
      int nbPlayer = playerList.size();
      int j=0;
      boolean female = false;
      while ((j<nbPlayer) && (!female)) {
        if ( (((Person)playerList.get(j)).getSex())== false) {
        	//System.out.println("Fille trouver table" + (i+1));
        	female=true;
        }
        j++;
      }
      if (!female) {
        resultListOfTable.add(tableList.get(i));
      }
    }
    return resultListOfTable;
  }
  
  protected int tableMoreFilled(ArrayList<Table> tableList) {
  	int index=0;
  	int nbTable = tableList.size();
  	int numberOfPlayer=0;
    for (int i=0; i<nbTable; i++) {
    	if ( tableList.get(i).getPlayerList().size() > numberOfPlayer ) {
    		numberOfPlayer = tableList.get(i).getPlayerList().size();
    		index = i;
    	}
    			
    } 	
    //System.out.println("index " + index);
	return index;
  }

  public int getNbrOfTable(int roundNbr) {
  	return ((ArrayList<Table>)tournamentSchedule.get(new Integer(roundNbr))).size();
  }

  public void ChangePlayer(String name, String firstName, int roundNbr, int newTableNbr){
	  ArrayList<Table> schedule = (ArrayList<Table>)tournamentSchedule.get(new Integer(roundNbr));
	  ArrayList<Person> playersList;
  	Person p;
  	Table t;
  	for (int i=0; i<schedule.size(); i++) {
  		if (!schedule.isEmpty()){
  			t = (Table)schedule.get(i);
  			playersList = t.getPlayerList();
  			for (int j=0; j<playersList.size();j++) {
  				p = (Person)playersList.get(j);
  				if (p.equals(name, firstName)){
  					playersList.remove(j);
  					t = (Table)schedule.get(newTableNbr-1);
  					t.getPlayerList().add(p);
  					return;
  				}
  			}
  		}
  	}
  	playersList = (ArrayList<Person>)playerListWithoutTable.get(new Integer(roundNbr));
	if (!playersList.isEmpty()){
		for (int j=0; j<playersList.size();j++) {
			p = (Person)playersList.get(j);
			if (p.equals(name, firstName)){
				playersList.remove(j);
				t = (Table)schedule.get(newTableNbr-1);
				t.getPlayerList().add(p);
				return;
			}
		}
	}
  }
  
////////////////////////////////////////////////////////////////////////////////////
  
  public static TournamentSchedule createFromFile(String fileName) {
    FileInputStream in = null;
    try {
      in = new FileInputStream(fileName);
    }
    catch (FileNotFoundException ex) {
      //ex.printStackTrace();
      return null;
    }
    ObjectInputStream s = null;
    try {
      s = new ObjectInputStream(in);
    }
    catch (IOException ex1) {
      ex1.printStackTrace();
      return null;
    }
    TournamentSchedule tournamentSchedule = new TournamentSchedule(s);
    try {
      s.close();
      in.close();
    } catch (IOException ex2) {
      ex2.printStackTrace();
      return null;
    }
    return tournamentSchedule;
  }


 //////////////////////////////////////////////////////////////////////////////////


  public void save() {
    FileOutputStream out = null;
    try {
      out = new FileOutputStream(RPGTournamentMngrConstants.saveDirectoryRounds + File.separator + "tournamentSchedule");
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }

    try {
      ObjectOutputStream s = new ObjectOutputStream(out);
      this.writeObject(s);
      s.flush();
      s.close();
      out.close();
    } catch (IOException ex1) {
      ex1.printStackTrace();
    }
  }
  

////////////////////////////////////////////////////////////////////////////////

  public void writeObject(ObjectOutputStream oos) {
  	try {
      
      oos.writeObject(this.tournamentSchedule);
      oos.writeObject(this.playerListWithoutTable);
      
    } catch (IOException exp) {
      exp.printStackTrace();
    }
  }

////////////////////////////////////////////////////////////////////////////////

  public void readObject(ObjectInputStream ois) {
    
  	try {
      this.tournamentSchedule = (Map)ois.readObject();
      this.playerListWithoutTable = (Map)ois.readObject();
   
     } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
  
//////////////////////////////////////////////////////////////////////////////////  
  
}
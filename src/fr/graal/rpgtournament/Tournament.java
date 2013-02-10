package fr.graal.rpgtournament;

import java.awt.event.ActionEvent;
import java.util.Vector;
import java.awt.event.MouseEvent;

import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;

/**
 * <p>Titre : Tournoi JDR</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2003</p>
 * <p>Société : </p>
 * @author VAN DE BOR Eric
 * @version 1.0
 */

public class Tournament {

  protected Person currentPerson;
  protected TournamentSchedule tournamentSchedule;
  private boolean listHasChanged;
  protected RPGTournamentComputeRoundMngr computeRoundWindows;
  protected boolean playerRoundChange;

////////////////////////////////////////////////////////////////////////////////

  public Tournament() {

//    new File(RPGTournamentMngrConstants.saveDirectoryRounds).mkdir();
//    tournamentSchedule = TournamentSchedule.createFromFile(RPGTournamentMngrConstants.saveDirectoryRounds + File.separator + "tournamentSchedule");
//    if (tournamentSchedule!=null) {
//    	playerRoundPanel.setRound(tournamentSchedule);
//    }
//    listHasChanged = false;
//    playerRoundChange = false;
  }

////////////////////////////////////////////////////////////////////////////////

  public void actionPerformed(ActionEvent e) {
//    String actionCommand = e.getActionCommand();
//    if (actionCommand.equals("addPlayer")) {
//      currentPerson = null;
//      playerTab.clearAll();
//      mainTabbedPane.setSelectedComponent(playerTab);
//    } else if (actionCommand.equals("removePlayer")) {
//      if (playerListGrid.getNumberOfPlayer() > 0) {
//        mainDataManager.removePerson(mainDataManager.findPerson(playerListGrid.
//            getPlayerNameSelected(), playerListGrid.getPlayerFirstNameSelected()));
//        playerListGrid.deleteSelectedPerson();
//        listHasChanged = true;
//      }
//    } else if (actionCommand.equals("updatePlayer")) {
//      if (currentPerson != null) {
//      	int enteringValid = playerTab.isEnteringValid();
//        if (enteringValid == PlayerTab.ENTERING_OK) {
//        	Person newPerson = playerTab.getPerson();
//        	if ( (newPerson.equals(currentPerson.getName(), currentPerson.getFirstName()))
//              || ( (!newPerson.equals(currentPerson.getName(), currentPerson.getFirstName())) &&
//                   (mainDataManager.findPerson(newPerson.getName(), newPerson.getFirstName()) == null) )) {
//        		newPerson.setEssentialData(currentPerson);
//        		mainDataManager.updatePerson(currentPerson, newPerson);
//        		playerListGrid.updatePerson(currentPerson, newPerson);
//        		currentPerson = newPerson;
//        		mainTabbedPane.setSelectedComponent(playerListGrid);
//        		listHasChanged = true;
//        	} else {
//        		JOptionPane.showMessageDialog(this,
//                                        RPGTournamentMngrConstants.Texts.
//                                        getString("ImpCreaPlayWithSameName"),
//                                        RPGTournamentMngrConstants.Texts.
//                                        getString("Error"),
//                                        JOptionPane.ERROR_MESSAGE);
//        	}
//        } else { 
//        	manageErrorPlayerCreation(enteringValid);
//        }
//      } else {
//        JOptionPane.showMessageDialog(this, RPGTournamentMngrConstants.Texts.
//        		getString("ImpUpdPlay"), 
//				RPGTournamentMngrConstants.Texts.
//				getString("Error"), 
//				JOptionPane.ERROR_MESSAGE);
//      }
//    } else if (actionCommand.equals("createPlayer")) {
//      int enteringValid = playerTab.isEnteringValid();
//      if (enteringValid == PlayerTab.ENTERING_OK) {
//      	Person p = playerTab.getPerson();
//      	if (mainDataManager.findPerson(p.getName(), p.getFirstName()) == null) {
//          playerListGrid.addPerson(p);
//          mainDataManager.addPerson(p);
//          mainTabbedPane.setSelectedComponent(playerListGrid);
//          listHasChanged = true;
//        } else {
//          JOptionPane.showMessageDialog(this,
//                                        RPGTournamentMngrConstants.Texts.
//                                        getString("ImpCreaPlayWithSameName"),
//                                        RPGTournamentMngrConstants.Texts.
//                                        getString("Error"),
//                                        JOptionPane.ERROR_MESSAGE);
//        }
//      } else {
//      	manageErrorPlayerCreation(enteringValid);
//      }
//    } else if (actionCommand.equals("saveNotation")) {
//      int size = playerNotationGrid.getNumberOfPlayer();
//      Person p;
//      for (int i=0; i<size; i++) {
//        p = mainDataManager.findPerson(playerNotationGrid.getPlayerName(i)
//            , playerNotationGrid.getPlayerFirstName(i));
//        p.getPlayerNotation().addNotation(new Integer(1), new Integer(playerNotationGrid.getNotationToRound(i,1)));
//        p.getPlayerNotation().addNotation(new Integer(2), new Integer(playerNotationGrid.getNotationToRound(i,2)));
//        p.getPlayerNotation().addNotation(new Integer(3), new Integer(playerNotationGrid.getNotationToRound(i,3)));
//      }
//      mainDataManager.saveAllPlayers();
//
//    } else if (actionCommand.equals("StartComputeRound")) {
//    	computeRoundWindows = new RPGTournamentComputeRoundMngr(getFrame(),RPGTournamentMngrConstants.nbrOfRound,tournamentSchedule,this); 
//    	computeRoundWindows.show();
//    } else if (actionCommand.equals("ComputeAllRounds")) {
//    	tournamentSchedule = new TournamentSchedule();
//    	tournamentSchedule.computeTournamentSchedule(RPGTournamentMngrConstants.nbrOfRound,mainDataManager.getPlayerList());
//    	playerRoundPanel.setRound(tournamentSchedule);
//    	computeRoundWindows.dispose();
//    	tournamentSchedule.save();
//  	} else if (actionCommand.equals("PrintRound")) {
//  		if ((tournamentSchedule!=null) && (!tournamentSchedule.isEmpty())) {
//  			RPGTournamentPrintMngr printWindows = new RPGTournamentPrintMngr(getFrame(),RPGTournamentMngrConstants.nbrOfRound,tournamentSchedule); 
//  			printWindows.show();
//  		} else {
//  			JOptionPane.showMessageDialog(this,
//                    RPGTournamentMngrConstants.Texts.
//                    getString("CanNotPrintComputeRoundFirst"),
//                    RPGTournamentMngrConstants.Texts.
//                    getString("Error"),
//                    JOptionPane.ERROR_MESSAGE);
//  		}
//  	} else if (actionCommand.startsWith("ComputeRound")) {
//  		int roundToCompute = (new Integer(actionCommand.substring(12))).intValue();
//  		if (tournamentSchedule == null) {
//  	  		tournamentSchedule = new TournamentSchedule();
//  	  	}
//  	  	try {
//  	  		tournamentSchedule.computeOneRound(roundToCompute,mainDataManager.getPlayerList());
//  	  		playerRoundPanel.setOneRound(roundToCompute, tournamentSchedule);
//  	  		computeRoundWindows.dispose();
//  	  	} catch (Exception ex) {
//  			System.out.println("Impossible to compute Round: " + roundToCompute );
//  			ex.printStackTrace();
//  	  	}
//  	  			
//  	 }

  }

////////////////////////////////////////////////////////////////////////////////

  protected void initListOfPerson(Vector listOfPerson) {
//    int size = listOfPerson.size();
//    Person p;
//    for (int i=0; i<size; i++) {
//      p = (Person)listOfPerson.elementAt(i);
//      playerListGrid.addPerson(p);
//      playerNotationGrid.addPerson(p);
//    }
  }

  public void mouseClicked(MouseEvent e) {
//    if (e.getClickCount() == 2) {
//      Person p = mainDataManager.findPerson(playerListGrid.getPlayerName(e.getPoint()), playerListGrid.getPlayerFirstName(e.getPoint()));
//      currentPerson = p;
//      playerTab.setPlayerData(p);
//      mainTabbedPane.setSelectedComponent(playerTab);
//    }
  }

  public void mousePressed(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  public void stateChanged(ChangeEvent e) {
//    if (e.getSource() == mainTabbedPane){
//    	if (mainTabbedPane.getSelectedComponent() == playerNotationGrid) {
//  			if (listHasChanged) {
//  				playerNotationGrid.setAllPerson(mainDataManager.getPlayerList());
//  				listHasChanged = false;
//  			}
//  		}
//  	// Panel player visualisation (Pas propre à revoir)
//    } else {
//    	if ((tournamentSchedule != null) && (playerRoundChange == true)) {
//    		if ( ((JTabbedPane)e.getSource()).getSelectedIndex() == 0) {
//    			playerRoundPanel.setRoundText(tournamentSchedule);
//    			playerRoundChange = false;
//    		}
//    	}
//  	}
  }

////////////////////////////////////////////////////////////////////////////////

  /**
   * handeling of event of table notation
   * @param e
   */
  public void tableChanged(TableModelEvent e) {
//  	if (e.getSource() instanceof NotationTableModel) {
//  		int col = e.getColumn();
//  		//System.out.println(col);
//  		if ((col > 1) && (col < RPGTournamentMngrConstants.nbrOfRound + 2 )) {
//  			NotationTableModel ntm = (NotationTableModel)e.getSource();
//  			int row = e.getFirstRow();
//  			Object o;
//  			try {
//  				ntm.getIntValueAt(row, col);
//  			} catch (NumberFormatException nfe) {
//  				System.out.println("Number format exception error: " + ntm.getValueAt(row, col));
//  				ntm.setValueAt(new Integer(0), row, col);
//  				return;
//  			}
//  			//System.out.println((ntm.getIntValueAt(row, col)));
//  			if ( (ntm.getIntValueAt(row, col)) > PlayerNotation.MAX_NOTATION) {
//  				ntm.setValueAt(PlayerNotation.MAX_NOTATION + "", row, col);
//  			} else {
//  				ntm.computeTotal(row);
//  			}
//  		}
//  	} else if (e.getSource() instanceof RoundSelectionTableModel) {
//  		int col = e.getColumn();
//  		RoundSelectionTableModel rstm = (RoundSelectionTableModel)e.getSource();
//		int row = e.getFirstRow();
//		int newTableNbr = (new Integer((String)rstm.getValueAt(row, col))).intValue();
//		tournamentSchedule.ChangePlayer((String)rstm.getValueAt(row, 0), (String)rstm.getValueAt(row, 1), rstm.getRoundNbr(), newTableNbr);
//		tournamentSchedule.save();
//		playerRoundChange = true;
//  	}
//  }
//  
//  Frame getFrame() { // récupération de la frame
//    Component component=this;
//    do{
//       component=component.getParent();
//    } while(!(component instanceof Frame));
//    return (Frame)component;
 }

  protected void manageErrorPlayerCreation(int errorCode) {
//  	if (errorCode == PlayerTab.ERROR_NAME) {
//      JOptionPane.showMessageDialog(this,
//                                      RPGTournamentMngrConstants.Texts.
//                                      getString("ImpCreaPlayWithoutName"),
//                                      RPGTournamentMngrConstants.Texts.
//                                      getString("Error"),
//                                      JOptionPane.ERROR_MESSAGE);
//    } else if (errorCode == PlayerTab.ERROR_FIRST_NAME) {
//    	JOptionPane.showMessageDialog(this,
//    									RPGTournamentMngrConstants.Texts.
//										getString("ImpCreaPlayWithoutFirstName"),
//										RPGTournamentMngrConstants.Texts.
//										getString("Error"),
//										JOptionPane.ERROR_MESSAGE);
//    } else if (errorCode == PlayerTab.ERROR_AGE) {
//    	JOptionPane.showMessageDialog(this,
//				RPGTournamentMngrConstants.Texts.
//				getString("IncorrectAge"),
//				RPGTournamentMngrConstants.Texts.
//				getString("Error"),
//				JOptionPane.ERROR_MESSAGE);
//    } else if (errorCode == PlayerTab.ERROR_CLUB) {
//    	JOptionPane.showMessageDialog(this,
//				RPGTournamentMngrConstants.Texts.
//				getString("YouShouldEnterAClubName"),
//				RPGTournamentMngrConstants.Texts.
//				getString("Error"),
//				JOptionPane.ERROR_MESSAGE);
//    }
  }
  
  
////////////////////////////////////////////////////////////////////////////////

  /**
   *
   * @param o
   * @return the int value of what is in the cell
   * @throws java.lang.NumberFormatException
   */
/*
  private int getIntValueFromTable(Object o) throws NumberFormatException {
    if (o instanceof String) {
      return (new Integer((String)o)).intValue();
    } else if (o instanceof Integer) {
      return ((Integer)o).intValue();
    } else {
      System.out.println("Notation table data format error");
      return -1;
    }
  }
*/
////////////////////////////////////////////////////////////////////////////////

}
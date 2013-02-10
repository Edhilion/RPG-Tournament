/*
 * Created on 20 févr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.graal.rpgtournament;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

/**
 * @author Eric
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RPGTournamentComputeRoundMngr extends JDialog {
	private static final long serialVersionUID = -3327833446219680090L;

	public RPGTournamentComputeRoundMngr(Frame frame,int nbRound,TournamentSchedule tournamentSchedule,ActionListener al) {
	  	super(frame, RPGTournamentMngrConstants.Texts.getString("RPGTournamentComputeRoundMngr"), true);
	    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    this.getContentPane().setLayout(new BorderLayout());
	    this.setLocation(300, 300);
	    this.setResizable(false);
	    this.getContentPane().add(new ComputeRoundPanel(nbRound,tournamentSchedule,al), BorderLayout.NORTH);
	    this.pack();
	  }

}

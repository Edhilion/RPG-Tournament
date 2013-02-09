/*
 * Created on 20 févr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.graal.rpgtournament;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class ComputeRoundPanel extends JPanel {
	
	public ComputeRoundPanel(int nbRound, TournamentSchedule tournamentSchedule,ActionListener al) {
		
		Vector multiButton = new Vector();
		
		this.setLayout(new BorderLayout());	

		setBorder(new TitledBorder(RPGTournamentMngrConstants.Texts.getString("computeRound")));
		setLayout(new GridBagLayout());
		
		//Add all compute round button
		JButton allComputeRound = new JButton(RPGTournamentMngrConstants.Texts.getString("ComputeAllRound"));
		allComputeRound.setActionCommand("ComputeAllRounds");
		allComputeRound.addActionListener(al);
		add(allComputeRound, new GridBagConstraints(0,0, 1, 1, 0, 0, GridBagConstraints.CENTER,
		        GridBagConstraints.NONE, new Insets(5,5,5,5),0,0 ));
		
		//Add first compute round button
		multiButton.add(new JButton(RPGTournamentMngrConstants.Texts.getString("ComputeOneRound")+" 1"));
		((JButton) multiButton.elementAt(0)).setActionCommand("ComputeRound1");
		((JButton) multiButton.elementAt(0)).addActionListener(al);
		add((JButton) multiButton.elementAt(0), new GridBagConstraints(0,1, 1, 1, 0, 0, GridBagConstraints.CENTER,
		        GridBagConstraints.NONE, new Insets(5,5,5,5),0,0 ));

		//Add other compute round button
		for (int i = 2 ; i <= nbRound ; i++) {
			multiButton.add(new JButton(RPGTournamentMngrConstants.Texts.getString("ComputeOneRound") + " " + (i)));
			((JButton) multiButton.elementAt(i-1)).setActionCommand("ComputeRound"+(i));
			((JButton) multiButton.elementAt(i-1)).addActionListener(al);
			/*
			((JButton) multiButton.elementAt(i-1)).setEnabled(false);
			if ( tournamentSchedule != null) {
				if (!((Vector) tournamentSchedule.getTournamentSchedule().get(new Integer(i-1))).isEmpty()) {
				((JButton) multiButton.elementAt(i-1)).setEnabled(true);
				}
			}*/
			add((JButton) multiButton.elementAt(i-1), new GridBagConstraints(0,i, 1, 1, 0, 0, GridBagConstraints.CENTER,
			        GridBagConstraints.NONE, new Insets(5,5,5,5),0,0 ));
			
		}
		
		
		
		
		
		
		
		
		
		
	}

	public void actionPerformed(ActionEvent arg0) {
		
	}

}


package fr.graal.rpgtournament;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class PrintRound implements Printable {
	protected JFrame frame;

	public PrintRound(int nRound,int nTable, Table table) {
		
		Vector labelPlayersList= new Vector();

		frame = new JFrame();
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setBackground(Color.white);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridBagLayout());
		
		JLabel sRound = new JLabel(RPGTournamentMngrConstants.Texts.getString("Round")+" "+(nRound+1));
		Font f = new Font("courier",Font.BOLD,20);
		sRound.setFont(f);
		
		JLabel sTable = new JLabel(RPGTournamentMngrConstants.Texts.getString("Table")+" "+(nTable+1));
		Font f2 = new Font("courier",Font.BOLD,40);
		sTable.setFont(f2);
		
		JLabel sGame = new JLabel(table.getGame());
		Font f3 = new Font("courier",Font.BOLD,40);
		sGame.setFont(f3);
		
		JLabel sMasterLab = new JLabel(RPGTournamentMngrConstants.Texts.getString("Master")+":");
		Font f4 = new Font("courier",Font.BOLD,20);
		sMasterLab.setFont(f4);
		
		JLabel sMaster = new JLabel(((Person)table.getMaster()).getName() +" "+ ((Person)table.getMaster()).getFirstName());
		Font f5 = new Font("courier",Font.BOLD,30);
		sMaster.setFont(f5);
		
		JLabel sPlayerListLab = new JLabel(RPGTournamentMngrConstants.Texts.getString("Players")+":");
		Font f6 = new Font("courier",Font.BOLD,20);
		sPlayerListLab.setFont(f6);
		
		panel.add(sRound, new GridBagConstraints(0,0, 1, 1, 0, 0, GridBagConstraints.NORTHWEST,
		        GridBagConstraints.NONE, new Insets(0,0,0,0),0,0 ));	
		panel.add(sTable, new GridBagConstraints(0,1, 1, 1, 0, 0, GridBagConstraints.NORTH,
		        GridBagConstraints.NONE, new Insets(0,0,0,0),0,0 ));
		panel.add(sGame, new GridBagConstraints(0,2, 1, 1, 0, 0, GridBagConstraints.NORTH,
		        GridBagConstraints.NONE, new Insets(0,0,10,0),0,0 ));
		panel.add(sMasterLab, new GridBagConstraints(0,3, 1, 1, 0, 0, GridBagConstraints.NORTHWEST,
		        GridBagConstraints.NONE, new Insets(0,0,0,0),0,0 ));
		panel.add(sMaster, new GridBagConstraints(0,4, 1, 1, 0, 0, GridBagConstraints.NORTHWEST,
		        GridBagConstraints.NONE, new Insets(0,15,0,0),0,0 ));
		panel.add(sPlayerListLab, new GridBagConstraints(0,5, 1, 1, 0, 0, GridBagConstraints.NORTHWEST,
		        GridBagConstraints.NONE, new Insets(10,0,0,0),0,0 ));
		
		Font fPlayer = new Font("courier",Font.BOLD,30);
		for (int i = 0 ; i < ((ArrayList<Person>)table.getPlayerList()).size() ; i++) {
			
			labelPlayersList.addElement(new JLabel((i+1)+"- "+((Person)((ArrayList<Person>)table.getPlayerList()).get(i)).getName() + " " + ((Person)((ArrayList<Person>)table.getPlayerList()).get(i)).getFirstName()));
			((JLabel) labelPlayersList.elementAt(i)).setFont(fPlayer);
			
			panel.add((JLabel) labelPlayersList.elementAt(i), new GridBagConstraints(0,i+6, 2, 1, 0, 0, GridBagConstraints.NORTHWEST,
			        GridBagConstraints.NONE, new Insets(0,15,0,0),0,0 ));
			
		}
		
		
	}
	
	
	public int print(Graphics g, PageFormat pf, int pi) {
		
		Graphics2D g2 = (Graphics2D) g;
		((Graphics2D) g).setBackground(Color.white);
		g2.translate(pf.getImageableX()+35, pf.getImageableY());
		
		frame.pack();
		frame.setVisible(true);
		frame.paint(g2);
		frame.dispose();
	    return Printable.PAGE_EXISTS;
	    
	}
	
}


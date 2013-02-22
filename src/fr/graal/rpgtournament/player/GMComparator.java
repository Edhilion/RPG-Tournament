package fr.graal.rpgtournament.player;

import java.util.Comparator;

public class GMComparator implements Comparator<Player>{
      
    public int compare(Player p1, Player p2){
    	int p1Note = p1.getPlayerFinalNoteAsGM().getNote();
    	int p2Note = p2.getPlayerFinalNoteAsGM().getNote();
    	if (p1Note < p2Note) {
    		return 1;
    	} else if (p1Note > p2Note) {
    		return -1;
    	} else {
    		return 0;
    	}
    }
}


package fr.graal.rpgtournament.player;

import java.util.Comparator;

public class PCComparator implements Comparator<Person>{
      
    public int compare(Person p1, Person p2){
    	int p1Note = p1.getPlayerNoteAsPC().getNote();
    	int p2Note = p2.getPlayerNoteAsPC().getNote();
    	if (p1Note < p2Note) {
    		return 1;
    	} else if (p1Note > p2Note) {
    		return -1;
    	} else {
    		return 0;
    	}
    }
}


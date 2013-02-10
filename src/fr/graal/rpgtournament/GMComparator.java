package fr.graal.rpgtournament;

import java.util.Comparator;

public class GMComparator implements Comparator<Person>{
      
    public int compare(Person p1, Person p2){
    	int p1Note = p1.getPlayerNoteAsGM().getNote();
    	int p2Note = p2.getPlayerNoteAsGM().getNote();
    	if (p1Note < p2Note) {
    		return 1;
    	} else if (p1Note > p2Note) {
    		return -1;
    	} else {
    		return 0;
    	}
    }
}


package fr.graal.rpgtournament;

import java.util.Map;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.text.*;

/**
 * <p>Titre : Tournoi JDR</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2003</p>
 * <p>Société : </p>
 * @author VAN DE BOR Eric
 * @version 1.0
 */

public class Person implements Serializable, Comparable<Person> {

  /**
	 * 
	 */
	private static final long serialVersionUID = -6600900997440902409L;
protected String name;
  protected String firstName;
  protected int age;
  protected boolean sex;
  protected String adress;
  protected String postCode;
  protected String city;
  protected String telNumber;
  protected String emailAdress;
  protected String icqNumber;
  protected String msnAddress;
  protected boolean dontWantToBeInformed;

  // rolistic information
  protected int howLongPlayRPG;
  protected boolean isClubMember;
  protected String clubName;

  /** inscription date to the tournament */
  protected String inscriptionDate;
  protected boolean alreadyPaid;

  protected Map<Integer,Round> roundList;

  protected PlayerNotation playerNotation;

  private static final DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);

  
////////////////////////////////////////////////////////////////////////////////

  public Person(String name, String firstName, int age,boolean sex , String adress, String postCode, String city,
                String telNumber, String emailAdress, String icqNumber, String msnAddress, boolean dontWantToBeInformed,
                int howLongPlayRPG, boolean isClubMember, String clubName, String inscriptionDate, boolean alreadyPaid,
                Map<Integer,Round> roundList) {

    setAllDatas(name, firstName, age, sex, adress, postCode, city, telNumber, emailAdress, icqNumber, msnAddress,
                dontWantToBeInformed, howLongPlayRPG, isClubMember, clubName, inscriptionDate, alreadyPaid,
                roundList, new PlayerNotation());

  }

////////////////////////////////////////////////////////////////////////////////

  public Person (ObjectInputStream ois) {
    this.readObject(ois);
  }

////////////////////////////////////////////////////////////////////////////////

  protected void setAllDatas(String name, String firstName, int age, boolean sex, String adress, String postCode, String city,
                String telNumber, String emailAdress, String icqNumber, String msnAddress, boolean dontWantToBeInformed,
                int howLongPlayRPG, boolean isClubMember, String clubName, String inscriptionDate, boolean alreadyPaid,
                Map<Integer,Round> roundList, PlayerNotation playerNotation) {
    this.name=name;
    this.firstName = firstName;
    this.age = age;
    this.sex = sex;
    this.adress = adress;
    this.postCode = postCode;
    this.city = city;
    this.telNumber = telNumber;
    this.emailAdress = emailAdress;
    this.icqNumber = icqNumber;
    this.msnAddress = msnAddress;
    this.dontWantToBeInformed = dontWantToBeInformed;
    this.howLongPlayRPG = howLongPlayRPG;
    this.isClubMember = isClubMember;
    this.clubName = clubName;
    this.inscriptionDate = inscriptionDate;
    this.alreadyPaid = alreadyPaid;
    this.roundList = roundList;
    this.playerNotation = playerNotation;

  }

////////////////////////////////////////////////////////////////////////////////

  public String getName() {
    return this.name;
  }

////////////////////////////////////////////////////////////////////////////////

  public String getFirstName() {
    return this.firstName;
  }

////////////////////////////////////////////////////////////////////////////////

  public int getAge() {
    return this.age;
  }
////////////////////////////////////////////////////////////////////////////////

 public boolean getSex() {
  return this.sex;
 }
////////////////////////////////////////////////////////////////////////////////

  public String getAdress() {
    return this.adress;
  }

////////////////////////////////////////////////////////////////////////////////

  public String getPostCode() {
    return this.postCode;
  }

////////////////////////////////////////////////////////////////////////////////

  public String getCity() {
    return this.city;
  }

////////////////////////////////////////////////////////////////////////////////

  public String getTelNumber() {
    return this.telNumber;
  }

////////////////////////////////////////////////////////////////////////////////

  public String getEmailAdress() {
    return this.emailAdress;
  }

////////////////////////////////////////////////////////////////////////////////

  public String getIcqNumber() {
    return this.icqNumber;
  }

////////////////////////////////////////////////////////////////////////////////

  public String getMsnAdress() {
    return this.msnAddress;
  }

////////////////////////////////////////////////////////////////////////////////

  public boolean dontWantToBeInformed() {
    return this.dontWantToBeInformed;
  }

////////////////////////////////////////////////////////////////////////////////

  public int howLongPlayRPG() {
    return this.howLongPlayRPG;
  }

////////////////////////////////////////////////////////////////////////////////

  public boolean isClubMember() {
    return this.isClubMember;
  }

////////////////////////////////////////////////////////////////////////////////

  public String getClubName() {
    return this.clubName;
  }

////////////////////////////////////////////////////////////////////////////////

  public String getInscriptionDate() {
    return this.inscriptionDate;
  }

////////////////////////////////////////////////////////////////////////////////

  public boolean alreadyPaid() {
    return this.alreadyPaid;
  }

////////////////////////////////////////////////////////////////////////////////

  public Map<Integer,Round> getRoundList() {
    return this.roundList;
  }

////////////////////////////////////////////////////////////////////////////////

  public PlayerNotation getPlayerNotation() {
    return playerNotation;
  }
  
  public Notation getPlayerNote() {
	  Notation maxNote = new Notation();
	  for (int i=1; i <= playerNotation.size(); i++) {
		  Notation rdNote = playerNotation.getNotation(i);
		  if (rdNote.getNote() > maxNote.getNote())
			  maxNote = rdNote;
	  }
	  return maxNote;
  }


////////////////////////////////////////////////////////////////////////////////

  public void setEssentialData(Person p) {
    playerNotation = p.getPlayerNotation();
  }

////////////////////////////////////////////////////////////////////////////////

  public void writeObject(ObjectOutputStream oos) {
    try {
      oos.writeObject(this.name);
      oos.writeObject(this.firstName);
      oos.writeInt(this.age);
      oos.writeBoolean(this.sex);
      oos.writeObject(this.adress);
      oos.writeObject(this.postCode);
      oos.writeObject(this.city);
      oos.writeObject(this.telNumber);
      oos.writeObject(this.emailAdress);
      oos.writeObject(this.icqNumber);
      oos.writeObject(this.msnAddress);
      oos.writeBoolean(this.dontWantToBeInformed);
      oos.writeInt(this.howLongPlayRPG);
      oos.writeBoolean(this.isClubMember);
      oos.writeObject(this.clubName);
      oos.writeObject(this.inscriptionDate);
      oos.writeBoolean(this.alreadyPaid);
      oos.writeObject(this.roundList);
      oos.writeObject(this.playerNotation);

    } catch (IOException exp) {
      exp.printStackTrace();
    }

  }

////////////////////////////////////////////////////////////////////////////////

  @SuppressWarnings("unchecked")
public void readObject(ObjectInputStream ois) {
    try {
      this.name = (String)ois.readObject();
      this.firstName = (String)ois.readObject();
      this.age = ois.readInt();
      this.sex = ois.readBoolean();
      this.adress = (String)ois.readObject();
      this.postCode = (String)ois.readObject();
      this.city = (String)ois.readObject();
      this.telNumber = (String)ois.readObject();
      this.emailAdress = (String)ois.readObject();
      this.icqNumber = (String)ois.readObject();
      this.msnAddress = (String)ois.readObject();
      this.dontWantToBeInformed = ois.readBoolean();
      this.howLongPlayRPG = ois.readInt();
      this.isClubMember = ois.readBoolean();
      this.clubName = (String)ois.readObject();
      this.inscriptionDate = (String)ois.readObject();
      this.alreadyPaid = ois.readBoolean();
      this.roundList = (Map<Integer,Round>)ois.readObject();
      this.playerNotation = (PlayerNotation)ois.readObject();
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

////////////////////////////////////////////////////////////////////////////////

  public boolean equals(String name, String firstName) {
    if (this.name.equalsIgnoreCase(name) && this.firstName.equalsIgnoreCase(firstName)) {
      return true;
    } else {
      return false;
    }
  }

////////////////////////////////////////////////////////////////////////////////

  public boolean equals(Person p) {
    if (this.name.equalsIgnoreCase(p.getName()) && this.firstName.equalsIgnoreCase(p.getFirstName())) {
      return true;
    }
    return false;
  }
  

////////////////////////////////////////////////////////////////////////////////

  public int compareTo(Person o) {
    /*DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
    System.out.println(df.format(new Date()));
    System.out.println(this.inscriptionDate);
    System.out.println(( (Person) o).getInscriptionDate());
    */
    try {
      if ( (this.inscriptionDate.equals("")) && (((Person)o).getInscriptionDate()).equals("") ) {
        return 0;
      } else if (this.inscriptionDate.equals("")) {
        return 1;
      } else if (( (Person) o).getInscriptionDate().equals("")) {
        return -1;
      } else {
        return (df.parse(this.inscriptionDate).compareTo(df.parse( ( (Person) o).getInscriptionDate())) );
      }
    } catch (ParseException ex) {
      System.out.println("EXCEPTION");
      ex.printStackTrace();
      return 0;
    }
  }

////////////////////////////////////////////////////////////////////////////////


  public boolean isRoundExist(int roundNbr) {
    if ( roundList.get(new Integer(roundNbr))== null) {
      return false;
    }
    else {
      return true;
    }
  }

public void setName(String name) {
	this.name = name;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public void setAge(int age) {
	this.age = age;
}

public void setSex(boolean sex) {
	this.sex = sex;
}

public void setAdress(String adress) {
	this.adress = adress;
}

public void setPostCode(String postCode) {
	this.postCode = postCode;
}

public void setCity(String city) {
	this.city = city;
}

public void setTelNumber(String telNumber) {
	this.telNumber = telNumber;
}

public void setEmailAdress(String emailAdress) {
	this.emailAdress = emailAdress;
}

public void setIcqNumber(String icqNumber) {
	this.icqNumber = icqNumber;
}

public void setMsnAddress(String msnAddress) {
	this.msnAddress = msnAddress;
}

public void setDontWantToBeInformed(boolean dontWantToBeInformed) {
	this.dontWantToBeInformed = dontWantToBeInformed;
}

public void setHowLongPlayRPG(int howLongPlayRPG) {
	this.howLongPlayRPG = howLongPlayRPG;
}

public void setClubMember(boolean isClubMember) {
	this.isClubMember = isClubMember;
}

public void setClubName(String clubName) {
	this.clubName = clubName;
}

public void setInscriptionDate(String inscriptionDate) {
	this.inscriptionDate = inscriptionDate;
}

public void setAlreadyPaid(boolean alreadyPaid) {
	this.alreadyPaid = alreadyPaid;
}

public void setRoundList(Map<Integer, Round> roundList) {
	this.roundList = roundList;
}

public void setPlayerNotation(PlayerNotation playerNotation) {
	this.playerNotation = playerNotation;
}

////////////////////////////////////////////////////////////////////////////////



}
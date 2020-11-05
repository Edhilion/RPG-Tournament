package fr.graal.rpgtournament.ui;

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QCheckBox;
import com.trolltech.qt.gui.QDateEdit;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QGridLayout;
import com.trolltech.qt.gui.QGroupBox;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QWidget;

public class PlayerSettings extends QDialog {

	/************************/
	/**     Attributes     **/
	/************************/
	
	/****************/
	/**     UI     **/
    Ui_PlayerSettings ui = new Ui_PlayerSettings();
    
    /** Personal Informations **/
    private QLineEdit lastNameField; 
    private QLineEdit pseudoField;
    private QLineEdit firstNameField;
    private QLabel ageField;
    private QDateEdit dateEditField;
    private QLineEdit sexField;
    private QLineEdit addressField;
    private QLineEdit postalCodeField;
    private QLineEdit cityField;
    private QLineEdit phoneField;
    private QLineEdit emailField;
    private QCheckBox keepInTouchField;

	
    private QGridLayout mainLayout;

    public PlayerSettings() {
        ui.setupUi(this);
        mainLayout = new QGridLayout();
    }

    public PlayerSettings(QWidget parent) {
        super(parent);
        ui.setupUi(this);
        mainLayout = new QGridLayout();
    }
    
    public PlayerSettings(String title, QWidget parent) {
        super(parent);
        ui.setupUi(this);
        setWindowTitle(title);
        
        mainLayout = new QGridLayout();
        
        buildPersonalInformations();
    }
    
    public void buildPersonalInformations() {
    	QGroupBox personalInformationsGroup = new QGroupBox(tr("Personal Informations"));
    	QGroupBox contactInformationsGroup = new QGroupBox(tr("Contact Informations"));
    	
    	QLabel lastNameLabel = new QLabel(tr("Last Name"));
    	lastNameField = new QLineEdit();
    	
    	QLabel pseudoLabel = new QLabel(tr("Pseudo"));
    	pseudoField = new QLineEdit();
    	
    	QLabel firstNameLabel = new QLabel(tr("First Name"));
    	firstNameField = new QLineEdit();
    	
    	QLabel dateOfBirthLabel = new QLabel(tr("Date of Birth"));
    	dateEditField = new QDateEdit(QDate.currentDate());
    	dateEditField.setMinimumDate(QDate.currentDate().addYears(-100));
    	dateEditField.setDisplayFormat("dd/MM/yyyy");

    	
    	QLabel ageLabel = new QLabel(tr("Age"));
    	ageField = new QLabel(tr(""));
    	
    	QLabel sexLabel = new QLabel(tr("Sex"));
    	sexField = new QLineEdit();
    	
    	QLabel addressLabel = new QLabel(tr("Address"));
    	addressField = new QLineEdit();
    	
    	QLabel postalCodeLabel = new QLabel(tr("Postal Code"));
    	postalCodeField = new QLineEdit();
    	
    	QLabel cityLabel = new QLabel(tr("City"));
    	cityField = new QLineEdit();
    	
    	QLabel phoneLabel = new QLabel(tr("Phone"));
    	phoneField = new QLineEdit();
    	
    	QLabel emailLabel = new QLabel(tr("E-mail"));
    	emailField = new QLineEdit();
    	
    	QLabel keepInTouchLabel = new QLabel(tr("Keep In Touch"));
    	keepInTouchField = new QCheckBox();
    	
    	/*****************/
    	/* Player layout */
    	/*****************/
    	QGridLayout personalInformationsLayout = new QGridLayout();
    	/* Lastname */
    	personalInformationsLayout.addWidget(lastNameLabel, 0 ,0);
    	personalInformationsLayout.addWidget(lastNameField, 0, 1);
    	/* Pseudo */
    	personalInformationsLayout.addWidget(pseudoLabel, 0, 2);
    	personalInformationsLayout.addWidget(pseudoField, 0, 3);
    	/* Firstname */
    	personalInformationsLayout.addWidget(firstNameLabel, 1, 0);
    	personalInformationsLayout.addWidget(firstNameField, 1, 1);
    	/* Date of birth and Age */
    	personalInformationsLayout.addWidget(dateOfBirthLabel, 2, 0);
    	personalInformationsLayout.addWidget(dateEditField, 2, 1);
    	personalInformationsLayout.addWidget(ageLabel, 2, 2);
    	personalInformationsLayout.addWidget(ageField, 2, 3);
    	
    	personalInformationsGroup.setLayout(personalInformationsLayout);
    	mainLayout.addWidget(personalInformationsGroup);
    	
    	QGridLayout contactLayout = new QGridLayout();
    	/* Address */
    	contactLayout.addWidget(addressLabel, 0 ,0);
    	contactLayout.addWidget(addressField, 0, 1);
    	/* Postal Code */
    	contactLayout.addWidget(postalCodeLabel, 1, 0);
    	contactLayout.addWidget(postalCodeField, 1, 1);
    	/* City */
    	contactLayout.addWidget(cityLabel, 1, 2);
    	contactLayout.addWidget(cityField, 1, 3);
    	/* Email */
    	contactLayout.addWidget(emailLabel, 2, 0);
    	contactLayout.addWidget(emailField, 2, 1);
    	/* Phone */
    	contactLayout.addWidget(phoneLabel, 3, 0);
    	contactLayout.addWidget(phoneField, 3, 1);
    	
    	contactInformationsGroup.setLayout(contactLayout);
    	mainLayout.addWidget(contactInformationsGroup);
    	
    	setLayout(mainLayout);
    }
}

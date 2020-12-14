package io.codingexercises.rest.validateapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="outgoing")
public class Outgoing {
	@Id
    private long id;
    private String findDuplicates;
    private String whiteSpacesGalore;
    private String validateMeOnlyIActuallyShouldBeABoolean;
    private int[] numbersMeetNumbers;
    

	public Outgoing() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Outgoing(int id, String findDuplicates, String whiteSpacesGalore, String registrationNumber, String validateMeOnlyIActuallyShouldBeABoolean,
			int[] numbersMeetNumbers) {
		super();
		this.id = id;
		this.findDuplicates = findDuplicates;
		this.whiteSpacesGalore = whiteSpacesGalore;
		this.validateMeOnlyIActuallyShouldBeABoolean = validateMeOnlyIActuallyShouldBeABoolean;
		this.numbersMeetNumbers = numbersMeetNumbers;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFindDuplicates() {
		return findDuplicates;
	}

	public void setFindDuplicates(String findDuplicates) {
		this.findDuplicates = findDuplicates;
	}

	public String getWhiteSpacesGalore() {
		return whiteSpacesGalore;
	}

	public void setWhiteSpacesGalore(String whiteSpacesGalore) {
		this.whiteSpacesGalore = whiteSpacesGalore;
	}

	public String getValidateMeOnlyIActuallyShouldBeABoolean() {
		return validateMeOnlyIActuallyShouldBeABoolean;
	}

	public void setValidateMeOnlyIActuallyShouldBeABoolean(String validateMeOnlyIActuallyShouldBeABoolean) {
		this.validateMeOnlyIActuallyShouldBeABoolean = validateMeOnlyIActuallyShouldBeABoolean;
	}

	public int[] getNumbersMeetNumbers() {
		return numbersMeetNumbers;
	}

	public void setNumbersMeetNumbers(int[] numbersMeetNumbers) {
		this.numbersMeetNumbers = numbersMeetNumbers;
	}

}

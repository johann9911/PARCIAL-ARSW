package eci.arsw.covidanalyzer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Result {
	 //<editor-fold desc="properties">
    private UUID id=null;
    private String firstName;
    private String lastName;
    private ResultType type;
    private int numResult;
    //</editor-fold>
    
    public Result(String firstName, String lastName) {
    	this.firstName=firstName;
    	this.lastName=lastName;
    	this.type=null;
    	this.numResult=1;
    	this.id=UUID.randomUUID();
    }

    public void setResulType (ResultType resulType) {
    	this.type=resulType;
    }
    
    public ResultType getResulType () {
    	return type;
    }
    
    public void sumResul () {
    	numResult+=1;
    }
    
    public int getsumResul () {
    	return numResult;
    }
    
    //<editor-fold desc="getters">
    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //</editor-fold>

    //<editor-fold desc="setters">
    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //</editor-fold>

    //<editor-fold desc="Equality Methods">
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return ((Result) o).getId().equals(this.id);
    }
    public boolean equals2(UUID id) {
    	return this.id.equals(id);
    }
    //</editor-fold>

    @Override
    public String toString() {
        return this.id.toString() + " - " + this.firstName + " - " + this.lastName;
    }
}

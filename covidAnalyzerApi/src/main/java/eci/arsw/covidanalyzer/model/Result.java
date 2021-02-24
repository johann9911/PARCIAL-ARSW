package eci.arsw.covidanalyzer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Result {
	 //<editor-fold desc="properties">
    private UUID id=null;
    private String firstName;
    private String lastName;
    private List<ResultType> type;
    private int numResult;
    //</editor-fold>
    
    public Result(UUID id,String firstName, String lastName) {
    	this.firstName=firstName;
    	this.id=id;
    	this.lastName=lastName;
    	this.type=new ArrayList<>();
    	this.numResult=0;
    }
    public Result(String firstName, String lastName) {
    	this.firstName=firstName;
    	this.lastName=lastName;
    	this.type=new ArrayList<>();
    	this.numResult=0;
    }

    public void setResulType (ResultType resulType) {
    	type.add(resulType);
    }
    
    public List<ResultType> getResulType () {
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
    //</editor-fold>

    @Override
    public String toString() {
        return this.id.toString() + " - " + this.firstName + " - " + this.lastName;
    }
}

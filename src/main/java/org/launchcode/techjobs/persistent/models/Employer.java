package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
//add public accessor methods to Employer - add something here???
public class Employer extends AbstractEntity {

    @NotBlank
    @Size(max = 50)
    private String location;

    public String getLocation() {
        return location;
    }

    //not sure need this since only 1 location per employer
//    public void setLocation(String location) {
//        this.location = location;
//    }

    public Employer() {};

}

package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


//Part 2 Models, add @Entity annotation (an entity represents a table in a relational database, and each entity
// instance corresponds to a row in that table)
@Entity
//add public accessor methods to Employer
public class Employer extends AbstractEntity {

    //part 3, 1 Add a jobs Field to Employer-
    // add a private property jobs of type List<Job> and initialize it to an empty ArrayList
    //Use the @OneToMany and @JoinColumn annotations on the jobs list to declare the relationship
    // between data tables. (this list will represent the list of all items in a given job).
    @OneToMany
    @JoinColumn(name="employer_id")
    private final List<Job> jobs = new ArrayList<>();

    //Part 2 Models, Add the field for location with validation that ensures it is not empty
    // and has a reasonable length as well as getter, setter, constructor.
    @NotBlank
    @Size(min = 3, max = 50)
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employer(String location) {
        super();
        this.location = location;
    }

    //Part 2 Models, add no-arg constructor required for Hibernate to create an object.
    public Employer() {};
}

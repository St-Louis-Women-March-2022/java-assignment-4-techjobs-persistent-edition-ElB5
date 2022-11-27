package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//Part 2 Models, add @Entity annotation
@Entity
public class Skill extends AbstractEntity {

    //Part 2 Models, add a field for a longer description of the skill,
    // named description, with public accessor methods.
    @Size(min = 10, max = 500)
    private String description;

    //Part 4 setting up many to many- add a jobs field. Add a getter and setter for the field.
    //This field has a many-to-many type relationship with skills. You’ll need to add the @ManyToMany
    // annotation with an argument mappedBy="skills" to configure this mapping
    @ManyToMany(mappedBy="skills")
    private final List<Job> jobs = new ArrayList<>();

    public List<Job> getJobs() {
        return jobs;
    }

    public List<Job> setJobs() {
        return jobs;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Skill(String description) {}

    //Part 2 Models, add no-arg constructor.
    public Skill() {

    }
}
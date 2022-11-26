package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

//Part 2 Models, add @Entity annotation
@Entity
public class Skill extends AbstractEntity {

    //Part 2 Models, add a field for a longer description of the skill,
    // named description, with public accessor methods.
    @Size(min = 10, max = 500)
    private String description;


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
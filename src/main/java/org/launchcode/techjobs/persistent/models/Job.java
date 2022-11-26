package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;


//Part 3, Update job model: Update the class to extend AbstractEntity.
@Entity
public class Job extends AbstractEntity{

//Part 3, Update Job Model: removed these fields since extending AbstractEntity
//    @Id
//    @GeneratedValue
//    private int id;
//
//    private String name;


    //Part 3, Update Job Model: Replace the type of the field employer to be of type Employer.
    //Add the @ManyToOne
    @ManyToOne
    private Employer employer;

    private String skills;

    public Job() {
    }

    //Part 3, update job model-refactor the affected constructor and getter and setter (Employer).
    public Job(Employer anEmployer, String someSkills) {
        this.employer = anEmployer;
        this.skills = someSkills;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }


    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}

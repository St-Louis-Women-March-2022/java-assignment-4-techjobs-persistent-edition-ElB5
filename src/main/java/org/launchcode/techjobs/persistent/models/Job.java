package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//Part 3, Update job model: Update the class to extend AbstractEntity.
@Entity
public class Job extends AbstractEntity{

//Part 3, Update Job Model: removed these fields since extending AbstractEntity
//    @Id
//    @GeneratedValue
//    private int id;
//
//    private String name;


    //Part 3, Update Job Model: Replace the type of the field employer to Employer. Add the @ManyToOne
    @ManyToOne
    private Employer employer;

    //Part 4, Update Job Model: Replace the type of the field skills to List<Skill>. Add the @ManyToMany
    @ManyToMany
    private List<Skill> skills;

    public Job() {
    }

    //Part 3, refactor the affected constructor and getter and setter (Employer).
    //Part 4, refactor the affected constructor and getter and setter (List<Skill>).
    public Job(Employer anEmployer, List<Skill> someSkills) {
        this.employer = anEmployer;
        this.skills = someSkills;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}

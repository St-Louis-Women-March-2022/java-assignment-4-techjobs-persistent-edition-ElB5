package org.launchcode.techjobs.persistent.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

//Part 2, give AbstractEntity the @MappedSuperclass annotation (mapping information is applied to the entities that
// inherit from it. A mapped superclass has no separate table defined for it).
@MappedSuperclass
public abstract class AbstractEntity {

    //Part 2, add the @Id and @GeneratedValue annotations to the field id.
    @Id
    @GeneratedValue
    private int id;

    //Part 2, Each subclass will also inherit the name field from AbstractEntity.
    // Add appropriate validation annotations so that:
    //--a user cannot leave this field blank when creating an object.
    //--there are reasonable limitations on the size of the name string.
    // Keep in mind that the name field will be shared across Job, Employer,
    // and Skill classes. Some employer names might be longer than 50 characters
    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

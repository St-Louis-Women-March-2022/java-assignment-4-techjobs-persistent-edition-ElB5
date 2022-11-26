package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Part 2 Data Layer, To map the Employer and Skill classes to your techjobs database,
// you’ll add data access interfaces for these relational objects,
@Repository
public interface EmployerRepository extends CrudRepository<Employer, Integer> {

}

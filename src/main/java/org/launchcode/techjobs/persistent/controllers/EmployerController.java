package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    //Part 2 Controllers, Add a private field of EmployerRepository called employerRepository + @Autowired.
    @Autowired
    private EmployerRepository employerRepository;

    //Part 2, Add an index method that responds at /employers with a list of all employers in the database.
    // (method uses template employers/index).
    @GetMapping("")
    public String index (Model model) {
        model.addAttribute("title", "All Employers");
        model.addAttribute("employers", employerRepository.findAll());
        return "employers/index";
    }

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }

    //(Takes care of sending the form back if any of the submitted employer object information is invalid)
    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            //part 2, added model.AddAttribute to pass into view (similar to Home Controller's same method)
            model.addAttribute("title", "Add Employer");

            return "employers/add";
        }
        //Part 2 Controllers, add code to save a valid object:
        employerRepository.save(newEmployer);

        return "redirect:";
    }

    //(In charge of rendering a page to view the contents of an individual employer object)
    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        //Part 2 Controller, updated optEmployer from null to .findById() method with the right argument to look for
        // the given employer object from the data layer.
        Optional <Employer> optEmployer = employerRepository.findById(employerId);

        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }
    }
}

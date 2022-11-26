package org.launchcode.techjobs.persistent.controllers;


import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    //Part 3, Update Home Controller: Add a field employerRepository annotated with @Autowired.
    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobRepository jobRepository;


    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "My Jobs");
        return "index";
    }


    //Part 3, Update Home Controller, (user will select an employer when they create a job)
    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        //(The add job form already includes an employer selection option)
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());

        //Add the employer data from employerRepository into the form template
        List employers = (List<Employer>) employerRepository.findAll();
        //pass into view and match variable name for the employer data of what is already used in templates/add.
        model.addAttribute("employers", employers);

        return "add";
    }


    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam int employerId) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }

        //Part 3 Update Home Controller, Add code to select the employer object that has been chosen to be
        // affiliated with the new job, select the employer using the request parameter you’ve added to
        // the method (employerId).(added all before return redirect)
        Optional <Employer> optEmployer = employerRepository.findById(employerId);
        //form data is validated (similar to code in displayview method in EmployerController)
        if (optEmployer.isPresent()) {
            //employer to be found
            Employer employer = (Employer) optEmployer.get();
            //employer to be set on the new job object
            newJob.setEmployer(employer);
        }
        //save new job
        jobRepository.save(newJob);

        return "redirect:./";
    }


    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        ///mimicked EmployerController comparable method
        Optional<Job> optJob = jobRepository.findById(jobId);
        if (optJob.isPresent()) {
            Job job = (Job) optJob.get();
            model.addAttribute("job", job);
            return "view";
        } else {
            return "redirect:./";
        }
    }


}

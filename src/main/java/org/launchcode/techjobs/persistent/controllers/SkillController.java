package org.launchcode.techjobs.persistent.controllers;


import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


//Part 2 Controller, Create a SkillController class and replicate the steps you followed for
// EmployerController. The new controller should have the methods, index, displayAddSkillForm,
// processAddSkillForm, and displayViewSkill.
// These methods should behave exactly as the corresponding methods in EmployerController.
@Controller
@RequestMapping("skills")
public class SkillController {

    //Add a private field of SkillRepository called skillRepository + @Autowired.
    @Autowired
    private SkillRepository skillRepository;

    //Add an index method that responds at /skills with a list of all skills in the database.
    // (method uses template skills/index).
    @GetMapping("")
    public String index (Model model) {
         model.addAttribute("title", "All Skills");
         model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }


    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }


    //finish part 4
    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            //???add model.AddAttribute to pass into view (similar to Home Controller's same method)
            //model.addAttribute("title", "Add Skill");
            return "skills/add";
        }
        //to save a valid object:
        skillRepository.save(newSkill);
        return "redirect:";
    }


    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {
        //looks for the given skill object from the data layer.
        Optional <Skill> optSkill = skillRepository.findById(skillId);

        if (optSkill.isPresent()) {
            Skill skill = (Skill) optSkill.get();
            model.addAttribute("skill", skill);
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }
}

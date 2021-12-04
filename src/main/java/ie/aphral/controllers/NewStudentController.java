package ie.aphral.controllers;

import ie.aphral.entities.Student;
import ie.aphral.forms.NewStudentForm;
import ie.aphral.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class NewStudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/newstudent")
    public String addAStudent(Model model){
        model.addAttribute("newStudentForm", new NewStudentForm());
        return "newstudent";
    }

    @PostMapping("/newstudent")
    public String addAStudentPost(@Valid NewStudentForm newStudentForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "newstudent";
        }
        Student student = studentService.save(newStudentForm.getNewStudentID(), newStudentForm.getNewStudentEmail(), newStudentForm.getNewStudentFirstName(), newStudentForm.getNewStudentLastName());
        return "redirect:student/" + student.getStudentID();
    }
}

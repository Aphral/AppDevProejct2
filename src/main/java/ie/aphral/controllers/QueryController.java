package ie.aphral.controllers;

import ch.qos.logback.classic.sift.SiftAction;
import ie.aphral.entities.Student;
import ie.aphral.service.NoteService;
import ie.aphral.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QueryController {
    @Autowired
    StudentService studentService;

    @Autowired
    NoteService noteService;

// localhost:80/student/R00134569

    @GetMapping("/student/{studentID}")
    public String showStudentByStudentID(@PathVariable("studentID") String studentID, Model model){
        Student student = studentService.getStudentById(studentID);
        if (student == null){
            model.addAttribute("student", studentID);
            return "notfounderror";

        }
        model.addAttribute("student", student);
        model.addAttribute("notes" , noteService.getAllNotesForStudent(studentID));
        return "student";
    }

    @GetMapping("/students")
    public String showStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/student/delete/{studentID}")
    public String deleteMappingStudent(@PathVariable(name = "studentID") String studentID, Model model){
        studentService.deleteStudent(studentID);
        return "redirect:/students";
//        model.addAttribute("studentID", studentID);
//        return "notfounderror";
    }

}

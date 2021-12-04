package ie.aphral.controllers;

import ie.aphral.entities.Note;
import ie.aphral.entities.Student;
import ie.aphral.forms.NewNoteForm;
import ie.aphral.service.NoteService;
import ie.aphral.service.StudentService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class NewNoteController {

    @Autowired
    NoteService noteService;

    @Autowired
    StudentService studentService;

    @GetMapping("/newnote")
    public String addNewNote(Model model){
        model.addAttribute("newNoteForm", new NewNoteForm());
        model.addAttribute("students", studentService.getAllStudents());
        return "newnote";
    }

    @PostMapping("/newnote")
    public String addNewNotePost(Model model, @Valid NewNoteForm newNoteForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("students", studentService.getAllStudents());
            return "newnote";
        }
        Student student = studentService.getStudentById(newNoteForm.getStudentID());
        Note newNote = noteService.save(newNoteForm.getNewNoteText(), newNoteForm.getNewNoteDateCreation(), student);

        return "redirect:student/"+newNote.getStudentID();
    }

}

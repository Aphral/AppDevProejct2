package ie.aphral;

import ie.aphral.entities.Note;
import ie.aphral.entities.Student;
import ie.aphral.service.NoteService;
import ie.aphral.service.StudentService;
import ie.aphral.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    @Autowired
    NoteService noteService;

    @Override
    public void run(String... args) throws Exception {
        userService.save("test@gmail.com", "password", "mentor", "test", "this");

        Student student1 = studentService.save("R00123456", "pam@mycit.ie",  "Pam", "Beasly");
        Student student2 = studentService.save("R00134569", "jim@mycit.ie",  "Jim", "Halpert");

        noteService.save("student worked on python", new java.util.Date(System.currentTimeMillis()), student1);
        noteService.save("student worked on java", new java.util.Date(System.currentTimeMillis()), student1);

        noteService.save("student didnt show", new java.util.Date(System.currentTimeMillis()), student2);
        noteService.save("student worked on python for the day", new java.util.Date(System.currentTimeMillis()), student2);
        noteService.save("student worked on sql", new java.util.Date(System.currentTimeMillis()), student2);

//        studentService.getAllStudents().forEach(System.out::println);
//        System.out.println();
//        System.out.println("=============================");
//        System.out.println();
//        noteService.getAllNotesForStudent("R00123456").forEach(System.out::println);
//        System.out.println();
//        System.out.println("=============================");
//        System.out.println();
//        noteService.getAllNotesForStudent(student2);
//        System.out.println();
//        System.out.println("=============================");
//        System.out.println();
//
//
//        List<Student> students = studentService.getAllStudentsByQuery();
//
//        for(Student student: students ){
//            System.out.println(student.getEmail());
//            List<Note> notes = student.getNotesForStudent();
//            for(Note note: notes){
//                System.out.println("\t" + note.getText());
//            }
//        }
//
//        System.out.println(studentService.getStudentById("R00123456"));

    }
}

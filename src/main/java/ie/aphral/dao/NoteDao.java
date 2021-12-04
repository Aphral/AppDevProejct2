package ie.aphral.dao;

import ie.aphral.entities.Note;
import ie.aphral.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteDao extends JpaRepository<Note, Integer> {
    List<Note> findAllByStudentID_StudentID(String studentID);
    List<Note> findAllByStudentID(Student student);

}

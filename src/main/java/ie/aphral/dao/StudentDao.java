package ie.aphral.dao;

import ie.aphral.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, String> {
   Student getStudentByStudentID(String studentID);
   Student deleteStudentByStudentID(String studentID);

    @Query(value = "select distinct s from Student s join fetch s.notesForStudent ")
    List<Student> getAllStudentsByQuery();

}

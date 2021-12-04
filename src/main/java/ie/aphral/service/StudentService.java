package ie.aphral.service;

import ie.aphral.entities.Student;

import java.util.List;

public interface StudentService {
    Student getStudentById(String studentId);
    List<Student> getAllStudents();
    Student deleteStudent(String studentID);
    Student save(String studentID, String email, String firstName, String lastName);

    public List<Student> getAllStudentsByQuery();
}



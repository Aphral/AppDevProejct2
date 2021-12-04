package ie.aphral.service;

import ie.aphral.dao.StudentDao;
import ie.aphral.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public Student getStudentById(String studentId) {
        return studentDao.getStudentByStudentID(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student deleteStudent(String studentID) {
        return studentDao.deleteStudentByStudentID(studentID);
    }

    @Override
    public Student save(String studentID, String email, String firstName, String lastName) {
        if(studentDao.existsById(studentID)){
            return null;
        }
        Student newStudent = new Student( studentID, email, firstName, lastName);
        return studentDao.save(newStudent);
    }

    @Override
    public List<Student> getAllStudentsByQuery() {
        return studentDao.getAllStudentsByQuery();
    }
}

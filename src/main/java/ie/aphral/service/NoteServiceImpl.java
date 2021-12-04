package ie.aphral.service;

import ie.aphral.dao.NoteDao;
import ie.aphral.entities.Note;
import ie.aphral.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    NoteDao noteDao;

    @Override
    public List<Note> getAllNotesForStudent(String studentID) {
        return noteDao.findAllByStudentID_StudentID(studentID);
    }

    @Override
    public List<Note> getAllNotesForStudent(Student student) {
        return noteDao.findAllByStudentID(student);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteDao.findAll();
    }

    @Override
    public Note save( String text, Date dateOfCreation, Student studentID) {
        Note newNote = new Note( text, dateOfCreation, studentID);
        return noteDao.save(newNote);
    }
}

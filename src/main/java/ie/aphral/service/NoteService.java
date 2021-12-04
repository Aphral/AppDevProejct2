package ie.aphral.service;

import ie.aphral.entities.Note;
import ie.aphral.entities.Student;

import java.util.Date;
import java.util.List;

public interface NoteService {
    List<Note> getAllNotesForStudent(String studentID);
    List<Note> getAllNotesForStudent(Student student);
    List<Note> getAllNotes();
    Note save(String text, Date dateOfCreation, Student studentID);
}

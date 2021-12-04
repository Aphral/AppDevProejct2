package ie.aphral.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Note {
    @Id
    @GeneratedValue
    private int noteID;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private Date dateOfCreation;

    @ManyToOne
    @JoinColumn(nullable = false, name = "studentID")
    private Student studentID;

    public Note(String text, Date dateOfCreation, Student studentID) {
        this.text = text;
        this.dateOfCreation = dateOfCreation;
        this.studentID = studentID;
    }



}

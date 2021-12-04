package ie.aphral.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @Column(nullable = false, unique = true)
    private String studentID;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }



    @OneToMany(mappedBy = "studentID", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    List<Note> notesForStudent = new ArrayList<>();

    public Student(String studentID, String email, String firstName, String lastName) {
        this.studentID = studentID;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

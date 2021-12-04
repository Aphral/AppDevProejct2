package ie.aphral;

import ie.aphral.dao.StudentDao;
import ie.aphral.entities.Note;
import ie.aphral.entities.Student;
import ie.aphral.service.NoteService;
import ie.aphral.service.StudentService;
import ie.aphral.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
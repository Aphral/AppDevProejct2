package ie.aphral.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class NewNoteForm {
    @Size(min=23, max=23)
    private Date newNoteDateCreation;

    @Size(min=1, max=500)
    private String newNoteText;

    @NotNull
    private String studentID;
}

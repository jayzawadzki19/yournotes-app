package pl.zawadzki.yournotes.viedmodel;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class NoteViewModel {
    private Long id;

    @NotNull
    @Size(min = 5)
    private String title;

    @NotNull
    private String text;

    @NotNull
    private Long notebookId;

    private Date modifiedOn;
}

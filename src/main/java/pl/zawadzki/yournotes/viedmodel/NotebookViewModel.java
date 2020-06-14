package pl.zawadzki.yournotes.viedmodel;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class NotebookViewModel {

    private Long id;

    @NotNull
    private String name;

    private int numberOfNotes;
}

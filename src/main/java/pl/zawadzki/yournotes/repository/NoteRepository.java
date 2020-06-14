package pl.zawadzki.yournotes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zawadzki.yournotes.pojo.Note;
import pl.zawadzki.yournotes.pojo.Notebook;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    List<Note> findAllByNotebook(Notebook notebook);
}

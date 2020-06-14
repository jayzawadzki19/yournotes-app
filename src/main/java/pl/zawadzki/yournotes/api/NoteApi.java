package pl.zawadzki.yournotes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zawadzki.yournotes.pojo.Note;
import pl.zawadzki.yournotes.repository.NoteRepository;
import pl.zawadzki.yournotes.repository.NotebookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/notes")
public class NoteApi {
    private NoteRepository noteRepository;
    private NotebookRepository notebookRepository;

    @Autowired
    public NoteApi(NoteRepository noteRepository, NotebookRepository notebookRepository) {
        this.noteRepository = noteRepository;
        this.notebookRepository = notebookRepository;
    }

    @GetMapping("/all")
    public Iterable<Note> showAll(){
        return noteRepository.findAll();
    }

    @GetMapping("/byId/{id}")
    public Optional<Note> showById(@PathVariable("id") Long id){
        return noteRepository.findById(id);
    }

    @GetMapping("/byNotebook/{id}")
    public Iterable<Note> showByNotebook(@PathVariable("id") Long id){
        List<Note> notes = new ArrayList<>();

        var notebook = notebookRepository.findById(id);

        if(notebook.isPresent()){
            notes = noteRepository.findAllByNotebook(notebook.get());
        }

        return notes;
    }

    @PostMapping("/addNote")
    public Note saveNotebook(@RequestBody Note note){
        return noteRepository.save(note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        noteRepository.deleteById(id);
    }
}

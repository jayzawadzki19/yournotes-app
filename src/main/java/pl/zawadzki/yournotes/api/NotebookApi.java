package pl.zawadzki.yournotes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zawadzki.yournotes.pojo.Notebook;
import pl.zawadzki.yournotes.repository.NotebookRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/notebooks")
public class NotebookApi {
    private NotebookRepository notebookRepository;

    @Autowired
    public NotebookApi(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    @GetMapping("/all")
    public Iterable<Notebook> showAll(){
        return notebookRepository.findAll();
    }

    @PostMapping("/addNotebook")
    public Notebook saveNotebook(@RequestBody Notebook notebook){
        return notebookRepository.save(notebook);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        notebookRepository.deleteById(id);
    }
}

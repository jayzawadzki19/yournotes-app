package pl.zawadzki.yournotes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zawadzki.yournotes.pojo.Notebook;
import pl.zawadzki.yournotes.repository.NotebookRepository;
import pl.zawadzki.yournotes.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/notebooks")
public class NotebookApi {
    private NotebookRepository notebookRepository;
    private UserRepository userRepository;

    @Autowired
    public NotebookApi(NotebookRepository notebookRepository,
                       UserRepository userRepository) {
        this.notebookRepository = notebookRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public Iterable<Notebook> showAll(){
        return notebookRepository.findAll();
    }

    @GetMapping("/byUser/{id}")
    public Iterable<Notebook> showByUser(@PathVariable("id") Long id){
        List<Notebook> notebookList = new ArrayList<>();
        var user = userRepository.findById(id);

        if(user != null){
            notebookList = notebookRepository.findAllByUser(user.get());
        }
        return notebookList;
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

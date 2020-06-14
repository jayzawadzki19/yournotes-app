package pl.zawadzki.yournotes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.zawadzki.yournotes.pojo.Note;
import pl.zawadzki.yournotes.pojo.Notebook;
import pl.zawadzki.yournotes.repository.NoteRepository;
import pl.zawadzki.yournotes.repository.NotebookRepository;

@SpringBootApplication
public class YournotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(YournotesApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(NotebookRepository notebookRepository, NoteRepository noteRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                var defNotebook = new Notebook("Default");
                var defNote = new Note("Hello World", "Create your notes", defNotebook);
                notebookRepository.save(defNotebook);
                noteRepository.save(defNote);
            }
        };
    }
}

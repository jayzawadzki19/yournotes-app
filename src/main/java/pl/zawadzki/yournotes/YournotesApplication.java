package pl.zawadzki.yournotes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.zawadzki.yournotes.pojo.Note;
import pl.zawadzki.yournotes.pojo.Notebook;
import pl.zawadzki.yournotes.pojo.User;
import pl.zawadzki.yournotes.repository.NoteRepository;
import pl.zawadzki.yournotes.repository.NotebookRepository;
import pl.zawadzki.yournotes.repository.UserRepository;

@SpringBootApplication
public class YournotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(YournotesApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(NotebookRepository notebookRepository, NoteRepository noteRepository,
                                        UserRepository userRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                var defUser = new User("user","passwd","user@email.com");
                var defNotebook = new Notebook("Default", defUser);
                var defNote = new Note("Hello World", "Create your notes", defNotebook);
                userRepository.save(defUser);
                notebookRepository.save(defNotebook);
                noteRepository.save(defNote);
            }
        };
    }
}

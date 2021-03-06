package pl.zawadzki.yournotes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zawadzki.yournotes.pojo.Notebook;
import pl.zawadzki.yournotes.pojo.User;

import java.util.List;

@Repository
public interface NotebookRepository extends CrudRepository<Notebook, Long> {
    List<Notebook> findAllByUser(User user);
}

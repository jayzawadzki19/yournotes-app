package pl.zawadzki.yournotes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zawadzki.yournotes.pojo.Notebook;

@Repository
public interface NotebookRepository extends CrudRepository<Notebook, Long> {

}

package trung.com.repositories;

import org.springframework.data.repository.CrudRepository;
import trung.com.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

}

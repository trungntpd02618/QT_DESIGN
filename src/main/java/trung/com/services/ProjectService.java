package trung.com.services;

import java.util.Optional;

import trung.com.models.Project;

public interface ProjectService {

	void deleteAll();

	void deleteAll(Iterable<Project> entities);

	void delete(Project entity);

	void deleteById(Integer id);

	long count();

	Iterable<Project> findAllById(Iterable<Integer> ids);

	Iterable<Project> findAll();

	boolean existsById(Integer id);

	Optional<Project> findById(Integer id);

	Iterable<Project> saveAll(Iterable<Project> entities);

	Project save(Project entity);





}

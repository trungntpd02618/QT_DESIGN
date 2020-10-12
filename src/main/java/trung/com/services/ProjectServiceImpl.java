package trung.com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trung.com.models.Project;
import trung.com.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;

	@Override
	public Project save(Project entity) {
		return projectRepository.save(entity);
	}

	@Override
	public Iterable<Project> saveAll(Iterable<Project> entities) {
		return projectRepository.saveAll(entities);
	}

	@Override
	public Optional<Project> findById(Integer id) {
		return projectRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return projectRepository.existsById(id);
	}

	@Override
	public Iterable<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	public Iterable<Project> findAllById(Iterable<Integer> ids) {
		return projectRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return projectRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		projectRepository.deleteById(id);
	}

	@Override
	public void delete(Project entity) {
		projectRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<Project> entities) {
		projectRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		projectRepository.deleteAll();
	}


	
}

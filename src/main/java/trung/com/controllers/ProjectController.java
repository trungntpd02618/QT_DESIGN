package trung.com.controllers;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import trung.com.dtos.ProujectDto;
import trung.com.models.Project;
import trung.com.services.ProjectService;
@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectservice;
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	@GetMapping("/index")
	public String signup(ModelMap model) {
		return "index";
	}

	@GetMapping()
	public List<Project> getAll() {
		return (List<Project>) projectservice.findAll();
	}
	@PostMapping("/insertAll")
	public List<Project> insert(@RequestBody List<Project> projects){
		return (List<Project>) projectservice.saveAll(projects);
	}
	@PostMapping()
	public Project insert(@RequestBody Project project) {
		return projectservice.save(project);
	}
//	@PutMapping("/{id}/update")
//	public Project update(@PathVariable String id, @RequestBody Project project) {
//		return projectservice.findById(id)
//				.map(old ->{
//					BeanUtils.copyProperties(project, old);
//					return projectservice.save(old);
//				}).get();
//	}
//	@DeleteMapping("/{id}/delete")
//	public ResponseEntity<Void> deleteProject(@PathVariable("id") String id){
//		projectservice.deleteById(id);
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}
	@RequestMapping("/list")
	public String list(ModelMap model){
		List<Project> list = (List<Project>) projectservice.findAll();
		model.addAttribute("projects", list);
		return "bigduan/duan";
		}
	@GetMapping("/add")
	public String add(ModelMap model) {
		ProujectDto project = new ProujectDto();
		model.addAttribute("projectDto", project);
		return "addpost";

	}
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @Validated ProujectDto projectDto, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("message", "Please input or required fields!!");
			model.addAttribute("projectDto", projectDto);
			return "add/addduan";
		}
		if (projectDto.getId() != null && projectDto.getId() > 0) {
			model.addAttribute("message", "The staff updated!");
		} else {
			model.addAttribute("message", "New staff inserted!");

		}
		Path path = Paths.get("src/main/resources/static/image/sanphamdemo/banner/");
		try (InputStream inputStream = projectDto.getImage().getInputStream()) {
			Files.copy(inputStream, path.resolve(projectDto.getImage().getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			String filename = projectDto.getImage().getOriginalFilename();
System.out.println(projectDto.getImage());
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		Project project = new Project();
		project.setId(projectDto.getId());
		project.setName(projectDto.getName());
			project.setLogo(projectDto.getImage().getOriginalFilename());
		project.setCategory(projectDto.getCategory());
		projectservice.save(project);
		model.addAttribute("projectDto", projectDto);
		return "add/addduan";
	}
	@GetMapping("/banner")
	public String banner(ModelMap model) {
		return "bigduan/banner";

	}
	@GetMapping("/baobi")
	public String baobi(ModelMap model) {
		return "bigduan/baobi";

	}
	@GetMapping("/menu")
	public String menu(ModelMap model) {
		return "bigduan/menu";

	}
	@GetMapping("/thiepcuoi")
	public String thiepccuoi(ModelMap model) {
		return "bigduan/thiepcuoi";

	}
	@GetMapping("/vanphong")
	public String vanphong(ModelMap model) {
		return "bigduan/vanphong";

	}
}

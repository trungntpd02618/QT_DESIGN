package trung.com.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.mail.iap.ByteArray;
import trung.com.models.Project;
import trung.com.services.ProjectService;

@Controller
public class ImageController {
@Autowired
private ProjectService projectService;
@RequestMapping(value = "getimage/{id}", method = RequestMethod.GET)
@ResponseBody
public ResponseEntity<ByteArrayResource> downloadLinkInage(@PathVariable Integer id) {
	Optional<Project> sop = projectService.findById(id);
	if(sop.isPresent()) {
Project project = sop.get();
		try {
			Path filename = Paths.get("src/main/resources/static/image/sanphamdemo/banner", project.getLogo());
			byte[] buffer = Files.readAllBytes(filename);
			ByteArrayResource bsr = new ByteArrayResource(buffer);
			return ResponseEntity.ok()
					.contentLength(buffer.length)
					.contentType(MediaType.parseMediaType("image/png"))
					.body(bsr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} return ResponseEntity.badRequest().build();
}
}

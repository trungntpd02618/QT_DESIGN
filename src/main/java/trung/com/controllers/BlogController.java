package trung.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class BlogController {
	@GetMapping("/cntk")
	public String cntk(ModelMap model) {
		return "blog/cntk";

	}
	@GetMapping("/idea")
	public String idea(ModelMap model) {
		return "blog/idea";

	}
	@GetMapping("/khac")
	public String khac(ModelMap model) {
		return "blog/khac";

	}
	@GetMapping("/tintuc")
	public String tintuc(ModelMap model) {
		return "blog/tintuc";

	}
}

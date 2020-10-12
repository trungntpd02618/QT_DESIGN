package trung.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/index")
	public String home(ModelMap model) {

		return "index";
		
	}
	@GetMapping("/duan")
	public String duan(ModelMap model) {

		return "bigduan/duan";
		
	}
	@GetMapping("/dichvu")
	public String dichvu(ModelMap model) {

		return "dichvu/dichvu";
		
	}
	@GetMapping("/blog")
	public String blog(ModelMap model) {

		return "blog/blog";
		
	}
	@GetMapping("/lienhe")
	public String lienhe(ModelMap model) {

		return "lienhe";
		
	}
	@GetMapping("/gioithieu")
	public String gioithieu(ModelMap model) {

		return "gioithieu";
		
	}
}

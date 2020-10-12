package trung.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("services")
public class ServiceController {
	@GetMapping("/ndth")
	public String vanphong(ModelMap model) {
		return "dichvu/ndth";

	}
	@GetMapping("/tkweb")
	public String tkweb(ModelMap model) {
		return "dichvu/tkweb";

	}
	@GetMapping("/inan")
	public String inan(ModelMap model) {
		return "dichvu/inan";

	}
}

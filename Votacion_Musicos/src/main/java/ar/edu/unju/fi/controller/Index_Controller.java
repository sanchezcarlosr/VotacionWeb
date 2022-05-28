package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index_Controller {
	@GetMapping("/inicio")
	public String getIndexController(Model model) {
		return "index";
	}
}

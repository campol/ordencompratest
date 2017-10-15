package com.beitech.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author lcampo
 *
 */
@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
}

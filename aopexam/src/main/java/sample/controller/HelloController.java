package sample.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

//	@RequestMapping(value = "/hello", method= RequestMethod.GET)
	@GetMapping(value = "/hello")
	public String hello(Model model, 
			@RequestParam(value="name", required = false) String name, 
			@RequestParam(value="age", required = false) int age) {
		System.out.println("## hello(): name = " + name + ", age = " + age);
		
		model.addAttribute("greeting", "Hi~ " + name + " is " + age + " years old" );
		return "hello";
	}
	
	@GetMapping(value = "/list")
	public String list(Model model) {
		System.out.println("## list()");
		return "list";
	}
	
}

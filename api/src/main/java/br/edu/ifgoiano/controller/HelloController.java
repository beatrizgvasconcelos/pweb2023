package br.edu.ifgoiano.controller;

import javax.servlet.annotation.WebServlet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/hello")
public class HelloController {
		
	@RequestMapping
	public String digaolá() {
		return "Olá Mundo Spring!";
	}
}

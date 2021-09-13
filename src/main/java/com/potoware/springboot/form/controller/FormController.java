package com.potoware.springboot.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Usuarios - Registro");
		return "form";
	}
	
	@PostMapping("/form")
	public String recibirForm(Model model, @RequestParam(name="username") String username, @RequestParam(name="password") String password, @RequestParam(name="email")  String email) {
		model.addAttribute("titulo","Resultado Formulario");
		model.addAttribute("username",username);
		model.addAttribute("password",password);
		model.addAttribute("email",email);
		return "resultado";
	}

}

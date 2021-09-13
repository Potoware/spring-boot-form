package com.potoware.springboot.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.potoware.springboot.form.models.domain.Usuario;

@Controller
public class FormController {
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Usuarios - Registro");
		
		return "form";
	}
	
	@PostMapping("/form")
	public String recibirForm(Usuario usuario, Model model) {
		
		model.addAttribute("titulo","Resultado Formulario");
		model.addAttribute("usuario",usuario);
		return "resultado";
	}

}

package com.potoware.springboot.form.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.potoware.springboot.form.models.domain.Usuario;

@Controller
public class FormController {
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Usuarios - Registro");
		model.addAttribute("usuario",new Usuario());
		
		return "form";
	}
	
	@PostMapping("/form")
	public String recibirForm(@Valid Usuario usuario, BindingResult result,Model model) {
		model.addAttribute("titulo","Resultado Formulario");
		if(result.hasErrors()) {
			
			
			/*Antigua forma
			 * Map<String,String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err ->{
				errores.put(err.getField(), "El campo ".concat(err.getField().concat(" ").concat(err.getDefaultMessage())));
				});
			model.addAttribute("error", errores);*/
			return "form";
		}
		
		model.addAttribute("usuario",usuario);
		return "resultado";
	}

}

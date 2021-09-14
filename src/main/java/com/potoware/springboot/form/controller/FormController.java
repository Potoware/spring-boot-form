package com.potoware.springboot.form.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.potoware.springboot.form.models.domain.Usuario;
import com.potoware.springboot.form.validators.UsuarioValidador;

@SessionAttributes("usuario")
@Controller
public class FormController {
	@Autowired
	private UsuarioValidador validador;
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Usuarios - Registro");
		Usuario usuario = new Usuario();
		usuario.setNombre("Jhon");
		usuario.setApellido("Doe");
		usuario.setIdentificador("112.254.354.K");
		model.addAttribute("usuario",usuario);
		
		return "form";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class,"fechaNacimiento" ,new CustomDateEditor(dateFormat, false));
	}
	
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result,Model model, SessionStatus status) {
		//validador.validate(usuario, result); -- otra forma de validar
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
		status.setComplete();
		return "resultado";
	}

}

package com.potoware.springboot.form.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.potoware.springboot.form.editors.CargoPropertiesEditor;
import com.potoware.springboot.form.editors.NombreMayusculaEditor;
import com.potoware.springboot.form.editors.RolesEditor;
import com.potoware.springboot.form.models.domain.Cargo;
import com.potoware.springboot.form.models.domain.Role;
import com.potoware.springboot.form.models.domain.Usuario;
import com.potoware.springboot.form.services.CargoService;
import com.potoware.springboot.form.services.RoleService;
import com.potoware.springboot.form.validators.UsuarioValidador;

@SessionAttributes("usuario")
@Controller
public class FormController {
	@Autowired
	private UsuarioValidador validador;
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private CargoPropertiesEditor cargoEditor;
	

	@Autowired
	private RolesEditor roleEditor;
	
	
	
	@ModelAttribute("cargos")
	public List<Cargo> cargos() {
		return cargoService.listar();

	}

	@ModelAttribute("paises")
	public List<String> paises() {
		return Arrays.asList("Colombia", "Espa??a", "Chile", "Bolivia", "Alemania", "Inglaterra");

	}
	
	@ModelAttribute("listaRolesMap")
	public List<Role> listaRoles(){
		
	return this.roleService.listar();
	}
	
	@ModelAttribute("rolesList")
	public List<String> rolesList() {
		List<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");

		return roles;
	}
	
	@ModelAttribute("genero")
	public List<String> genero(){
		return Arrays.asList("Hombre", "Mujer","Prefiero No decirlo");
	}
	
	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap() {

		Map<String, String> paises = new HashMap<String, String>();
		paises.put("ES", "Espa??a");
		paises.put("MX", "Mexico");
		paises.put("CO", "Colombia");
		paises.put("PR", "Peru");
		paises.put("VE", "Venezuela");
		paises.put("GR", "Alemania");

		return paises;
	}

	@ModelAttribute("interesesMap")
	public Map<String, String> interesesMap() {

		Map<String, String> intereses = new HashMap<String, String>();
		intereses.put("INT_MUSICA", "Musica");
		intereses.put("INT_VIDEOJUEGOS", "Video Juegos");
		intereses.put("INT_LITERATURA", "Literatura");
		intereses.put("INT_ESTUDIO", "Estudio");
		intereses.put("INT_DEPORTES", "Deportes");
		intereses.put("GR", "Alemania");

		return intereses;
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Usuarios - Registro");
		Usuario usuario = new Usuario();
		usuario.setNombre("Jhon");
		usuario.setApellido("Doe");
		usuario.setIdentificador("12.254.354-K");
		usuario.setHabilitar(true);
		usuario.setPais("Colombia");
		usuario.setCargo(new Cargo(7, "DEV", "Desarrollo"));
		usuario.setValorSecreto("Un valor Secreto");
		model.addAttribute("usuario", usuario);

		return "form";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, false));

		binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
		binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());
		binder.registerCustomEditor(Cargo.class, "cargo",  cargoEditor);
		binder.registerCustomEditor(Role.class, "roles",  roleEditor);
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
		// validador.validate(usuario, result); -- otra forma de validar
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Resultado Formulario"); 
			/*
			 * Antigua forma Map<String,String> errores = new HashMap<>();
			 * result.getFieldErrors().forEach(err ->{ errores.put(err.getField(),
			 * "El campo ".concat(err.getField().concat(" ").concat(err.getDefaultMessage())
			 * )); }); model.addAttribute("error", errores);
			 */
			return "form";
		}
		
		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name=  "usuario",required=false) Usuario usuario,Model model, SessionStatus status) {
		if(usuario==null) {
			return "redirect:/form";
		}
		model.addAttribute("titulo", "Resultado Formulario");
		status.setComplete();
		return "resultado";
	}

}

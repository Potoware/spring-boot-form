package com.potoware.springboot.form.models.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.potoware.springboot.form.validators.IdentificadorRegex;
import com.potoware.springboot.form.validators.Requerido;

public class Usuario {
	// @NotEmpty --Se validara desde una clase personalizada
	private String nombre;
	// @NotEmpty --Se validara desde una clase personalizada
	@Requerido
	private String apellido;
	@NotBlank
	@Size(min = 3, max = 8)
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	@Email
	private String email;

	// @Pattern(regexp = "[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}") --Se validara
	// desde una clase personalizada
	@IdentificadorRegex()
	private String identificador;

	@NotNull
	@Min(5)
	@Max(5000)
	private Integer cuenta;

	@NotNull
	@Past
	// @DateTimeFormat(pattern="yyyy-MM-dd") -- Forma para revisar la forma en la
	// que se recibe la fecha
	private Date fechaNacimiento;

	@NotEmpty
	private String pais;

	@NotNull
	private Cargo cargo;

	@NotEmpty
	private List<Role> roles;

	@NotEmpty
	private List<String> intereses;
	
	private Boolean habilitar;
	
	@NotEmpty
	private String genero;
	
	

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Boolean getHabilitar() {
		return habilitar;
	}

	public void setHabilitar(Boolean habilitar) {
		this.habilitar = habilitar;
	}

	public List<String> getIntereses() {
		return intereses;
	}

	public void setIntereses(List<String> intereses) {
		this.intereses = intereses;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getCuenta() {
		return cuenta;
	}

	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}

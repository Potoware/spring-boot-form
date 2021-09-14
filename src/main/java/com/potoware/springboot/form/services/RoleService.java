package com.potoware.springboot.form.services;

import java.util.List;

import com.potoware.springboot.form.models.domain.Role;

public interface RoleService {

	public List<Role> listar();
	
	public Role obtenerPorId(Integer id);
}

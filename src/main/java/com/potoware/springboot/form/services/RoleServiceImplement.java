package com.potoware.springboot.form.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.potoware.springboot.form.models.domain.Role;

@Service
public class RoleServiceImplement implements RoleService {

	private List<Role> lista;

	public RoleServiceImplement() {
		this.lista = new ArrayList<>();
		this.lista.add(new Role(1, "Administrador", "ROLE_ADMIN"));
		this.lista.add(new Role(2, "Usuario", "ROLE_USER"));
		this.lista.add(new Role(3, "Moderador", "ROLE_MODERATOR"));
	}

	@Override
	public List<Role> listar() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Role obtenerPorId(Integer id) {

		Role resultado = null;

		for (Role rol : lista) {
			if (id == rol.getId()) {
				resultado = rol;
				break;
			}

		}
		return resultado;

	}

}

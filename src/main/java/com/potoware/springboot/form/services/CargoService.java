package com.potoware.springboot.form.services;

import java.util.List;

import com.potoware.springboot.form.models.domain.Cargo;

public interface CargoService {

	public List<Cargo> listar();
	public Cargo obtenerPorId(Integer id);
}

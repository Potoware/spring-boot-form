package com.potoware.springboot.form.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.potoware.springboot.form.models.domain.Cargo;

@Service
public class CargoServiceImplement implements CargoService {

	private List<Cargo> lista;

	public CargoServiceImplement() {
		this.lista = Arrays.asList(new Cargo(1, "AUX", "Auxiliar"), new Cargo(2, "CEO", "Gerente"),
				new Cargo(3, "ADM", "Administrativa"), new Cargo(4, "SOP", "Soporte"), new Cargo(5, "MER", "Mercadeo"),
				new Cargo(6, "COM", "Comercial"), new Cargo(7, "DEV", "Desarrollo"));

	}

	@Override
	public List<Cargo> listar() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Cargo obtenerPorId(Integer id) {

		Cargo resultado = null;
		for (Cargo car : this.lista) {
			if (id == car.getId()) {
				resultado = car;
				break;

			}

		}
		return resultado;
	}

}

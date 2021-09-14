package com.potoware.springboot.form.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.potoware.springboot.form.services.CargoService;

@Component
public class CargoPropertiesEditor extends PropertyEditorSupport {

	@Autowired
	private CargoService cargoService;

	@Override
	public void setAsText(String idString) throws IllegalArgumentException {
		
			try {
				Integer id = Integer.parseInt(idString);
				this.setValue(cargoService.obtenerPorId(id));
			} catch (NumberFormatException e) {
				setValue(null);
			}
		
	}

}

package com.servisoft.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.servisoft.impl.Conexion;

@FacesValidator("validPROD")
public class ValidPROD extends Conexion implements Validator {
	
	public static boolean prodNOM(String prodNom) {
		String sql = "SELECT NOMPRO FROM PRODUCTO WHERE NOMPRO = '"+ prodNom +"'";
		try {
			PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println();
		}
		
		return false;
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String prodNom = (String) value;
		if(prodNOM(prodNom) == true) {
			FacesMessage msg = new FacesMessage("Este producto ya existe");
			throw new ValidatorException(msg);
		}
	}
}
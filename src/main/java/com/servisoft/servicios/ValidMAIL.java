package com.servisoft.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.servisoft.impl.Conexion;

@FacesValidator("validMAIL")
public class ValidMAIL extends Conexion implements Validator {

	public static boolean cliMAIL(String mail) {
		
		try {
			String sql = "SELECT MAILCLI FROM CLIENTE WHERE MAILCLI = '"+ mail +"' ";
			PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return true;
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("Error en mail repetido: "+ e.getMessage());
		}
		return false;
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String mail = (String) value;
		if(cliMAIL(mail)==true) {
			FacesMessage msg = new FacesMessage("Este correo ya existe");
			throw new ValidatorException(msg);
		}
	}
}
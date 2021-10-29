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

@FacesValidator("validUSER")
public class ValidUSER extends Conexion implements Validator {
	
	public static boolean cliUSER(String user) {
		try {
			String sql = "SELECT USERCLI FROM CLIENTE WHERE USERCLI = '" + user +"'";
			PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return true;
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("Error en usuario: "+ e.getMessage());
		}
		return false;
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		String user = (String) value;
		if(cliUSER(user)==true) {
			System.out.println("Este usuario ya existe");
			FacesMessage msg = new FacesMessage("Este usuario ya existe");
			throw new ValidatorException(msg);
		}
	}

}

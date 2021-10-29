package com.servisoft.impl.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.servisoft.model.ClienteModelo;

public class ClienteDaoTest2 {
	
	private ClienteDao clienteDao = new ClienteDao();
	@Test
	public void test() {
		System.out.println("Test de consulta cliente");
		
		try {
			List<ClienteModelo> clientes = clienteDao.listar();
//			assertTrue("",clientes.size()==0);
			assertTrue(clientes.size()>0);
			
			clientes.forEach(Cli ->{
				System.out.println("Nombre :"+ Cli.getNombre());
			});
			
		} catch (Exception e) {
			System.out.println("Test de consulta cliente Fallo mano :'v");
			e.printStackTrace();
		}
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servisoft.impl.dao;

import com.servisoft.impl.Conexion;
import com.servisoft.model.ClienteModelo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author govas
 */
public class ClienteDaoTest1 {

    public static ClienteDao dao;

    public static ClienteDao getDao() {
        return dao;
    }

    public static void setDao(ClienteDao dao) {
        ClienteDaoTest1.dao = dao;
    }

    public ClienteDaoTest1() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Connection conn = Conexion.conectar();
        try {
            // set auto commit false so any operation in this test will be discarded.
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dao = new ClienteDao();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        Connection conn = Conexion.conectar();
        try {
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void testRegistrar() throws Exception {
//        System.out.println("registrar");
//        ClienteModelo cliente = new ClienteModelo();
//        cliente.setNombre("Joseph");
//        cliente.setApellido("Joseph Florian");
//        cliente.setUsuario("Josep");
//        cliente.setPassword("123456789");
//        cliente.setCelular("933495871");
//        cliente.setDni("60323413");
//        cliente.setCorreo("josep.florian@vallegrande.edu.pe");
//        cliente.setDirec("Jr. Miguel Grau 267");
//        cliente.setCodubi("140416");
//        dao.registrar(cliente);
//        ClienteModelo clientFromDb = dao.getClientByName("Joseph");
//        assertEquals("Joseph", clientFromDb.getNombre());
//    }

//    @Test
//    public void testEliminar() throws Exception {
//        System.out.println("eliminar");
//        ClienteModelo cliente = new ClienteModelo();
//        cliente.setDni("60323413");
//        cliente.setCodigo(102);
//        dao.eliminar(cliente);
//        ClienteModelo clientFromDb = dao.getClientByName("Joseph");
////        assertNull(clientFromDb.getNombre());
//    }

    
//    @Test
//    public void testModificar() throws Exception {
//        System.out.println("modificar");
//        ClienteModelo cliente = new ClienteModelo();
//        cliente.setCodigo(101);
//        cliente.setNombre("Victor");
//        cliente.setApellido("Joseph Florian");
//        cliente.setUsuario("Josep");
//        cliente.setPassword("123456789");
//        cliente.setCelular("933495871");
//        cliente.setDni("60323413");
//        cliente.setCorreo("josep.florian@vallegrande.edu.pe");
//        cliente.setDirec("Jr. Miguel Grau 267");
//        cliente.setCodubi("140416");
//        dao.modificar(cliente);
//        ClienteModelo clientFromDb = dao.getClientByName("Victor");
//        assertEquals("Victor", clientFromDb.getNombre());
//    }

    /**
     * Test of registrar method, of class ClienteDao.
     */
    @Test
    public void testBuscarDNI2() {
        ClienteModelo cli = new ClienteModelo();
        ClienteDao instance = new ClienteDao();
        final String dni = "40728524";
        cli.setDni(dni);
        try {
            instance.buscarDNI(cli);
            System.out.println(cli.getNombre());
            assertEquals("Shirley Jackeline", cli.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

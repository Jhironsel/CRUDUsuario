package com.jhironsel.test;

import java.io.IOException;
import org.json.JSONObject;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sur.softsurena.crudusuario.UsoRestApi;
import static sur.softsurena.crudusuario.UsoRestApi.restUsuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PruebasComponentes {

    private JSONObject user;
    private String url;


    @Before
    public void setUp() {
        user = new JSONObject();
    }

    @Test
    public void test1postUsuario() throws IOException {
        url = "http://localhost:8080/postUsuario/";
        user.put("nombres", "Jhironsel");
        user.put("apellidos", "Diaz");
        user.put("estado", false);
        String postUsuario = UsoRestApi.postUsuario(url, user, "POST");
        assertTrue(postUsuario.contains("Jhironsel"));
    }

    @Test
    public void test2putUsuario() throws IOException {
        url = "http://localhost:8080/updateUsuarioById/1";
        user = new JSONObject();
        user.put("nombres", "Jhasline");
        user.put("apellidos", "Diaz Paniagua");
        user.put("estado", true);
        String postUsuario = UsoRestApi.postUsuario(url, user, "PUT");
        assertTrue(postUsuario.contains("Jhasline"));
    }

    @Test
    public void test3getUsuario() throws IOException {
        url = "http://localhost:8080/getUsuariosById/1";
        String restUsuario = restUsuario(url, "GET");
        assertTrue(restUsuario.contains("Jhasline"));
    }

    @Test
    public void test4getUsuarios() throws IOException {
        url = "http://localhost:8080/getUsuarios";
        String restUsuario = restUsuario(url, "GET");
        assertTrue(restUsuario.contains("Jhasline"));
    }

    @Test
    public void test5deleteUsuario() throws IOException {
        url = "http://localhost:8080/deleteUsuarioById/1";
        String restUsuario = restUsuario(url, "DELETE");
        assertTrue(restUsuario.contains("[]"));
    }

}

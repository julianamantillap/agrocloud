package com.agrocloud.backend.auth;

import com.agrocloud.backend.config.JwtService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtServiceTest {

    private final JwtService jwtService = new JwtService();

    @Test
    void generarToken_debeRetornarTokenNoNulo() {
        String token = jwtService.generarToken("juliana@agrocloud.com", "propietario");
        assertNotNull(token);
        assertFalse(token.isEmpty());
    }

    @Test
    void extraerEmail_debeRetornarEmailCorrecto() {
        String token = jwtService.generarToken("juliana@agrocloud.com", "propietario");
        String email = jwtService.extraerEmail(token);
        assertEquals("juliana@agrocloud.com", email);
    }

    @Test
    void extraerRol_debeRetornarRolCorrecto() {
        String token = jwtService.generarToken("juliana@agrocloud.com", "propietario");
        String rol = jwtService.extraerRol(token);
        assertEquals("propietario", rol);
    }

    @Test
    void esValido_conTokenValido_debeRetornarTrue() {
        String token = jwtService.generarToken("juliana@agrocloud.com", "propietario");
        assertTrue(jwtService.esValido(token));
    }

    @Test
    void esValido_conTokenInvalido_debeRetornarFalse() {
        assertFalse(jwtService.esValido("token.invalido.aqui"));
    }
}

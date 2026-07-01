package com.agrocloud.backend.auth;

import com.agrocloud.backend.config.JwtService;
import com.agrocloud.backend.usuario.Usuario;
import com.agrocloud.backend.usuario.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(UsuarioRepository usuarioRepository,
                          PasswordEncoder passwordEncoder,
                          JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody Map<String, String> body) {
        if (usuarioRepository.findByEmail(body.get("email")).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El email ya está registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(body.get("nombre"));
        usuario.setEmail(body.get("email"));
        usuario.setPasswordHash(passwordEncoder.encode(body.get("password")));
        usuario.setRol(body.getOrDefault("rol", "trabajador"));

        usuarioRepository.save(usuario);

        String token = jwtService.generarToken(usuario.getEmail(), usuario.getRol());
        return ResponseEntity.status(201).body(Map.of(
                "token", token,
                "email", usuario.getEmail(),
                "rol", usuario.getRol()
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        Usuario usuario = usuarioRepository.findByEmail(body.get("email"))
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Credenciales invalidas"));

        if (!passwordEncoder.matches(body.get("password"), usuario.getPasswordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales invalidas");
        }

        String token = jwtService.generarToken(usuario.getEmail(), usuario.getRol());
        return ResponseEntity.ok(Map.of(
                "token", token,
                "email", usuario.getEmail(),
                "rol", usuario.getRol()
        ));
    }
}

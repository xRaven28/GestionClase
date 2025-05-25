package com.gestonclase.Gestion.clase.Rest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsuarioClient {
private final RestTemplate restTemplate = new RestTemplate();

    public boolean usuarioExiste(Long id) {
        try {
            restTemplate.getForObject("http://localhost:8081/Usuarios/" + id, Object.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

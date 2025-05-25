package com.gestonclase.Gestion.clase.Rest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class CursoClient {
private final RestTemplate restTemplate = new RestTemplate();

    public boolean cursoExiste(Long id) {
        try {
            restTemplate.getForObject("http://localhost:8082/cursos/" + id, Object.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

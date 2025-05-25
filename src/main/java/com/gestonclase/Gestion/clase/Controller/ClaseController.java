package com.gestonclase.Gestion.clase.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.gestonclase.Gestion.clase.DTO.*;
import com.gestonclase.Gestion.clase.Service.ClaseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clases")
public class ClaseController {
    private final ClaseService claseService;

    @PostMapping
    public ClaseDTO crear(@RequestBody CrearClaseDTO dto) {
        return claseService.crear(dto);
    }

    @GetMapping("/{id}")
    public ClaseDTO obtener(@PathVariable Long id) {
        return claseService.obtener(id);
    }

    @PutMapping("/{id}")
    public ClaseDTO editar(@PathVariable Long id, @RequestBody CrearClaseDTO dto) {
        return claseService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        claseService.eliminar(id);
    }

    @GetMapping
    public List<ClaseDTO> listar() {
        return claseService.listar();
    }

    @PostMapping("/{claseId}/estudiantes/{estudianteId}")
    public void agregarEstudiante(@PathVariable Long claseId, @PathVariable Long estudianteId) {
        claseService.agregarEstudiante(claseId, estudianteId);
    }

    @DeleteMapping("/{claseId}/estudiantes/{estudianteId}")
    public void removerEstudiante(@PathVariable Long claseId, @PathVariable Long estudianteId) {
        claseService.removerEstudiante(claseId, estudianteId);
    }
}

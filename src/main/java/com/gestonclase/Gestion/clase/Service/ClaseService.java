package com.gestonclase.Gestion.clase.Service;

import java.util.List;

import com.gestonclase.Gestion.clase.DTO.ClaseDTO;
import com.gestonclase.Gestion.clase.DTO.CrearClaseDTO;

public interface ClaseService {
 ClaseDTO crear(CrearClaseDTO dto);
    ClaseDTO obtener(Long id);
    ClaseDTO editar(Long id, CrearClaseDTO dto);
    void eliminar(Long id);
    List<ClaseDTO> listar();
    void agregarEstudiante(Long claseId, Long estudianteId);
    void removerEstudiante(Long claseId, Long estudianteId);
}

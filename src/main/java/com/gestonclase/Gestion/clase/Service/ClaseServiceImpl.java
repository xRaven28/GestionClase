package com.gestonclase.Gestion.clase.Service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.gestonclase.Gestion.clase.DTO.*;
import com.gestonclase.Gestion.clase.Models.ClaseModel;
import com.gestonclase.Gestion.clase.Repository.ClaseRepository;
import com.gestonclase.Gestion.clase.Rest.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClaseServiceImpl implements ClaseService {
private final ClaseRepository claseRepository;
    private final CursoClient cursoClient;
    private final UsuarioClient usuarioClient;

    @Override
    public ClaseDTO crear(CrearClaseDTO dto) {
        if (!cursoClient.cursoExiste(dto.getCursoId())) {
            throw new IllegalArgumentException("Curso no existe");
        }
        if (!usuarioClient.usuarioExiste(dto.getDocenteId())) {
            throw new IllegalArgumentException("Docente no existe");
        }
        ClaseModel model = new ClaseModel();
        BeanUtils.copyProperties(dto, model);
        return toDTO(claseRepository.save(model));
    }

    @Override
    public ClaseDTO obtener(Long id) {
        return claseRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Clase no encontrada"));
    }

    @Override
    public ClaseDTO editar(Long id, CrearClaseDTO dto) {
        ClaseModel model = claseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Clase no encontrada"));

        if (!cursoClient.cursoExiste(dto.getCursoId())) {
            throw new IllegalArgumentException("Curso no existe");
        }
        if (!usuarioClient.usuarioExiste(dto.getDocenteId())) {
            throw new IllegalArgumentException("Docente no existe");
        }

        BeanUtils.copyProperties(dto, model);
        return toDTO(claseRepository.save(model));
    }

    @Override
    public void eliminar(Long id) {
        claseRepository.deleteById(id);
    }

    @Override
    public List<ClaseDTO> listar() {
        return claseRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public void agregarEstudiante(Long claseId, Long estudianteId) {
        ClaseModel clase = claseRepository.findById(claseId)
                .orElseThrow(() -> new IllegalArgumentException("Clase no encontrada"));

        if (!usuarioClient.usuarioExiste(estudianteId)) {
            throw new IllegalArgumentException("Estudiante no existe");
        }

        if (!clase.getEstudiantesId().contains(estudianteId)) {
            clase.getEstudiantesId().add(estudianteId);
        }
        claseRepository.save(clase);
    }

    @Override
    public void removerEstudiante(Long claseId, Long estudianteId) {
        ClaseModel clase = claseRepository.findById(claseId)
                .orElseThrow(() -> new IllegalArgumentException("Clase no encontrada"));
        clase.getEstudiantesId().remove(estudianteId);
        claseRepository.save(clase);
    }

    private ClaseDTO toDTO(ClaseModel model) {
        ClaseDTO dto = new ClaseDTO();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }
}

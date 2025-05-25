package com.gestonclase.Gestion.clase.DTO;

import java.time.LocalDate;
import lombok.Data;

@Data
public class CrearClaseDTO {
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Long cursoId;
    private Long docenteId;
}

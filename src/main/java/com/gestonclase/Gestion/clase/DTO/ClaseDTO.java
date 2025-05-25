package com.gestonclase.Gestion.clase.DTO;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ClaseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Long cursoId;
    private Long docenteId;
    private List<Long> estudiantesId;
    private Map<Long, Integer> descuentos;
}

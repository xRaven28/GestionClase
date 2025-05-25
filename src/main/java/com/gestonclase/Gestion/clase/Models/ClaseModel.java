package com.gestonclase.Gestion.clase.Models;

import java.time.LocalDate;
import java.util.*;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clases")
@Data
public class ClaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private Long cursoId;
    private Long docenteId;

    @ElementCollection
    private List<Long> estudiantesId = new ArrayList<>();

    @ElementCollection
    private Map<Long, Integer> descuentos = new HashMap<>();
}

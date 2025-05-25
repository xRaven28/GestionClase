package com.gestonclase.Gestion.clase.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestonclase.Gestion.clase.Models.ClaseModel;

public interface ClaseRepository extends JpaRepository<ClaseModel, Long>  {

}

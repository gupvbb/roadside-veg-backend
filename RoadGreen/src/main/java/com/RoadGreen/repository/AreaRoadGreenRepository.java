package com.RoadGreen.repository;

import java.util.List;
import java.util.Optional;

import com.RoadGreen.model.AreaRoadGreen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RoadGreen.model.AreaRoadGreen;
import com.RoadGreen.model.StatusVegetacao;

@Repository
public interface AreaRoadGreenRepository extends JpaRepository<AreaRoadGreen, Long> {

    Optional<AreaRoadGreen> findByCodigo(String codigo);

    List<AreaRoadGreen> findByStatus(StatusVegetacao status);

    List<AreaRoadGreen> findByRodoviaContainingIgnoreCase(String rodovia);

    List<AreaRoadGreen> findByStatusOrderByAtualizadoEmDesc(StatusVegetacao status);

    List<AreaRoadGreen> findAllByOrderByStatusDesc();
}
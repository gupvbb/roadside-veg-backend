package com.RoadGreen.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RoadGreen.model.AreaRoadGreen;
import com.RoadGreen.model.Medicao;

@Repository
public interface MedicaoRepository extends JpaRepository<Medicao, Long> {

    List<Medicao> findByAreaOrderByDataColetaDesc(AreaRoadGreen area);

    List<Medicao> findByAreaIdOrderByDataColetaDesc(Long areaId);

    List<Medicao> findByDataColetaBetween(LocalDateTime inicio, LocalDateTime fim);

    List<Medicao> findTop10ByAreaOrderByDataColetaDesc(AreaRoadGreen area);
}

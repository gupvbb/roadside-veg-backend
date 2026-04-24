package com.RoadGreen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RoadGreen.dto.AreaRoadGreenDTO;
import com.RoadGreen.model.AreaRoadGreen;
import com.RoadGreen.model.StatusVegetacao;
import com.RoadGreen.service.AreaRoadGreenService;

@RestController
@RequestMapping("/api/areas")
@CrossOrigin(origins = "*")
public class AreaRoadGreenController {

    @Autowired
    private AreaRoadGreenService areaService;

    @GetMapping
    public ResponseEntity<List<AreaRoadGreenDTO>> listarTodas() {
        return ResponseEntity.ok(areaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaRoadGreenDTO> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(areaService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<AreaRoadGreenDTO> buscarPorCodigo(@PathVariable String codigo) {
        try {
            return ResponseEntity.ok(areaService.buscarPorCodigo(codigo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<AreaRoadGreenDTO>> listarPorStatus(@PathVariable StatusVegetacao status) {
        return ResponseEntity.ok(areaService.listarPorStatus(status));
    }

    @PostMapping
    public ResponseEntity<AreaRoadGreenDTO> criar(@RequestBody AreaRoadGreen area) {
        return ResponseEntity.status(HttpStatus.CREATED).body(areaService.criar(area));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaRoadGreenDTO> atualizar(
            @PathVariable Long id,
            @RequestBody AreaRoadGreen area) {
        try {
            return ResponseEntity.ok(areaService.atualizar(id, area));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            areaService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

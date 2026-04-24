package com.RoadGreen.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoadGreen.dto.AreaRoadGreenDTO;
import com.RoadGreen.model.AreaRoadGreen;
import com.RoadGreen.model.StatusVegetacao;
import com.RoadGreen.repository.AreaRoadGreenRepository;
import com.RoadGreen.repository.MedicaoRepository;

@Service
public class AreaRoadGreenService {

    @Autowired
    private AreaRoadGreenRepository areaRepository;

    @Autowired
    private MedicaoRepository medicaoRepository;

    public List<AreaRoadGreenDTO> listarTodas() {
        return areaRepository.findAllByOrderByStatusDesc()
                .stream()
                .map(area -> {
                    AreaRoadGreenDTO dto = new AreaRoadGreenDTO(area);
                    dto.setTotalMedicoes((long) medicaoRepository.findByAreaIdOrderByDataColetaDesc(area.getId()).size());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public AreaRoadGreenDTO buscarPorId(Long id) {
        AreaRoadGreen area = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Área não encontrada"));
        AreaRoadGreenDTO dto = new AreaRoadGreenDTO(area);
        dto.setTotalMedicoes((long) medicaoRepository.findByAreaIdOrderByDataColetaDesc(area.getId()).size());
        return dto;
    }

    public AreaRoadGreenDTO buscarPorCodigo(String codigo) {
        AreaRoadGreen area = areaRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Área não encontrada"));
        AreaRoadGreenDTO dto = new AreaRoadGreenDTO(area);
        dto.setTotalMedicoes((long) medicaoRepository.findByAreaIdOrderByDataColetaDesc(area.getId()).size());
        return dto;
    }

    public List<AreaRoadGreenDTO> listarPorStatus(StatusVegetacao status) {
        return areaRepository.findByStatus(status)
                .stream()
                .map(area -> {
                    AreaRoadGreenDTO dto = new AreaRoadGreenDTO(area);
                    dto.setTotalMedicoes((long) medicaoRepository.findByAreaIdOrderByDataColetaDesc(area.getId()).size());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public AreaRoadGreenDTO criar(AreaRoadGreen area) {
        return new AreaRoadGreenDTO(areaRepository.save(area));
    }

    public AreaRoadGreenDTO atualizar(Long id, AreaRoadGreen areaAtualizada) {
        AreaRoadGreen area = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Área não encontrada"));

        area.setCodigo(areaAtualizada.getCodigo());
        area.setRodovia(areaAtualizada.getRodovia());
        area.setKmInicial(areaAtualizada.getKmInicial());
        area.setKmFinal(areaAtualizada.getKmFinal());
        area.setLocalizacao(areaAtualizada.getLocalizacao());
        area.setTipoTerreno(areaAtualizada.getTipoTerreno());
        area.setDensidade(areaAtualizada.getDensidade());
        area.setAlturaMedia(areaAtualizada.getAlturaMedia());
        area.setComplexidade(areaAtualizada.getComplexidade());
        area.setStatus(areaAtualizada.getStatus());
        area.setAtualizadoEm(LocalDateTime.now());

        return new AreaRoadGreenDTO(areaRepository.save(area));
    }

    public void deletar(Long id) {
        areaRepository.deleteById(id);
    }

    public void atualizarStatusArea(Long areaId, Double densidade, Double altura) {
        AreaRoadGreen area = areaRepository.findById(areaId)
                .orElseThrow(() -> new RuntimeException("Área não encontrada"));

        if (densidade > 70 || altura > 1.5) {
            area.setStatus(StatusVegetacao.URGENTE);
            area.setProximaIntervencao(LocalDateTime.now().plusDays(7));
        } else if (densidade > 50 || altura > 1.0) {
            area.setStatus(StatusVegetacao.ATENCAO);
            area.setProximaIntervencao(LocalDateTime.now().plusDays(15));
        } else {
            area.setStatus(StatusVegetacao.NORMAL);
            area.setProximaIntervencao(LocalDateTime.now().plusDays(30));
        }

        area.setDensidade(densidade);
        area.setAlturaMedia(altura);
        area.setUltimaMedicao(LocalDateTime.now());

        areaRepository.save(area);
    }
}

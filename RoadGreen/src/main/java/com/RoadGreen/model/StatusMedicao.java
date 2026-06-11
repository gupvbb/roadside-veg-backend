package com.RoadGreen.model;

public enum StatusMedicao {
    NORMAL("NORMAL - Dentro dos limites"),
    ALERTA("ALERTA - Monitoramento recomendado"),
    CRITICO("CRITICO - Intervenção urgente");

    private final String descricao;

    StatusMedicao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

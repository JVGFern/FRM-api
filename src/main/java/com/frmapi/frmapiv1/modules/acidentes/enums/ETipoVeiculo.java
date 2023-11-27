package  com.frmapi.frmapiv1.modules.acidentes.enums;

import lombok.Getter;

public enum ETipoVeiculo {
    AVIAO("Avião"),
    DRONE("Drone"),
    MISSEL("Missel"),
    HELICOPTERO("Helicoptero");

    @Getter
    private String tipo;

    ETipoVeiculo(String tipo) {
        this.tipo = tipo;
    }
}

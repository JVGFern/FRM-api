package  com.frmapi.frmapiv1.modules.radar.dto;

import  com.frmapi.frmapiv1.modules.radar.model.BaseRadares;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RadarContagemResponse {

    private Integer fluxoVeiculos;
    private Long totalRegistros;
    private BaseRadares baseRadares;

    public RadarContagemResponse(Integer fluxoVeiculos, Long totalRegistros) {
        this.fluxoVeiculos = fluxoVeiculos;
        this.totalRegistros = totalRegistros;
    }
}

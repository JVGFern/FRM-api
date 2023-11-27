package  com.frmapi.frmapiv1.modules.trajetos.dto;

import  com.frmapi.frmapiv1.modules.radar.model.BaseRadares;
import  com.frmapi.frmapiv1.modules.trajetos.model.Trajetos;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Optional;

@Data
@NoArgsConstructor
public class TrajetosResponse {

    private Trajetos trajetoCompleto;
    private BaseRadares radarOrigem;
    private BaseRadares radarDestino;

    public TrajetosResponse(Trajetos trajetoCompleto, Optional<BaseRadares> radarOrigem,
                            Optional<BaseRadares> radarDestino) {
        this.trajetoCompleto = trajetoCompleto;
        this.radarOrigem = !radarOrigem.isEmpty() ? radarOrigem.get() : null;
        this.radarDestino = !radarDestino.isEmpty() ? radarDestino.get() : null;
    }
}

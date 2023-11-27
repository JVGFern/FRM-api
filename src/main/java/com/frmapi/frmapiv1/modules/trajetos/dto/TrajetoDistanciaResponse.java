package  com.frmapi.frmapiv1.modules.trajetos.dto;

import  com.frmapi.frmapiv1.modules.trajetos.model.Trajetos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrajetoDistanciaResponse {

    private Trajetos trajeto;
    private BigDecimal distancia;

}

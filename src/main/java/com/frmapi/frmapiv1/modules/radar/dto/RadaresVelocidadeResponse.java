package  com.frmapi.frmapiv1.modules.radar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RadaresVelocidadeResponse {

    private String velocidade;
    private Long totalRadares;

}

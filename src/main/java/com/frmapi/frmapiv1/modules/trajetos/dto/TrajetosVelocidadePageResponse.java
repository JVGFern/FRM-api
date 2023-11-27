package  com.frmapi.frmapiv1.modules.trajetos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrajetosVelocidadePageResponse {

    private Long totalElements;
    private Page<TrajetosVelocidadesMediasResponse> trajetosVelocidadesMediasResponse;

}

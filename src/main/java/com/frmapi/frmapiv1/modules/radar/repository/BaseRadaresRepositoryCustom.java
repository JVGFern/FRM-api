package  com.frmapi.frmapiv1.modules.radar.repository;

import  com.frmapi.frmapiv1.modules.radar.dto.RadaresVelocidadeResponse;
import  com.frmapi.frmapiv1.modules.radar.model.BaseRadares;

import java.util.List;

public interface BaseRadaresRepositoryCustom {

    List<Integer> findLoteDistict();

    List<String> findEnquadramentoDistict();

    List<String> findVelocidadeDistinct();

    List<BaseRadares> findRadaresByVelocidade(Integer velocidade);

    List<RadaresVelocidadeResponse> findTotalRadaresByVelocidade();
}

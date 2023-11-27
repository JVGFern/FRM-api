package  com.frmapi.frmapiv1.modules.radar.repository;

import  com.frmapi.frmapiv1.modules.radar.dto.TiposPorRadarResponse;
import  com.frmapi.frmapiv1.modules.radar.model.Contagens;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ContagensRepository extends JpaRepository<Contagens, Integer>,
    ContagensRepositoryCustom {

    List<Contagens> findByTipo(Integer tipo);

    @Query(value = "select new  com.frmapi.frmapiv1.modules.radar.dto.TiposPorRadarResponse(c.localidade, "
        + "c.tipo, count(c.tipo)) from Contagens c group by c.localidade, c.tipo order by c.localidade asc")
    Page<TiposPorRadarResponse> findTiposPorRadaresGroupBy(Pageable pageable);

    List<Contagens> findByDataHoraBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);
}

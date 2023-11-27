package  com.frmapi.frmapiv1.modules.trajetos.repository;

import  com.frmapi.frmapiv1.modules.trajetos.model.Trajetos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrajetosRepository extends JpaRepository<Trajetos, Integer> {

    List<Trajetos> findByOrigem(Integer origem);

    Optional<Trajetos> findByOrigemAndDestino(Integer origem, Integer destino);
}

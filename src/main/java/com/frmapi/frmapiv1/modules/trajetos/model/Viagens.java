package  com.frmapi.frmapiv1.modules.trajetos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "viagens")
public class Viagens {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "INICIO")
    @NotNull
    private Integer inicio;

    @Column(name = "DATA_INICIO")
    @NotNull
    private LocalDateTime dataInicio;

    @Column(name = "FINAL")
    @NotNull
    private Integer finalViagem;

    @Column(name = "DATA_FINAL")
    @NotNull
    private LocalDateTime dataFinal;

    @Column(name = "TIPO")
    @NotNull
    private Integer tipo;
}
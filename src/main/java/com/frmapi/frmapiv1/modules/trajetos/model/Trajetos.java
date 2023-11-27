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
@Table(name = "trajetos")
public class Trajetos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "VIAGEM_ID", referencedColumnName = "id")
    @NotNull
    private Viagens viagem;


    @Column(name = "TIPO")
    @NotNull
    private Integer tipo;

    @Column(name = "DATA_INICIO")
    @NotNull
    private LocalDateTime dataInicio;

    @Column(name = "DATA_FINAL")
    @NotNull
    private LocalDateTime dataFinal;

    @Column(name = "ORIGEM")
    @NotNull
    private Integer origem;

    @Column(name = "DESTINO")
    @NotNull
    private Integer destino;

    @Column(name = "V0")
    @NotNull
    private Integer v0;

    @Column(name = "V1")
    @NotNull
    private Integer v1;
}

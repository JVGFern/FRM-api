
package com.example.frm.model.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Entregas")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrega;

    @Column(name = "origemTrajeto")
    private int origemTrajeto;

    @Column(name = "destinoTrajeto")
    private int destinoTrajeto;

    @Column(name = "carga")
    private string carga;

    @NotNull
    @Column(name = "status")
    private String status;
}

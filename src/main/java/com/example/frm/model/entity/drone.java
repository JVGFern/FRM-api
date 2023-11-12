package com.example.frm.model.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "drones")
public class drone extends Location{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "drone")
    private String nome;
    @NotNull
    @Column(name = "carga")
    private String carga;

    @NotNull
    @Column(name = "bateria")
    private int bateria;

    @NotNull
    @Column(name = "status")
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entrega", referencedColumnName = "idEntrega")
    public long entrega;

}

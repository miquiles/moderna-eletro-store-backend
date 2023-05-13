package com.moderna.eletrostore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 150)
    private String nome;
    @Column(nullable = false, length = 14)
    private String documento;
    @Column(nullable = false, length = 12)
    private String dataNascimento;

    @OneToMany
    @JoinColumn(name = "cliente_id")
    private List<Contato> contatos;

    @OneToMany
    @JoinColumn(name = "cliente_id")
    private List<Endereco> enderecos;
}

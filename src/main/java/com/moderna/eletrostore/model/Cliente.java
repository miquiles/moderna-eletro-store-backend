package com.moderna.eletrostore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    @Column(nullable = false)
    List<Contato> contatos;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    @Column(nullable = false)
    private List<Endereco> enderecos;

}

package com.moderna.eletrostore.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String ddd;
    private String numero;
    private String descricao;

    @ManyToOne
    private Cliente cliente;
}

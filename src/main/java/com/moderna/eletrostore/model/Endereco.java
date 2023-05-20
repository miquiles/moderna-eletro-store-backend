package com.moderna.eletrostore.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logradouro;
    private String bairro;
    private String numero;
    private String cep;
    private String UF;
    private String cidade;
    private String complemento;

}

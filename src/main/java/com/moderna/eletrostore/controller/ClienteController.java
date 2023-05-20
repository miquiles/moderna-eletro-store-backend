package com.moderna.eletrostore.controller;

import com.moderna.eletrostore.model.Cliente;
import com.moderna.eletrostore.model.Contato;
import com.moderna.eletrostore.model.Endereco;
import com.moderna.eletrostore.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteRepository clienteRepository;

    @PostMapping("/salvar")
    private void salvar(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
    }

    @GetMapping("listar-mok")
    public Cliente exibir(){
        List<Contato> contatos = new ArrayList<>();
        Contato contato = new Contato();
        contato.setDdd("81");
        contato.setNumero("9999999");
        contato.setEmail("@gmail");
        contatos.add(contato);
        Endereco endereco = new Endereco();
        List<Endereco> enderecos = new ArrayList<>();
        endereco.setNumero("111");
        enderecos.add(endereco);
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Bruno");
        cliente.setDocumento("111");
        cliente.setContatos(contatos);
        cliente.setEnderecos(enderecos);

        return cliente;
    }
}

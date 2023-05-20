package com.moderna.eletrostore.controller;

import com.moderna.eletrostore.model.Cliente;
import com.moderna.eletrostore.model.Contato;
import com.moderna.eletrostore.model.Endereco;
import com.moderna.eletrostore.repository.ClienteRepository;
import com.moderna.eletrostore.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

    @PostMapping("/salvar")
    public void salvar(@RequestBody Cliente cliente){
        clienteService.salvar(cliente);
    }

    @GetMapping("/listar-mok")
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

    @GetMapping("/listar-todos")
    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

//    @GetMapping("/buscar/{id}")
//    public Optional<Cliente> buscarPorId(@PathVariable Long id) throws Exception {
//        return Optional.ofNullable(clienteRepository.findById(id).orElseThrow(() -> new Exception("Client not found")));
//    }

    @GetMapping("/buscar/{id}")
    public Optional<Cliente> buscarPorId(@PathVariable Long id){
        return clienteRepository.findById(id);
    }

    @DeleteMapping("deletar-todos")
    public void deletarTodos(){
        clienteRepository.deleteAll();
    }

    @DeleteMapping("deletar/{id}")
    public void deletarPorId(@PathVariable Long id){
        clienteRepository.deleteById(id);
    }





}

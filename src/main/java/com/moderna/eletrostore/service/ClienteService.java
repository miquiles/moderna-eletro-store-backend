package com.moderna.eletrostore.service;

import com.moderna.eletrostore.model.Cliente;
import com.moderna.eletrostore.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {

    ClienteRepository clienteRepository;

    public void salvar(Cliente cliente){
        Cliente clienteRetorno = clienteRepository.findByDocumento(cliente.getDocumento());

        if(clienteRetorno.getDocumento().equals(cliente.getDocumento())){
            System.out.println("Cliente existente");
        }else{
            clienteRepository.save(cliente);
        }
    }
}

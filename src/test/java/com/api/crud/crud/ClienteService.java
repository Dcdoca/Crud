package com.api.crud.crud;

import org.springframework.stereotype.Service;

import com.api.crud.crud.Classe.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ClienteService {
    private final List<Cliente> clientes = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Cliente> getAllClientes() {
        return new ArrayList<>(clientes);
    }

    public Optional<Cliente> getClienteById(Long id) {
        return clientes.stream().filter(cliente -> cliente.getId().equals(id)).findFirst();
    }

    public Cliente createCliente(Cliente cliente) {
        cliente.setId(counter.incrementAndGet());
        clientes.add(cliente);
        return cliente;
    }

    public Optional<Cliente> updateCliente(Long id, Cliente clienteDetails) {
        return getClienteById(id).map(cliente -> {
            cliente.setNome(clienteDetails.getNome());
            cliente.setCpf(clienteDetails.getCpf());
            cliente.setEndereco(clienteDetails.getEndereco());
            cliente.setTelefone(clienteDetails.getTelefone());
            cliente.setEmail(clienteDetails.getEmail());
            cliente.setDataNascimento(clienteDetails.getDataNascimento());
            return cliente;
        });
    }

    public boolean deleteCliente(Long id) {
        return clientes.removeIf(cliente -> cliente.getId().equals(id));
    }
}


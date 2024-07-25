package com.api.crud.crud.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.crud.crud.ClienteService;
import com.api.crud.crud.Classe.Cliente;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        return clienteService.updateCliente(id, clienteDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        if (clienteService.deleteCliente(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
















//import org.springframework.web.bind.annotation.*;

//import com.api.crud.crud.Cliente;

//@RestController
//@RequestMapping("clientes")
//public class ClienteController {

    // Get all clients
    //@GetMapping
    //public String getAllClientes() {
        //if(!Cliente.clientes.isEmpty()) {
            // Usar o Gson para retornar os objetos
          //  return Cliente.clientes.toString();
       // } else {
          //  return "Não há clientes cadastrados.";
        //}
    //}

   // @PostMapping
   // public String addCliente(@RequestBody Cliente cliente) {

      //  System.out.println("Adicionando cliente...");

       // Cliente.clientes.add(cliente);
       // return "Cliente adicionado com sucesso!";
   // }
//}
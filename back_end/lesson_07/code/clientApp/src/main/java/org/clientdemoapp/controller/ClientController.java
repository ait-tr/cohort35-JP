package org.clientdemoapp.controller;

import lombok.AllArgsConstructor;
import org.clientdemoapp.entity.Client;
import org.clientdemoapp.entity.RequestDto;
import org.clientdemoapp.service.AddClientService;
import org.clientdemoapp.service.DeleteClientService;
import org.clientdemoapp.service.FindService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    private final AddClientService addClientService;
    private final FindService findService;
    private final DeleteClientService deleteClientService;

    @PostMapping(value = "/addNew")
    public ResponseEntity<Integer> addNew(@RequestBody RequestDto request) {
        return addClientService.addClient(request);
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return findService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable  Integer id) {
        return findService.findById(id);
    }

    @GetMapping("/findByName")
    // localhost:8080/clients/findByName?nameClient=John
        public ResponseEntity<Client> findByName(@RequestParam(value = "nameClient") String clientName) {
        return findService.findByName(clientName);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteClient(@PathVariable(name = "id") Integer id) {
        return deleteClientService.deleteClient(id);
    }

}

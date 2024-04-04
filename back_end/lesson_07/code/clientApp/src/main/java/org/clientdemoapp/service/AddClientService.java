package org.clientdemoapp.service;

import org.clientdemoapp.entity.Client;
import org.clientdemoapp.entity.RequestDto;
import org.clientdemoapp.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddClientService {

    private final ClientRepository repository;

    public AddClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Integer> addClient(RequestDto request){
        Client newClient = new Client(request.getName(), request.getEmail(), request.getPhone());
        Integer idNewClient = repository.create(newClient);
        return new ResponseEntity<>(idNewClient, HttpStatus.CREATED);
    }


}

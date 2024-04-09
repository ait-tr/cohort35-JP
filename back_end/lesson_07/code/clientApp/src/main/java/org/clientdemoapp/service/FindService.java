package org.clientdemoapp.service;

import org.clientdemoapp.entity.Client;
import org.clientdemoapp.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindService {
    private final ClientRepository repository;

    public FindService(ClientRepository repository) {
        this.repository = repository;
    }


    public ResponseEntity<List<Client>> findAll(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Client> findById(Integer id) {
        Optional<Client> findClientOptional = repository.findById(id);

        if (findClientOptional.isPresent()) {
            return new ResponseEntity<>(findClientOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Client> findByName(String clientName) {
        Optional<Client> findClientOptional = repository.findByName(clientName);

        if (findClientOptional.isPresent()) {
            return new ResponseEntity<>(findClientOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


}

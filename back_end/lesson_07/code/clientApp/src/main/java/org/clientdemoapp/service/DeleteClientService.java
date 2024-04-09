package org.clientdemoapp.service;

import org.clientdemoapp.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteClientService {

    private final ClientRepository repository;

    public DeleteClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Boolean> deleteClient(Integer id){

        Boolean deleteResult = repository.delete(id);

        if (deleteResult) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }


    }


}

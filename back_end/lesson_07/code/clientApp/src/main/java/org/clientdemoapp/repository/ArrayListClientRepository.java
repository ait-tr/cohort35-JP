package org.clientdemoapp.repository;

import org.clientdemoapp.entity.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArrayListClientRepository implements ClientRepository{

    private Integer clientId = 0;

    private List<Client> database = new ArrayList<>();


    @Override
    public Integer create(Client client) {
        client.setId(++clientId);
        database.add(client);
        return clientId;
    }

    @Override
    public List<Client> findAll() {
        return database;
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return database.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Client> findByName(String name) {
        return  database.stream()
                .filter(entity -> entity.getName().equals(name))
                .findFirst();
    }

    @Override
    public boolean update(Client request, Integer id) {
        Optional<Client> optionalClientForUpdate = findById(id);

        if (optionalClientForUpdate.isPresent()) {
            Client clientForUpdate = optionalClientForUpdate.get();
            clientForUpdate.setName(request.getName());
            clientForUpdate.setPhone(request.getPhone());
            clientForUpdate.setEmail(request.getEmail());
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Client> optionalClientForDelete = findById(id);

        if (optionalClientForDelete.isPresent()) {
            Client clientForDelete = optionalClientForDelete.get();
            database.remove(clientForDelete);
            return true;
        }

        return false;
    }
}

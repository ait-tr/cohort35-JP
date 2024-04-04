package org.clientdemoapp.repository;

import org.clientdemoapp.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Integer create(Client client);

    List<Client> findAll();

    Optional<Client> findById(Integer id);

    Optional<Client> findByName(String name);

    boolean update(Client client, Integer id);

    boolean delete(Integer id);

}

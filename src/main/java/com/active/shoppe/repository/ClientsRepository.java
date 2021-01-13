package com.active.shoppe.repository;

import com.active.shoppe.model.Clients;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientsRepository extends MongoRepository<Clients, String> {

    List<Clients> findAll();
    Optional <Clients>  getClientsById(String uniqueId);
    Boolean existsByUniqueId(String uniqueId);

}

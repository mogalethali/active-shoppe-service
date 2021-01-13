package com.active.shoppe.service;

import com.active.shoppe.dto.ClientsDTO;
import com.active.shoppe.exception.ClientAlreadyInUseException;
import com.active.shoppe.exception.ClientNotFoundException;
import com.active.shoppe.model.Clients;
import com.active.shoppe.repository.ClientsRepository;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Service
@Log
@Setter
public class ClientsService {
    @Autowired
    private ClientsRepository clientsRepository;


    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }

    public Clients createClients(ClientsDTO clientsDTO) {
        if (uniqueIdAlreadyExists(clientsDTO.getUniqueId())) {
            throw new ClientAlreadyInUseException(clientsDTO.getUniqueId());
        }
        Clients newClient = createClient(clientsDTO);
        return clientsRepository.save(newClient);
    }

    public Optional<Clients> getClientByUniqueId(String uniqueId) throws ClientNotFoundException {
        Optional<Clients> clients = clientsRepository.getClientsById(uniqueId);
        if (clients == null) {
            throw new ClientNotFoundException(uniqueId);
        }
         return clients;
    }


    /**
     * Save the user to the database
     */
    public Clients save(Clients clients) {
        return clientsRepository.save(clients);
    }

    private Clients createClient(ClientsDTO clientsDTO) {

        Clients clients = new Clients();
        clients.setName(clientsDTO.getName());
        clients.setUniqueId(clientsDTO.getUniqueId());
        return clients;
    }

    private Boolean uniqueIdAlreadyExists(String uniqueId) {
        return clientsRepository.existsByUniqueId(uniqueId);
    }
}

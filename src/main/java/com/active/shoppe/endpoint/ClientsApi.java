package com.active.shoppe.endpoint;

import com.active.shoppe.dto.ClientsDTO;
import com.active.shoppe.model.Clients;
import com.active.shoppe.service.ClientsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/shop/clients")
@Api(value = "Momentum clients with  Active Days")
@Log
public class ClientsApi {
    @Autowired
    private ClientsService clientsService;


    @GetMapping("")
    @ApiOperation(value = "Get client List of active days ", code = 200, response = Clients.class)
    public ResponseEntity getListOfClient() {
        return ResponseEntity.ok(clientsService.getAllClients());
    }

    @PostMapping("")
    @ApiOperation(value = "Add client to momentum active days")
    public ResponseEntity createClient(@Valid @RequestBody ClientsDTO clientRequest) {
        return ResponseEntity.ok( clientsService.createClients(clientRequest));
    }

    @GetMapping("/{uniqueId}")
    @ApiOperation(value = "Get client By unique id ", code = 200, response = Clients.class)
    public ResponseEntity getClientByUniqueId(@NotNull @PathVariable String uniqueId) {
        return ResponseEntity.ok(clientsService.getClientByUniqueId(uniqueId));
    }
}

package com.active.shoppe.service;

import com.active.shoppe.exception.ClientNotFoundException;
import com.active.shoppe.exception.NotEnoughPointsException;
import com.active.shoppe.model.Clients;
import com.active.shoppe.model.Products;
import com.active.shoppe.model.PurchaseRequest;
import com.active.shoppe.repository.ProductsRepository;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@Log
@Setter
public class ProductService {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ClientsService clientsService;

    public List<Products> getListOfProduct() {

        return productsRepository.findAll();
    }

    public Optional<Products> purchaseListOfProduct(@NotNull(message = "UniqueId Cannot be null")
                                                            String uniqueId,
                                                    PurchaseRequest purchaseRequest) {
        Clients clients = clientsService.getClientByUniqueId(uniqueId)
                .orElseThrow(() -> new ClientNotFoundException(uniqueId));
        double totalProductPoints = 0.0;
        List<Products> productsList = getListOfProduct();
        for (Products products : productsList) {
            if (purchaseRequest.getProductCode().contains(products.getProductCode())) {
                totalProductPoints += products.getCostOfPoints();
            }
        }

        if (totalProductPoints >= clients.getActivePoints()) {
            throw new NotEnoughPointsException();
        }
        clients.setActivePoints(clients.getActivePoints() - totalProductPoints);
        clientsService.save(clients);
        return null;
    }
}

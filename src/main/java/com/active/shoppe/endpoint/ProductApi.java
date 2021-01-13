package com.active.shoppe.endpoint;

import com.active.shoppe.model.PurchaseRequest;
import com.active.shoppe.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/shop/products")
@Api(value = "Momentum List of active Products")

public class ProductApi {

    @Autowired
    private ProductService productService;


    @GetMapping("")
    @ApiOperation(value = "Returns all product with their information")
    public ResponseEntity getListOfProduct()
    {
       return ResponseEntity.ok(productService.getListOfProduct());
    }

    @PostMapping("/purchase/")
    @ApiOperation(value = "Purchase one or more of product")
    public ResponseEntity purchaseListOfProduct(@ApiParam(value = "Branch id to check against") @RequestParam("uniqueId") String uniqueId, @Valid @RequestBody PurchaseRequest purchaseRequest) {

        return ResponseEntity.ok(productService.purchaseListOfProduct(uniqueId,purchaseRequest));
    }
}

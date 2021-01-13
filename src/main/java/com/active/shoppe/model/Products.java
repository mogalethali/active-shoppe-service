package com.active.shoppe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.Currency;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Products {
    @Id
    private String id;

    @NotEmpty(message = "Name is mandatory")
    private String name;

    @NotEmpty(message = "productCode is mandatory")
    private String productCode;

    @NotEmpty(message = "Cost Of points is mandatory")
    private double costOfPoints;

}

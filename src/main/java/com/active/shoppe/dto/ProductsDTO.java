package com.active.shoppe.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class ProductsDTO  implements Serializable {

    @NotNull(message = "Name  cannot be null")
    private String name;
    @NotNull(message = "Product list cannot be null")
    private String productCode;
    @NotNull(message = "Cost of points required")
    private double costOfPoint;
}

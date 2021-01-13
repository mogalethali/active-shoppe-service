package com.active.shoppe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clients")
public class Clients {
    @Id
    private String id;

    @NotEmpty(message = "uniqueId is mandatory")
    private String uniqueId;

    @NotEmpty(message = "name is mandatory")
    private String name;

    @NotEmpty(message = " ActivePoins cannot be null")
    private double activePoints;

}

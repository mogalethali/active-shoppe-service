package com.active.shoppe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class ClientRequest implements Serializable {
    @Valid
    @NotNull(message = "Client name cannot be null")
    private String name;
    @NotNull(message = "UniqueId number cannot be null")
    private String uniqueId;
}

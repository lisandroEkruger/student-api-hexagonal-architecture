package com.app.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {

  @NotBlank(message = "El Nombre no puede estar vacío ni ser nulo.")
  private String firstname;

  @NotBlank(message = "El Apellido no puede estar vacío ni ser nulo.")
  private String lastname;

  @NotNull(message = "La Edad no puede ser nulo.")
  private Integer age;

  @NotBlank(message = "La Dirección no puede estar vacío ni nulo.")
  private String address;

}

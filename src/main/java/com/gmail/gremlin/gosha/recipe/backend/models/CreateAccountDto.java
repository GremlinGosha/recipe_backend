package com.gmail.gremlin.gosha.recipe.backend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountDto {
  String name;
  String surname;
  String email;
  String phone;
}

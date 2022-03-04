package com.getdrop.recipe.usecase.recipe.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Ingredient {

  @NonNull
  String name;

  int quantity;

  @NonNull
  String units;
}

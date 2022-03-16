package com.getdrop.recipe.usecase.recipe.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Step {

  int order;

  @NonNull
  String instructions;
}

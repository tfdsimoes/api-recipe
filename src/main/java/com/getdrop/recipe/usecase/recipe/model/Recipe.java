package com.getdrop.recipe.usecase.recipe.model;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Recipe {
  String id;

  String name;

  String description;

  @Singular
  List<Ingredient> ingredients;

  @Singular
  List<Step> steps;

  @Singular
  List<String> tools;
}

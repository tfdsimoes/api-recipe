package com.getdrop.recipe.usecase.recipe.fixtures;

import com.getdrop.recipe.rest.controller.model.IngredientDTO;
import com.getdrop.recipe.usecase.recipe.model.Ingredient;

public class IngredientFixtures {

  public static final Ingredient INGREDIENT = Ingredient.builder()
      .name("name")
      .quantity(1)
      .units("units")
      .build();

  public static final IngredientDTO INGREDIENT_DTO = new IngredientDTO()
      .name("name")
      .quantity(1)
      .units("units");
}

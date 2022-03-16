package com.getdrop.recipe.usecase.recipe.repository.impl.mongo.fixtures;

import com.getdrop.recipe.usecase.recipe.repository.impl.mongo.document.IngredientDocument;

public class IngredientFixtures {
  public static final IngredientDocument INGREDIENT_DOCUMENT = IngredientDocument.builder()
      .name("name")
      .quantity(1)
      .units("units")
      .build();
}

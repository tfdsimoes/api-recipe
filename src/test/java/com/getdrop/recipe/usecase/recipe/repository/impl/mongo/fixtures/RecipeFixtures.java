package com.getdrop.recipe.usecase.recipe.repository.impl.mongo.fixtures;

import static com.getdrop.recipe.usecase.recipe.repository.impl.mongo.fixtures.IngredientFixtures.INGREDIENT_DOCUMENT;
import static com.getdrop.recipe.usecase.recipe.repository.impl.mongo.fixtures.StepFixtures.STEP_DOCUMENT;

import com.getdrop.recipe.usecase.recipe.repository.impl.mongo.document.RecipeDocument;

public class RecipeFixtures {

  public static final RecipeDocument RECIPE_DOCUMENT = RecipeDocument.builder()
      .id("id")
      .name("name")
      .description("description")
      .ingredient(INGREDIENT_DOCUMENT)
      .step(STEP_DOCUMENT)
      .tool("tool")
      .build();
}

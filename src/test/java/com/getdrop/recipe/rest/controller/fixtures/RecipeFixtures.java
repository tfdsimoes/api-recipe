package com.getdrop.recipe.rest.controller.fixtures;

import static com.getdrop.recipe.rest.controller.fixtures.IngredientFixtures.INGREDIENT;
import static com.getdrop.recipe.rest.controller.fixtures.IngredientFixtures.INGREDIENT_DTO;
import static com.getdrop.recipe.rest.controller.fixtures.StepFixtures.STEP;
import static com.getdrop.recipe.rest.controller.fixtures.StepFixtures.STEP_DTO;

import java.util.List;

import com.getdrop.recipe.rest.controller.model.RequestRecipeDTO;
import com.getdrop.recipe.rest.controller.model.SavedRecipeDTO;
import com.getdrop.recipe.usecase.recipe.model.Recipe;

public class RecipeFixtures {

  public static final Recipe RECIPE_WITHOUT_ID = Recipe.builder()
      .name("name")
      .description("description")
      .ingredient(INGREDIENT)
      .step(STEP)
      .tools(List.of("tool"))
      .build();

  public static final Recipe RECIPE_WITH_ID = RECIPE_WITHOUT_ID.toBuilder()
      .id("id")
      .build();

  public static final SavedRecipeDTO SAVED_RECIPE_DTO = new SavedRecipeDTO()
      .id("id")
      .name("name")
      .description("description")
      .ingredients(List.of(INGREDIENT_DTO))
      .steps(List.of(STEP_DTO))
      .tools(List.of("tool"));

  public static final RequestRecipeDTO REQUEST_RECIPE_DTO = new RequestRecipeDTO()
      .name("name")
      .description("description")
      .ingredients(List.of(INGREDIENT_DTO))
      .steps(List.of(STEP_DTO))
      .tools(List.of("tool"));
}

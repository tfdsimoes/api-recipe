package com.getdrop.recipe.usecase.recipe.rest.controller.mapper;

import static com.getdrop.recipe.usecase.recipe.fixtures.RecipeFixtures.RECIPE_WITHOUT_ID;
import static com.getdrop.recipe.usecase.recipe.fixtures.RecipeFixtures.RECIPE_WITH_ID;
import static com.getdrop.recipe.usecase.recipe.fixtures.RecipeFixtures.REQUEST_RECIPE_DTO;
import static com.getdrop.recipe.usecase.recipe.fixtures.RecipeFixtures.SAVED_RECIPE_DTO;
import static com.getdrop.recipe.usecase.recipe.fixtures.RecipeFixtures.UPDATE_RECIPE;
import static com.getdrop.recipe.usecase.recipe.fixtures.RecipeFixtures.UPDATE_RECIPE_WITH_ID;
import static org.assertj.core.api.Assertions.assertThat;

import com.getdrop.recipe.usecase.recipe.common.mapper.RecipeMapper;
import com.getdrop.recipe.usecase.recipe.common.mapper.RecipeMapperImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class RecipeMapperTest {

  private final IngredientMapper ingredientMapper = Mappers.getMapper(IngredientMapper.class);

  private final StepMapper stepMapper = Mappers.getMapper(StepMapper.class);

  private final RecipeMapper recipeMapper = new RecipeMapperImpl(ingredientMapper, stepMapper);

  @Test
  @DisplayName("Convert RequestRecipeDTO to Recipe")
  void shouldMapToModel() {
    var result = recipeMapper.toModel(REQUEST_RECIPE_DTO);
    assertThat(result).isEqualTo(RECIPE_WITHOUT_ID);
  }

  @Test
  @DisplayName("Convert Recipe to SaveRecipeDTO")
  void shouldMapToDTO() {
    var result = recipeMapper.toDTO(RECIPE_WITH_ID);
    assertThat(result).isEqualTo(SAVED_RECIPE_DTO);
  }

  @Test
  @DisplayName("Update Recipe with UpdateRecipe")
  void shouldUpdateRecipe() {
    var result = RECIPE_WITH_ID.toBuilder().build();
    recipeMapper.update(result, UPDATE_RECIPE);
    assertThat(result).isEqualTo(UPDATE_RECIPE_WITH_ID);
  }
}

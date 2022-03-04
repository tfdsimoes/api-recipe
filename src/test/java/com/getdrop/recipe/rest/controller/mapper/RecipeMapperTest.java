package com.getdrop.recipe.rest.controller.mapper;

import static com.getdrop.recipe.rest.controller.fixtures.RecipeFixtures.RECIPE_WITHOUT_ID;
import static com.getdrop.recipe.rest.controller.fixtures.RecipeFixtures.RECIPE_WITH_ID;
import static com.getdrop.recipe.rest.controller.fixtures.RecipeFixtures.REQUEST_RECIPE_DTO;
import static com.getdrop.recipe.rest.controller.fixtures.RecipeFixtures.SAVED_RECIPE_DTO;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class RecipeMapperTest {

  private final RecipeMapper recipeMapper = Mappers.getMapper(RecipeMapper.class);

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
}

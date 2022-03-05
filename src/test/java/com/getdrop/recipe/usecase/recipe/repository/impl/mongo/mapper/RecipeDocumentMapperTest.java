package com.getdrop.recipe.usecase.recipe.repository.impl.mongo.mapper;

import static com.getdrop.recipe.usecase.recipe.fixtures.RecipeFixtures.RECIPE_WITH_ID;
import static com.getdrop.recipe.usecase.recipe.repository.impl.mongo.fixtures.RecipeFixtures.RECIPE_DOCUMENT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class RecipeDocumentMapperTest {

  private final StepDocumentMapper stepDocumentMapper = Mappers.getMapper(StepDocumentMapper.class);

  private final IngredientDocumentMapper ingredientDocumentMapper = Mappers.getMapper(IngredientDocumentMapper.class);

  private final RecipeDocumentMapper recipeDocumentMapper = new RecipeDocumentMapperImpl(ingredientDocumentMapper, stepDocumentMapper);

  @Test
  @DisplayName("Convert Recipe to RecipeDocument")
  void shouldMapToDocument() {
    var result = recipeDocumentMapper.toDocument(RECIPE_WITH_ID);
    assertThat(result).isEqualTo(RECIPE_DOCUMENT);
  }

  @Test
  @DisplayName("Convert RecipeDocument to Recipe")
  void shouldMapToModel() {
    var result = recipeDocumentMapper.toModel(RECIPE_DOCUMENT);
    assertThat(result).isEqualTo(RECIPE_WITH_ID);
  }
}

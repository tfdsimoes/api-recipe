package com.getdrop.recipe.usecase.recipe.repository.impl.mongo.mapper;

import static com.getdrop.recipe.usecase.recipe.fixtures.IngredientFixtures.INGREDIENT;
import static com.getdrop.recipe.usecase.recipe.repository.impl.mongo.fixtures.IngredientFixtures.INGREDIENT_DOCUMENT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class IngredientDocumentMapperTest {

  private final IngredientDocumentMapper mapper = Mappers.getMapper(IngredientDocumentMapper.class);

  @Test
  @DisplayName("Convert Ingredient to IngredientDocument")
  void shouldMapToDocument() {
    var result = mapper.toDocument(INGREDIENT);
    assertThat(result).isEqualTo(INGREDIENT_DOCUMENT);
  }

  @Test
  @DisplayName("Convert IngredientDocument to Ingredient")
  void shouldMapToModel() {
    var result = mapper.toModel(INGREDIENT_DOCUMENT);
    assertThat(result).isEqualTo(INGREDIENT);
  }
}

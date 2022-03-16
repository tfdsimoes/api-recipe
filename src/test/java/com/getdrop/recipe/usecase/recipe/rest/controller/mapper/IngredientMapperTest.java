package com.getdrop.recipe.usecase.recipe.rest.controller.mapper;

import static com.getdrop.recipe.usecase.recipe.fixtures.IngredientFixtures.INGREDIENT;
import static com.getdrop.recipe.usecase.recipe.fixtures.IngredientFixtures.INGREDIENT_DTO;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class IngredientMapperTest {

  private final IngredientMapper mapper = Mappers.getMapper(IngredientMapper.class);

  @Test
  @DisplayName("Convert IngredientDTO to Ingredient")
  void shouldMapToModel() {
    var result = mapper.toModel(INGREDIENT_DTO);
    assertThat(result).isEqualTo(INGREDIENT);
  }

  @Test
  @DisplayName("Convert Ingredient to IngredientDTO")
  void shouldMapToDTO() {
    var result = mapper.toDTO(INGREDIENT);
    Assertions.assertThat(result).isEqualTo(INGREDIENT_DTO);
  }
}

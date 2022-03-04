package com.getdrop.recipe.rest.controller.mapper;

import static com.getdrop.recipe.rest.controller.fixtures.IngredientFixtures.INGREDIENT;
import static com.getdrop.recipe.rest.controller.fixtures.IngredientFixtures.INGREDIENT_DTO;
import static org.assertj.core.api.Assertions.assertThat;

import com.getdrop.recipe.rest.controller.model.IngredientDTO;
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
    assertThat(result).isEqualTo(INGREDIENT_DTO);
  }
}

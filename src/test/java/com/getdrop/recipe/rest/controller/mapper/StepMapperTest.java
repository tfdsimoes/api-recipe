package com.getdrop.recipe.rest.controller.mapper;

import static com.getdrop.recipe.rest.controller.fixtures.StepFixtures.STEP;
import static com.getdrop.recipe.rest.controller.fixtures.StepFixtures.STEP_DTO;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class StepMapperTest {

  private final StepMapper mapper = Mappers.getMapper(StepMapper.class);

  @Test
  @DisplayName("Convert StepDTO to Step")
  void shouldMapToModel() {
    var result = mapper.toModel(STEP_DTO);
    assertThat(result).isEqualTo(STEP);
  }

  @Test
  @DisplayName("Convert Step to StepDTO")
  void shouldMapToDTO() {
    var result = mapper.toDTO(STEP);
    assertThat(result).isEqualTo(STEP_DTO);
  }
}

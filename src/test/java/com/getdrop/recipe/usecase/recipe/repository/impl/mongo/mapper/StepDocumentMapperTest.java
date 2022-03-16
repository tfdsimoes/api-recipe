package com.getdrop.recipe.usecase.recipe.repository.impl.mongo.mapper;

import static com.getdrop.recipe.usecase.recipe.fixtures.StepFixtures.STEP;
import static com.getdrop.recipe.usecase.recipe.repository.impl.mongo.fixtures.StepFixtures.STEP_DOCUMENT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class StepDocumentMapperTest {

  private final StepDocumentMapper mapper = Mappers.getMapper(StepDocumentMapper.class);

  @Test
  @DisplayName("Convert Step to StepDocument")
  void shouldMapToDocument() {
    var result = mapper.toDocument(STEP);
    assertThat(result).isEqualTo(STEP_DOCUMENT);
  }

  @Test
  @DisplayName("Convert StepDocument to Step")
  void shouldMapToModel() {
    var result = mapper.toModel(STEP_DOCUMENT);
    assertThat(result).isEqualTo(STEP);
  }
}

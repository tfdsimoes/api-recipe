package com.getdrop.recipe.usecase.recipe.repository.impl.mongo.document;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "step")
public class StepDocument {

  int order;

  @NonNull
  String instructions;
}

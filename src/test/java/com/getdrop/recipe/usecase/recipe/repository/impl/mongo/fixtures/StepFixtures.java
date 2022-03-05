package com.getdrop.recipe.usecase.recipe.repository.impl.mongo.fixtures;

import com.getdrop.recipe.usecase.recipe.repository.impl.mongo.document.StepDocument;

public class StepFixtures {

  public static final StepDocument STEP_DOCUMENT = StepDocument.builder()
      .order(1)
      .instructions("instructions")
      .build();
}

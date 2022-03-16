package com.getdrop.recipe.usecase.recipe.fixtures;

import com.getdrop.recipe.rest.controller.model.StepDTO;
import com.getdrop.recipe.usecase.recipe.model.Step;

public class StepFixtures {

  public static final Step STEP = Step.builder()
      .order(1)
      .instructions("instructions")
      .build();

  public static final StepDTO STEP_DTO = new StepDTO()
      .order(1)
      .instructions("instructions");
}

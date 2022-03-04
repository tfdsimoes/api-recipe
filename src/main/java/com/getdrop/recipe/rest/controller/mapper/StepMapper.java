package com.getdrop.recipe.rest.controller.mapper;

import com.getdrop.recipe.common.mapper.CommonMapperConfig;
import com.getdrop.recipe.rest.controller.model.StepDTO;
import com.getdrop.recipe.usecase.recipe.model.Step;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class)
public interface StepMapper {

  Step toModel(StepDTO stepDTO);

  StepDTO toDTO(Step step);
}

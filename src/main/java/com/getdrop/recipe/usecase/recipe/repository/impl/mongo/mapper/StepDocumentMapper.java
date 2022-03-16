package com.getdrop.recipe.usecase.recipe.repository.impl.mongo.mapper;

import com.getdrop.recipe.common.mapper.CommonMapperConfig;
import com.getdrop.recipe.usecase.recipe.model.Step;
import com.getdrop.recipe.usecase.recipe.repository.impl.mongo.document.StepDocument;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class)
public interface StepDocumentMapper {

  StepDocument toDocument(Step step);

  Step toModel(StepDocument stepDocument);
}

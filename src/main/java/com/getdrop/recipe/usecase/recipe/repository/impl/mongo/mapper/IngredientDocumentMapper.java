package com.getdrop.recipe.usecase.recipe.repository.impl.mongo.mapper;

import com.getdrop.recipe.common.mapper.CommonMapperConfig;
import com.getdrop.recipe.usecase.recipe.model.Ingredient;
import com.getdrop.recipe.usecase.recipe.repository.impl.mongo.document.IngredientDocument;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class)
public interface IngredientDocumentMapper {

  Ingredient toModel(IngredientDocument document);

  IngredientDocument toDocument(Ingredient ingredient);
}

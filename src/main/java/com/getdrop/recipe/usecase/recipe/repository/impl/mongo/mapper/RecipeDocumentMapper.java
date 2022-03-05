package com.getdrop.recipe.usecase.recipe.repository.impl.mongo.mapper;

import java.util.List;

import com.getdrop.recipe.common.mapper.CommonMapperConfig;
import com.getdrop.recipe.usecase.recipe.model.Recipe;
import com.getdrop.recipe.usecase.recipe.repository.impl.mongo.document.RecipeDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CommonMapperConfig.class, uses = {IngredientDocumentMapper.class, StepDocumentMapper.class})
public interface RecipeDocumentMapper {

  @Mapping(target = "tool", ignore = true)
  @Mapping(target = "step", ignore = true)
  @Mapping(target = "ingredient", ignore = true)
  Recipe toModel(RecipeDocument recipeDocument);

  @Mapping(target = "tool", ignore = true)
  @Mapping(target = "step", ignore = true)
  @Mapping(target = "ingredient", ignore = true)
  RecipeDocument toDocument(Recipe recipe);

  List<Recipe> toModels(List<RecipeDocument> recipeDocuments);
}

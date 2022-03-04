package com.getdrop.recipe.rest.controller.mapper;

import com.getdrop.recipe.common.mapper.CommonMapperConfig;
import com.getdrop.recipe.rest.controller.model.RequestRecipeDTO;
import com.getdrop.recipe.rest.controller.model.SavedRecipeDTO;
import com.getdrop.recipe.usecase.recipe.model.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CommonMapperConfig.class, uses = {IngredientMapper.class, StepMapper.class})
public interface RecipeMapper {

  @Mapping(target = "tool", ignore = true)
  @Mapping(target = "step", ignore = true)
  @Mapping(target = "ingredient", ignore = true)
  @Mapping(target = "id", ignore = true)
  Recipe toModel(RequestRecipeDTO requestRecipeDTO);

  SavedRecipeDTO toDTO(Recipe recipe);
}

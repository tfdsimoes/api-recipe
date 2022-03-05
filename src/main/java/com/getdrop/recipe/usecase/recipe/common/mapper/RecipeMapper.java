package com.getdrop.recipe.usecase.recipe.common.mapper;

import java.util.List;

import com.getdrop.recipe.common.mapper.CommonMapperConfig;
import com.getdrop.recipe.rest.controller.model.RequestRecipeDTO;
import com.getdrop.recipe.rest.controller.model.SavedRecipeDTO;
import com.getdrop.recipe.usecase.recipe.model.Recipe;
import com.getdrop.recipe.usecase.recipe.rest.controller.mapper.IngredientMapper;
import com.getdrop.recipe.usecase.recipe.rest.controller.mapper.StepMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(config = CommonMapperConfig.class, uses = {IngredientMapper.class, StepMapper.class})
public interface RecipeMapper {

  @Mapping(target = "tool", ignore = true)
  @Mapping(target = "step", ignore = true)
  @Mapping(target = "ingredient", ignore = true)
  @Mapping(target = "id", ignore = true)
  Recipe toModel(RequestRecipeDTO requestRecipeDTO);

  SavedRecipeDTO toDTO(Recipe recipe);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void update(@MappingTarget Recipe recipe, Recipe updateRecipe);

  List<SavedRecipeDTO> toDTOs(List<Recipe> recipes);
}

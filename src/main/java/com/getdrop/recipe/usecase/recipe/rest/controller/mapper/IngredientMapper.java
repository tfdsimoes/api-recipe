package com.getdrop.recipe.usecase.recipe.rest.controller.mapper;

import com.getdrop.recipe.common.mapper.CommonMapperConfig;
import com.getdrop.recipe.rest.controller.model.IngredientDTO;
import com.getdrop.recipe.usecase.recipe.model.Ingredient;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class)
public interface IngredientMapper {

  Ingredient toModel(IngredientDTO ingredientDTO);

  IngredientDTO toDTO(Ingredient ingredient);
}

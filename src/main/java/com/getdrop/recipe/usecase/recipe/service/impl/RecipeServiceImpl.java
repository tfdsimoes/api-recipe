package com.getdrop.recipe.usecase.recipe.service.impl;

import java.util.List;

import com.getdrop.recipe.common.exception.ElementNotFoundException;
import com.getdrop.recipe.usecase.recipe.model.Recipe;
import com.getdrop.recipe.usecase.recipe.repository.RecipeRepository;
import com.getdrop.recipe.usecase.recipe.common.mapper.RecipeMapper;
import com.getdrop.recipe.usecase.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

  private final RecipeRepository recipeRepository;

  private final RecipeMapper recipeMapper;

  @Override
  public Recipe create(Recipe newRecipe) {
    log.info("[RecipeServiceImpl] Create new recipe: {}", newRecipe);
    return recipeRepository.create(newRecipe);
  }

  @Override
  public List<Recipe> getAll(String name, List<String> ingredients, List<String> tools, int offset, int limit) {
    log.info("[RecipeServiceImpl] Find all recipes: name {}, ingredients {}, tools {}, limit {}, offset {}",
        name, ingredients, tools, limit, offset);
    return recipeRepository.getAll(name, ingredients, tools, offset, limit);
  }

  @Override
  public Recipe findById(String id) {
    log.info("[RecipeServiceImpl] Search by id: {}", id);
    return getRecipeById(id);
  }

  @Override
  public void deleteById(String id) {
    log.info("[RecipeServiceImpl] Delete by id: {}", id);
    getRecipeById(id);
    recipeRepository.deleteById(id);
  }

  @Override
  public Recipe update(String id, Recipe updateRecipe) {
    var recipe = getRecipeById(id);
    recipeMapper.update(recipe, updateRecipe);
    return recipeRepository.update(recipe);
  }

  private Recipe getRecipeById(String id) {
    var optionalRecipe = recipeRepository.findById(id);

    if(optionalRecipe.isEmpty()) {
      throw new ElementNotFoundException("Recipe", id);
    }

    return optionalRecipe.get();
  }
}

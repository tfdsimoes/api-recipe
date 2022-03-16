package com.getdrop.recipe.usecase.recipe.rest.controller;

import java.util.List;

import com.getdrop.recipe.common.controller.RestExceptionHandler;
import com.getdrop.recipe.rest.controller.api.RecipeApi;
import com.getdrop.recipe.rest.controller.model.RequestRecipeDTO;
import com.getdrop.recipe.rest.controller.model.SavedRecipeDTO;
import com.getdrop.recipe.usecase.recipe.common.mapper.RecipeMapper;
import com.getdrop.recipe.usecase.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RecipeController extends RestExceptionHandler implements RecipeApi {

  private final RecipeMapper recipeMapper;

  private final RecipeService recipeService;

  @Override
  public ResponseEntity<SavedRecipeDTO> createRecipe(RequestRecipeDTO requestRecipeDTO) {
    log.info("[RecipeController] Create recipe: {}", requestRecipeDTO);
    var recipe = recipeService.create(recipeMapper.toModel(requestRecipeDTO));
    return ResponseEntity.ok(recipeMapper.toDTO(recipe));
  }

  @Override
  public ResponseEntity<Void> deleteRecipe(String id) {
    log.info("[RecipeController] Delete recipe by id: {}", id);
    recipeService.deleteById(id);
    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<List<SavedRecipeDTO>> getAllRecipes(Integer offset, Integer limit, String name, List<String> tools,
      List<String> ingredients) {
    log.info("[RecipeController] Find all recipes: name {}, ingredients {}, tools {}, limit {}, offset {}",
        name, ingredients, tools, limit, offset);
    var recipes = recipeService.getAll(name, ingredients, tools, offset, limit);
    return ResponseEntity.ok(recipeMapper.toDTOs(recipes));
  }

  @Override
  public ResponseEntity<SavedRecipeDTO> getRecipe(String id) {
    log.info("[RecipeController] Get recipe by id: {}", id);
    var recipe = recipeService.findById(id);
    return ResponseEntity.ok(recipeMapper.toDTO(recipe));
  }

  @Override
  public ResponseEntity<SavedRecipeDTO> updateRecipe(String id, RequestRecipeDTO requestRecipeDTO) {
    log.info("[RecipeController] Patch recipe: {} {}", id, requestRecipeDTO);
    var recipe = recipeService.update(id, recipeMapper.toModel(requestRecipeDTO));
    return ResponseEntity.ok(recipeMapper.toDTO(recipe));
  }


}

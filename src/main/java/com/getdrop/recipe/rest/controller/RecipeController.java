package com.getdrop.recipe.rest.controller;

import java.util.List;

import com.getdrop.recipe.common.controller.RestExceptionHandler;
import com.getdrop.recipe.rest.controller.api.RecipeApi;
import com.getdrop.recipe.rest.controller.model.RequestRecipeDTO;
import com.getdrop.recipe.rest.controller.model.SavedRecipeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController extends RestExceptionHandler implements RecipeApi {

  @Override
  public ResponseEntity<SavedRecipeDTO> createRecipe(RequestRecipeDTO requestRecipeDTO) {
    return RecipeApi.super.createRecipe(requestRecipeDTO);
  }

  @Override
  public ResponseEntity<Void> deleteRecipe(String id) {
    return RecipeApi.super.deleteRecipe(id);
  }

  @Override
  public ResponseEntity<List<SavedRecipeDTO>> getAllRecipes(Integer offset, Integer limit) {
    return RecipeApi.super.getAllRecipes(offset, limit);
  }

  @Override
  public ResponseEntity<SavedRecipeDTO> getRecipe(String id) {
    return RecipeApi.super.getRecipe(id);
  }

  @Override
  public ResponseEntity<SavedRecipeDTO> updateRecipe(String id, RequestRecipeDTO requestRecipeDTO) {
    return RecipeApi.super.updateRecipe(id, requestRecipeDTO);
  }
}

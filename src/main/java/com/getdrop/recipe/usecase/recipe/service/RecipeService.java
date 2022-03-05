package com.getdrop.recipe.usecase.recipe.service;

import java.util.List;

import com.getdrop.recipe.usecase.recipe.model.Recipe;

public interface RecipeService {

  Recipe create(Recipe newRecipe);

  List<Recipe> getAll(String name, List<String> ingredients, List<String> tools);

  Recipe findById(String id);

  void deleteById(String id);

  Recipe update(String id, Recipe updateRecipe);
}

package com.getdrop.recipe.usecase.recipe.repository;

import java.util.List;
import java.util.Optional;

import com.getdrop.recipe.usecase.recipe.model.Recipe;

public interface RecipeRepository {

  Recipe create(Recipe newRecipe);

  List<Recipe> getAll(String name, List<String> ingredients, List<String> tools);

  Optional<Recipe> findById(String id);

  void deleteById(String id);

  Recipe update(Recipe updateRecipe);
}

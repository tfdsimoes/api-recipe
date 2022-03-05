package com.getdrop.recipe.usecase.recipe.repository.impl.mongo;

import java.util.List;
import java.util.Optional;

import com.getdrop.recipe.usecase.recipe.model.Recipe;
import com.getdrop.recipe.usecase.recipe.repository.RecipeRepository;
import com.getdrop.recipe.usecase.recipe.repository.impl.mongo.crud.RecipeCrud;
import com.getdrop.recipe.usecase.recipe.repository.impl.mongo.mapper.RecipeDocumentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RecipeRepositoryImpl implements RecipeRepository {

  private final RecipeCrud crud;

  private final RecipeDocumentMapper mapper;

  @Override
  public Recipe create(Recipe newRecipe) {
    log.info("[RecipeRepositoryImpl] Saving recipe: {}", newRecipe);
    var result = crud.save(mapper.toDocument(newRecipe));
    return mapper.toModel(result);
  }

  @Override
  public List<Recipe> getAll(String name, List<String> ingredients, List<String> tools) {
    return null;
  }

  @Override
  public Optional<Recipe> findById(String id) {
    log.info("[RecipeRepositoryImpl] Find recipe by id: {}", id);
    return crud.findById(id).map(mapper::toModel);
  }

  @Override
  public void deleteById(String id) {
    log.info("[RecipeRepositoryImpl] Delete recipe by id: {}", id);
    crud.deleteById(id);
  }

  @Override
  public Recipe update(Recipe updateRecipe) {
    log.info("[RecipeRepositoryImpl] Update recipe: {}", updateRecipe);
    var result = crud.save(mapper.toDocument(updateRecipe));
    return mapper.toModel(result);
  }
}

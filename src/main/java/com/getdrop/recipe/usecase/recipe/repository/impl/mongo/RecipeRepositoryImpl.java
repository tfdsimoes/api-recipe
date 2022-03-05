package com.getdrop.recipe.usecase.recipe.repository.impl.mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.getdrop.recipe.common.repository.RepositoryTools;
import com.getdrop.recipe.usecase.recipe.model.Recipe;
import com.getdrop.recipe.usecase.recipe.repository.RecipeRepository;
import com.getdrop.recipe.usecase.recipe.repository.impl.mongo.crud.RecipeCrud;
import com.getdrop.recipe.usecase.recipe.repository.impl.mongo.document.RecipeDocument;
import com.getdrop.recipe.usecase.recipe.repository.impl.mongo.mapper.RecipeDocumentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
  public List<Recipe> getAll(String name, List<String> ingredients, List<String> tools, int limit, int offset) {
    log.info("[RecipeRepositoryImpl] Find all recipes: name {}, ingredients {}, tools {}, limit {}, offset {}",
        name, ingredients, tools, limit, offset);

    var pageRequest = RepositoryTools.generatePageRequest(limit, offset);

    if (StringUtils.isEmpty(name)) {
      name = "";
    }
    List<RecipeDocument> recipeDocuments;

    if (Objects.nonNull(tools)) {
      if (Objects.nonNull(ingredients)) {
        recipeDocuments = crud.findAllByNameContainingAndToolsInAndIngredientsNameIn(name, tools, ingredients, pageRequest);
      } else {
        recipeDocuments = crud.findAllByNameContainingAndToolsIn(name, tools, pageRequest);
      }
    } else if(Objects.nonNull(ingredients)) {
      recipeDocuments = crud.findAllByNameContainingAndIngredientsNameIn(name, ingredients, pageRequest);
    } else {
      recipeDocuments = crud.findAllByNameContaining(name, pageRequest);
    }

    return mapper.toModels(recipeDocuments);
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

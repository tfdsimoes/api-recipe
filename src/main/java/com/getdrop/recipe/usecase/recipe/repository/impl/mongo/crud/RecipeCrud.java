package com.getdrop.recipe.usecase.recipe.repository.impl.mongo.crud;

import java.util.List;

import com.getdrop.recipe.usecase.recipe.repository.impl.mongo.document.RecipeDocument;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeCrud extends MongoRepository<RecipeDocument, String> {

  List<RecipeDocument> findAllByNameContaining(String name, PageRequest pageRequest);

  List<RecipeDocument> findAllByNameContainingAndToolsIn(String name, List<String> tools, PageRequest pageRequest);

  List<RecipeDocument> findAllByNameContainingAndIngredientsNameIn(String name, List<String> ingredients, PageRequest pageRequest);

  List<RecipeDocument> findAllByNameContainingAndToolsInAndIngredientsNameIn(String name, List<String> tools,
      List<String> ingredients, PageRequest pageRequest);
}

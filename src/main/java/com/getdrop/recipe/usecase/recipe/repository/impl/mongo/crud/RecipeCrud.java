package com.getdrop.recipe.usecase.recipe.repository.impl.mongo.crud;

import com.getdrop.recipe.usecase.recipe.repository.impl.mongo.document.RecipeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeCrud extends MongoRepository<RecipeDocument, String> {

}

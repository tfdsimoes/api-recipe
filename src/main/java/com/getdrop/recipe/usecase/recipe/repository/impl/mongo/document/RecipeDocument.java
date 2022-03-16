package com.getdrop.recipe.usecase.recipe.repository.impl.mongo.document;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "recipe")
public class RecipeDocument {

  @Id
  String id;

  String name;

  String description;

  @Singular
  List<IngredientDocument> ingredients;

  @Singular
  List<StepDocument> steps;

  @Singular
  List<String> tools;
}

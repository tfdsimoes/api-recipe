package com.getdrop.recipe.usecase.recipe.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Recipe {

  String id;

  String name;

  String description;

  List<Ingredient> ingredients;

  List<Step> steps;

  List<String> tools;

  public static class RecipeBuilder {
    List<Ingredient> ingredients = new ArrayList<>();

    List<Step> steps = new ArrayList<>();

    List<String> tools = new ArrayList<>();

    public RecipeBuilder ingredient(Ingredient ingredient) {
      ingredients.add(ingredient);
      return this;
    }

    public RecipeBuilder ingredients(List<Ingredient> ingredients) {
      this.ingredients.addAll(ingredients);
      return this;
    }

    public RecipeBuilder clearIngredients() {
      ingredients.clear();
      return this;
    }

    public RecipeBuilder step(Step step) {
      steps.add(step);
      return this;
    }

    public RecipeBuilder steps(List<Step> steps) {
      this.steps.addAll(steps);
      return this;
    }

    public RecipeBuilder clearSteps() {
      steps.clear();
      return this;
    }

    public RecipeBuilder tool(String tool) {
      tools.add(tool);
      return this;
    }

    public RecipeBuilder tools(List<String> tools) {
      this.tools.addAll(tools);
      return this;
    }

    public RecipeBuilder clearTools() {
      tools.clear();
      return this;
    }
  }
}

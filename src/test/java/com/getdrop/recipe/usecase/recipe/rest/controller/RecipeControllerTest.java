package com.getdrop.recipe.usecase.recipe.rest.controller;

import static com.getdrop.recipe.usecase.recipe.fixtures.RecipeFixtures.RECIPE_WITH_ID;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.getdrop.recipe.common.exception.ElementNotFoundException;
import com.getdrop.recipe.usecase.recipe.common.mapper.RecipeMapper;
import com.getdrop.recipe.usecase.recipe.service.RecipeService;
import com.getdrop.recipe.usecase.testutil.FileHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {

  private static final String POST_RECIPE_AS_JSON =
      FileHelper.getContent("/json/recipe/post_request_recipe.json");

  private static final String ANSWER_RECIPE_AS_JSON =
      FileHelper.getContent("/json/recipe/answer_recipe.json");

  @Mock
  private RecipeService recipeService;

  @Autowired
  private RecipeMapper recipeMapper;

  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    RecipeController recipeController = new RecipeController(recipeMapper, recipeService);
    mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
  }

  @Test
  @DisplayName("POST /v1/recipe 200")
  void createRecipe() throws Exception {
    when(recipeService.create(any())).thenReturn(RECIPE_WITH_ID);

    mockMvc.perform(
            post("/v1/recipe")
                .contentType(MediaType.APPLICATION_JSON)
                .content(POST_RECIPE_AS_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(ANSWER_RECIPE_AS_JSON));
  }

  @Test
  @DisplayName("GET /v1/recipe/{id} 200")
  void getRecipe() throws Exception {
    when(recipeService.findById("id")).thenReturn(RECIPE_WITH_ID);

    mockMvc.perform(
            get("/v1/recipe/id"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(ANSWER_RECIPE_AS_JSON));
  }

  @Test
  @DisplayName("GET /v1/recipe/{id} 404")
  void getRecipeNotFound() throws Exception {
    when(recipeService.findById("id")).thenThrow(new ElementNotFoundException("action", "reference"));

    mockMvc.perform(
            get("/v1/recipe/id"))
        .andDo(print())
        .andExpect(status().isNotFound());
  }

  @Test
  @DisplayName("DELETE /v1/recipe/{id} 200")
  void deleteRecipe() throws Exception {
    doNothing().when(recipeService).deleteById("id");

    mockMvc.perform(
            delete("/v1/recipe/id"))
        .andDo(print())
        .andExpect(status().isOk());
  }
}

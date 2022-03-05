package com.getdrop.recipe.common.exception;

public class ElementNotFoundException extends RuntimeException{
  private static final String ERROR_MESSAGE = "%s: had not been found %s";

  public ElementNotFoundException(String action, String referenceCod) {
    super(String.format(ERROR_MESSAGE, action, referenceCod));
  }
}

package com.getdrop.recipe.usecase.testutil;

import java.nio.charset.StandardCharsets;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

@Slf4j
public final class FileHelper {

  public static String getContent(String fileName) {
    String result = null;
    try {
      result = IOUtils.toString(FileHelper.class.getResourceAsStream(fileName), StandardCharsets.UTF_8);
    } catch (Exception ex) {
      log.error("Impossible to read file {}", fileName, ex);
    }
    return result;
  }
}

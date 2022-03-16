package com.getdrop.recipe.common.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public final class RepositoryTools {

  private RepositoryTools() {
  }

  public static PageRequest generatePageRequest(int offset, int limit, String sortField) {
    PageRequest pageable;
    if (limit > 0) {
      int page = offset < limit ? 0 : offset / limit;
      pageable = PageRequest.of(page, limit, Sort.by(sortField));
    } else {
      pageable = PageRequest.of(0, 10000, Sort.by(sortField));
    }
    return pageable;
  }

  public static PageRequest generatePageRequest(int offset, int limit) {
    PageRequest pageable;
    if (limit > 0) {
      int page = offset < limit ? 0 : offset / limit;
      pageable = PageRequest.of(page, limit);
    } else {
      pageable = PageRequest.of(0, 10000);
    }
    return pageable;
  }
}

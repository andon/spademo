package com.netcetera.aem.spademo.impl.domain;

public class SortingInfo {

  private Sort sort;
  private SortDirection sortDirection;
  
  public SortingInfo(Sort sort, SortDirection sortDirection) {
    this.sort = sort;
    this.sortDirection = sortDirection;
  }

  public Sort getSort() {
    return sort;
  }

  public SortDirection getSortDirection() {
    return sortDirection;
  }
}

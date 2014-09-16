package com.netcetera.aem.spademo.impl.domain;

/**
 * Domain class that contain all the sorting information.
 * 
 * @author bojana.popovska
 */
public class SortingInfo {

  private Sort sort;
  private SortDirection sortDirection;

  /**
   * Constructs this sorting info object.
   * 
   * @param sort the sort type.
   * @param sortDirection the sort direction.
   */
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

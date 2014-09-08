package com.netcetera.aem.spademo.impl.domain;


public class PagingInfo {
  
  private int[] numbres;
  private int currentPageNumber;
  private boolean hasNext;
  private boolean hasPrev;
  
  public PagingInfo(int[] numbres, int currentPageNumber, boolean hasNext, boolean hasPrev) {
    this.numbres = numbres;
    this.currentPageNumber = currentPageNumber;
    this.hasNext = hasNext;
    this.hasPrev = hasPrev;
  }

  public int[] getNumbres() {
    return numbres;
  }
  
  public boolean hasNext() {
    return hasNext;
  }
  
  public boolean hasPrev() {
    return hasPrev;
  }
  
  
  public int getCurrentPageNumber() {
    return currentPageNumber;
  }

}

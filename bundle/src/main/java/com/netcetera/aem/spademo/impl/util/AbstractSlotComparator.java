package com.netcetera.aem.spademo.impl.util;

import java.util.Comparator;

import com.netcetera.aem.spademo.impl.domain.Slot;
import com.netcetera.aem.spademo.impl.domain.SortDirection;


abstract public class AbstractSlotComparator implements Comparator<Slot>{

  private SortDirection sortDirection;

  public AbstractSlotComparator(SortDirection sortDirection) {
    this.sortDirection = sortDirection;
  }
  
  public SortDirection getSortDirection() {
    return sortDirection;
  }
  
  abstract public int compare(Slot first, Slot second);
  
}

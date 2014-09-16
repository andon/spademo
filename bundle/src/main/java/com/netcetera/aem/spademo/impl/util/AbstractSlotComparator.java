package com.netcetera.aem.spademo.impl.util;

import java.util.Comparator;

import com.netcetera.aem.spademo.impl.domain.Slot;
import com.netcetera.aem.spademo.impl.domain.SortDirection;

/**
 * Abstract slot comparator.
 * 
 * @author bojana.popovska
 */
public abstract class AbstractSlotComparator implements Comparator<Slot> {

  private SortDirection sortDirection;

  /**
   * Constructor.
   * 
   * @param sortDirection {@link SortDirection}.
   */
  public AbstractSlotComparator(SortDirection sortDirection) {
    this.sortDirection = sortDirection;
  }

  public SortDirection getSortDirection() {
    return sortDirection;
  }

  /**
   * Compare two {@link Slot}s.
   * 
   * @param first {@link Slot}.
   * @param second {@link Slot}.
   * @return comparison result.
   */
  public abstract int compare(Slot first, Slot second);

}

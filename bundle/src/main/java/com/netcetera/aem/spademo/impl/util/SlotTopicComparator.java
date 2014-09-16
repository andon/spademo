package com.netcetera.aem.spademo.impl.util;

import com.netcetera.aem.spademo.impl.domain.Slot;
import com.netcetera.aem.spademo.impl.domain.SortDirection;

/**
 * Slot comparator by the slot topic field.
 * 
 * @author bojana.popovska
 */
public class SlotTopicComparator extends AbstractSlotComparator {

  /**
   * Constructor.
   * 
   * @param sortDirection {@link SortDirection}.
   */
  public SlotTopicComparator(SortDirection sortDirection) {
    super(sortDirection);
  }


  /**
   * Compare by the speakers field.
   * 
   * @param first {@link Slot}.
   * @param second {@link Slot}.
   * @return comparison result.
   */
  public int compare(Slot first, Slot second) {
    switch (getSortDirection()) {
      case ASC:
        return first.getTopic().compareTo(second.getTopic());
      case DESC:
        return second.getTopic().compareTo(first.getTopic());
      default:
        throw new IllegalStateException("Unknown sorting direction");
    }
  }

}

package com.netcetera.aem.spademo.impl.util;

import com.netcetera.aem.spademo.impl.domain.Slot;
import com.netcetera.aem.spademo.impl.domain.SortDirection;

public class SlotStartTimeComparator extends AbstractSlotComparator {

	public SlotStartTimeComparator(SortDirection sortDirection) {
    super(sortDirection);
  }

  public int compare(Slot first, Slot second) {
    switch (getSortDirection()) {
      case ASC:
        return first.getStartTime().compareTo(second.getStartTime());
      case DESC:
        return second.getStartTime().compareTo(first.getStartTime());
      default:
        throw new IllegalStateException("Unknown sorting direction");
    }
	}

}

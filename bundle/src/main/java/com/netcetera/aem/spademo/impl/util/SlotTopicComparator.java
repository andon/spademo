package com.netcetera.aem.spademo.impl.util;

import com.netcetera.aem.spademo.impl.domain.Slot;
import com.netcetera.aem.spademo.impl.domain.SortDirection;

public class SlotTopicComparator extends AbstractSlotComparator {

	public SlotTopicComparator(SortDirection sortDirection) {
    super(sortDirection);
  }

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

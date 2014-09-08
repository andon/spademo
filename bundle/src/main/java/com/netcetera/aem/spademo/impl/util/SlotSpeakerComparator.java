package com.netcetera.aem.spademo.impl.util;

import com.netcetera.aem.spademo.impl.domain.Slot;
import com.netcetera.aem.spademo.impl.domain.SortDirection;

public class SlotSpeakerComparator extends AbstractSlotComparator {

	public SlotSpeakerComparator(SortDirection sortDirection) {
    super(sortDirection);
  }

  public int compare(Slot first, Slot second) {
    switch (getSortDirection()) {
      case ASC:
        return first.getSpeaker().compareTo(second.getSpeaker());
      case DESC:
        return second.getSpeaker().compareTo(first.getSpeaker());
      default:
        throw new IllegalStateException("Unknown sorting direction");
    }
	}

}

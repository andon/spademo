package com.netcetera.aem.spademo.impl.util;

import java.util.Comparator;

import com.netcetera.aem.spademo.impl.domain.Slot;

public class SlotSpeakerComparator implements Comparator<Slot> {

	public int compare(Slot first, Slot second) {
		return first.getSpeaker().compareTo(second.getSpeaker());
	}

}

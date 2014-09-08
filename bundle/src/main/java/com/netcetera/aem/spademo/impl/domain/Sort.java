package com.netcetera.aem.spademo.impl.domain;

import java.util.Comparator;

import com.netcetera.aem.spademo.impl.util.SlotSpeakerComparator;
import com.netcetera.aem.spademo.impl.util.SlotStartTimeComparator;
import com.netcetera.aem.spademo.impl.util.SlotTopicComparator;

public enum Sort {
	START_TIME,
	TOPIC,
	SPEAKER;
	
	public Comparator<Slot> getComparator(SortDirection direction) {
		switch (this) {
		case START_TIME:
			return new SlotStartTimeComparator(direction);
		case TOPIC:
			return new SlotTopicComparator(direction);
		case SPEAKER:
			return new SlotSpeakerComparator(direction);
		default:
			throw new IllegalStateException("No comparator for " + this);
		}
	}
}

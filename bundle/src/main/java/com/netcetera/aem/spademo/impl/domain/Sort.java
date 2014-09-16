package com.netcetera.aem.spademo.impl.domain;

import java.util.Comparator;

import com.netcetera.aem.spademo.impl.util.SlotSpeakersComparator;
import com.netcetera.aem.spademo.impl.util.SlotStartTimeComparator;
import com.netcetera.aem.spademo.impl.util.SlotTopicComparator;

/**
 * Sort possibilities.
 * 
 * @author bojana.popovska
 */
public enum Sort {
  /**
   * Sort by presentation start time.
   */
  START_TIME,

  /**
   * Sort by presentation topic.
   */
  TOPIC,

  /**
   * Sort by presentation speakers.
   */
  SPEAKERS;

  /**
   * Get proper comparator for this sort for a given direction.
   * 
   * @param direction {@link SortDirection}.
   * @return {@link Comparator} for {@link Slot} for the given
   *         {@link SortDirection}.
   */
  public Comparator<Slot> getComparator(SortDirection direction) {
    switch (this) {
      case START_TIME:
        return new SlotStartTimeComparator(direction);
      case TOPIC:
        return new SlotTopicComparator(direction);
      case SPEAKERS:
        return new SlotSpeakersComparator(direction);
      default:
        throw new IllegalStateException("No comparator for " + this);
    }
  }
}

package com.netcetera.aem.spademo.impl.domain;

import org.joda.time.LocalTime;

/**
 * Domain class representing a single slot in a conference day.
 * 
 * @author andon.sikavica
 */
public class Slot {

  private final LocalTime startTime;
  private final LocalTime endTime;
  private final String topic;
  private final String speakers;

  /**
   * Constructor for a presentation slot.
   * 
   * @param startTime when the presentation starts.
   * @param endTime when the presentation ends.
   * @param topic the topic of the presentation.
   * @param speakers the presenters.
   */
  public Slot(LocalTime startTime, LocalTime endTime, String topic, String speakers) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.topic = topic;
    this.speakers = speakers;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public LocalTime getEndTime() {
    return endTime;
  }

  public String getTopic() {
    return topic;
  }

  public String getSpeakers() {
    return speakers;
  }

}

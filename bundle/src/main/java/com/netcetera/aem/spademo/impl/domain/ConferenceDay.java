package com.netcetera.aem.spademo.impl.domain;

import java.util.Collections;
import java.util.List;

import org.joda.time.LocalDate;

/**
 * Domain class representing a conference day.
 * 
 * @author andon.sikavica
 */
public class ConferenceDay {

  private LocalDate date;
  private List<Slot> slots;
  private SortingInfo sortingInfo;
  private PagingInfo pagingInfo;

  /**
   * Constructor.
   * 
   * @param date of the conference day.
   * @param slots {@link List} of {@link Slot} for presentation.
   * @param sortingInfo {@link SortingInfo}.
   * @param pagingInfo {@link PagingInfo}.
   */
  public ConferenceDay(LocalDate date, List<Slot> slots, SortingInfo sortingInfo, PagingInfo pagingInfo) {
    this.date = date;
    this.slots = slots;
    this.sortingInfo = sortingInfo;
    this.pagingInfo = pagingInfo;
  }

  public LocalDate getDate() {
    return date;
  }

  public List<Slot> getSlots() {
    return Collections.unmodifiableList(slots);
  }

  public PagingInfo getPagingInfo() {
    return pagingInfo;
  }

  public SortingInfo getSortingInfo() {
    return sortingInfo;
  }

}

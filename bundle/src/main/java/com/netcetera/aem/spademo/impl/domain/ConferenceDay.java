package com.netcetera.aem.spademo.impl.domain;

import java.util.Collections;
import java.util.List;

import org.joda.time.LocalDate;

public class ConferenceDay {

	private LocalDate date;
	private List<Slot> slots;
	private SortingInfo sortingInfo;
	private PagingInfo pagingInfo;
	
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

package com.netcetera.aem.spademo.impl.controllers;

import static com.netcetera.aem.spademo.impl.domain.Sort.START_TIME;
import static com.netcetera.aem.spademo.impl.domain.SortDirection.ASC;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.netcetera.aem.spademo.impl.domain.ConferenceDay;
import com.netcetera.aem.spademo.impl.domain.PagingInfo;
import com.netcetera.aem.spademo.impl.domain.Slot;
import com.netcetera.aem.spademo.impl.domain.Sort;
import com.netcetera.aem.spademo.impl.domain.SortDirection;
import com.netcetera.aem.spademo.impl.domain.SortingInfo;
import com.netcetera.aem.spademo.impl.serializers.ConferenceDayGsonSerializer;
import com.netcetera.aem.spademo.impl.serializers.PagingInfoGsonSerializer;
import com.netcetera.aem.spademo.impl.serializers.SlotSerializer;
import com.netcetera.aem.spademo.impl.serializers.SortingInfoSerializer;
import com.netcetera.aem.spademo.impl.services.ScheduleService;

/**
 * Controller for the schedule table component.
 * 
 * @author bojana.popovska
 */
@Controller
public class ScheduleTableController {

  @Resource
  private ScheduleService scheduleService;

  /**
   * Gets the dynamic data needed for a single conference day needed for
   * rendering the schedule table.
   * 
   * @param pageNumber the day of the conference.
   * @return The resulting JSON.
   */
  @RequestMapping(value = "/scheduletable/getresult", produces = {"application/json; charset=UTF-8" }, method = POST)
  @ResponseBody
  public String getTableResult(@RequestParam int pageNumber) {
    ConferenceDay conferenceDay = scheduleService.getConferenceDayFor(pageNumber, new SortingInfo(START_TIME, ASC));
    return serializeData(conferenceDay);
  }

  /**
   * Gets the dynamic data needed for a single conference day, in specific sort
   * type and direction. The data is needed to render the schedule table.
   * 
   * @param sort {@link Sort}.
   * @param sortDirection {@link SortDirection}.
   * @return The resulting JSON
   */
  @RequestMapping(value = "/scheduletable/sortresult", produces = {"application/json; charset=UTF-8" }, method = POST)
  @ResponseBody
  public String sortResults(@RequestParam Sort sort, @RequestParam SortDirection sortDirection) {
    ConferenceDay conferenceDay = scheduleService.getConferenceDayFor(1, new SortingInfo(sort, sortDirection));
    return serializeData(conferenceDay);
  }

  private String serializeData(ConferenceDay conferenceDay) {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(ConferenceDay.class, new ConferenceDayGsonSerializer());
    gsonBuilder.registerTypeAdapter(Slot.class, new SlotSerializer());
    gsonBuilder.registerTypeAdapter(SortingInfo.class, new SortingInfoSerializer());
    gsonBuilder.registerTypeAdapter(PagingInfo.class, new PagingInfoGsonSerializer());
    Gson gson = gsonBuilder.create();
    return gson.toJson(conferenceDay);
  }
}

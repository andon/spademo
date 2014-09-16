package com.netcetera.aem.spademo.impl.controllers;

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

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Controller for the schedule table component.
 * 
 * @author bojana.popovska
 */
@Controller
public class ScheduleTableController {


  @Resource
  private ScheduleService scheduleService;

  @RequestMapping(value = "/scheduletable/getresult", produces = "application/json", method = POST)
  @ResponseBody
  public String getTableResult(@RequestParam int pageNumber) {
    ConferenceDay conferenceDay = scheduleService.getConferenceDayFor(pageNumber, new SortingInfo(Sort.START_TIME, SortDirection.ASC));

    return serializeData(conferenceDay);
  }

  @RequestMapping(value = "/scheduletable/sortresult", produces = "application/json", method = POST)
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

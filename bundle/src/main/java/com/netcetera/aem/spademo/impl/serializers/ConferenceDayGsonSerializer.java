package com.netcetera.aem.spademo.impl.serializers;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.netcetera.aem.spademo.impl.domain.ConferenceDay;
import com.netcetera.aem.spademo.impl.domain.Slot;


public class ConferenceDayGsonSerializer implements JsonSerializer<ConferenceDay>{

  @Override
  public JsonElement serialize(ConferenceDay conferenceDay, Type typeOfSrc, JsonSerializationContext context) {
    JsonObject conferenceDayJson = new JsonObject();
    JsonArray entries = new JsonArray();
    for (Slot slot : conferenceDay.getSlots()) {
      entries.add(context.serialize(slot));
    }
    
    conferenceDayJson.add("talks", entries);
    conferenceDayJson.add("sortingInfo", context.serialize(conferenceDay.getSortingInfo()));
    conferenceDayJson.add("pagingInfo", context.serialize(conferenceDay.getPagingInfo()));
    
    return conferenceDayJson;
  }

}

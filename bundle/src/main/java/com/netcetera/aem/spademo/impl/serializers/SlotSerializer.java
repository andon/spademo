package com.netcetera.aem.spademo.impl.serializers;

import java.lang.reflect.Type;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.netcetera.aem.spademo.impl.domain.Slot;

/**
 * {@link JsonSerializer} for a {@link Slot}.
 * 
 * @author bojana.popovska
 */
public class SlotSerializer implements JsonSerializer<Slot> {

  @Override
  public JsonElement serialize(Slot slot, Type typeOfSrc, JsonSerializationContext context) {
    JsonObject slotJson = new JsonObject();

    slotJson.addProperty("time", formatTime(slot.getStartTime()) + " - " + formatTime(slot.getEndTime()));
    slotJson.addProperty("title", slot.getTopic());
    slotJson.addProperty("speakers", slot.getSpeakers());

    return slotJson;
  }

  private String formatTime(LocalTime time) {
    DateTimeFormatter formatter = DateTimeFormat.forPattern("hh:mm");
    return formatter.print(time);
  }

}

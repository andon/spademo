package com.netcetera.aem.spademo.impl.serializers;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.netcetera.aem.spademo.impl.domain.SortingInfo;

/**
 * {@link JsonSerializer} for a {@link SortingInfo}.
 * 
 * @author bojana.popovska
 */
public class SortingInfoSerializer implements JsonSerializer<SortingInfo> {

  @Override
  public JsonElement serialize(SortingInfo sortingInfo, Type typeOfSrc, JsonSerializationContext context) {

    JsonObject sortingJson = new JsonObject();
    sortingJson.addProperty("criteria", sortingInfo.getSort().toString());
    sortingJson.addProperty("order", sortingInfo.getSortDirection().toString());

    return sortingJson;
  }

}

package com.netcetera.aem.spademo.impl.controllers;

import io.neba.api.annotations.ResourceParam;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.netcetera.aem.spademo.impl.model.PageModel;
import com.netcetera.aem.spademo.impl.services.RequestService;

/**
 * Sample controller for testing. TODO ASI: delete.
 * 
 * @author andon.sikavica
 */
@Controller
public class MyController {

  @Resource
  private RequestService requestService;

  /**
   * Gets the number of child pages.
   * 
   * @param page {@link PageModel}.
   * @return JSON of the result.
   */
  @RequestMapping(value = "/page/childcount", produces = "text/plain")
  @ResponseBody
  public String getNumberOfChildren(@ResourceParam PageModel page) {
    return String.valueOf(page.getChildren().size() + new Gson().toJson(new JsonObject()));
  }
}

package com.netcetera.aem.spademo.impl.model;

import io.neba.api.annotations.Path;
import io.neba.api.annotations.ResourceModel;

@ResourceModel(types = "spademo/components/scheduletable")
public class ScheduleTableModel {
	
	@Path("jcr:title")
	private String title;
	private String headerTime;
	private String headerTalk;
	private String headerSpeakers;
	
	public String getTitle() {
		return title;
	}
	public String getHeaderTime() {
		return headerTime;
	}
	public String getHeaderTalk() {
		return headerTalk;
	}
	public String getHeaderSpeakers() {
		return headerSpeakers;
	}

}

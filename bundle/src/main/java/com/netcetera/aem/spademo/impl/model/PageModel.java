package com.netcetera.aem.spademo.impl.model;

import java.util.List;

import com.day.cq.wcm.api.Page;

import io.neba.api.annotations.Children;
import io.neba.api.annotations.ResourceModel;

@ResourceModel(types = "cq:Page")
public class PageModel {

	@Children
	private List<Page> children;
	
	public List<Page> getChildren() {
		return this.children;
	}
}

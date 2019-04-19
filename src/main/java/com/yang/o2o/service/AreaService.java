package com.yang.o2o.service;

import java.util.List;

import com.yang.o2o.entity.Area;

public interface AreaService {
	public final static String AREA_LIST_KEY = "arealist";
	
	List<Area> getAreaList();

	
}

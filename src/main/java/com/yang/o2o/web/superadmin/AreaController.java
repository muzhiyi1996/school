package com.yang.o2o.web.superadmin;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.o2o.entity.Area;
import com.yang.o2o.service.AreaService;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
	Logger Logger = LoggerFactory.getLogger(AreaController.class);
	@Autowired
	private AreaService areaService;
	@RequestMapping(value = "/listarea",method = RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> listArea(){
		Logger.info("===start===");
		long startTime = System.currentTimeMillis();
		Map<String, Object> modelMap = new HashMap<String,Object>();
		List<Area> list = new ArrayList<Area>();
		try {
			list = areaService.getAreaList();
			modelMap.put("rows", list);
			modelMap.put("total", list.size());
		}catch(Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString()); 
		}
		Logger.error("test error!");
		long endTime = System.currentTimeMillis();
		Logger.debug("costTime:[{}ms]",endTime - startTime);
		Logger.info("===end===");
		return modelMap;
	}
}

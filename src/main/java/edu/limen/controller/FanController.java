package edu.limen.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.limen.model.json.JsonRequestObj;
import edu.limen.model.json.UserFanListItem;
import edu.limen.model.json.UserFanListResponse;
import edu.limen.model.pojo.UserDetail;
import edu.limen.service.IFanService;

@Controller
public class FanController {

	@Autowired
	IFanService fanService;
	
	@RequestMapping(value="/userlistdetail", method = RequestMethod.GET)
	@ResponseBody
	public List<UserDetail> listUserDetail()
	{
		return fanService.listUserDetail();
	}
	
	@RequestMapping(value="/userlistf", method = RequestMethod.GET)
	@ResponseBody
	public List<UserFanListItem> listUserFan()
	{
		return fanService.listUserFan("11");
	}
	
	@RequestMapping(value="/userlistc", method = RequestMethod.GET)
	@ResponseBody
	public UserFanListItem listUserFanc()
	{
		UserFanListItem fan = new UserFanListItem();
		fan.setFanRealName("hello");
		fan.setFanUserId(123);
		return fan;
	}
	
	@RequestMapping(value="/userlistd", method = RequestMethod.GET)
	@ResponseBody
	public UserFanListResponse listUserFand()
	{
		List<UserFanListItem> fans = new ArrayList<>();
		UserFanListItem fan = new UserFanListItem();
		fan.setFanRealName("hello");
		fan.setFanUserId(123);
		fans.add(fan);
		fan.setFanRealName("world");
		fan.setFanUserId(456);
		fans.add(fan);

        UserFanListResponse response = new UserFanListResponse();
        response.setUserFanList(fans);
		return response;
	}
	
	@RequestMapping(value="/userlistt", method = RequestMethod.GET)

	public @ResponseBody Map<String, Object> listUserFanb()
	{
		Map<String, Object> json = new HashMap<String, Object>();
        json.put("message", "Hello World!");
        return json;
	}
	
	@RequestMapping(value="/fan/list", method = RequestMethod.POST)
	public @ResponseBody UserFanListResponse listUserFan(@RequestBody JsonRequestObj requestObj)
	{
		List<UserFanListItem> userFanList = fanService.listUserFan(requestObj.getId());
		System.out.println(userFanList.toString());
        UserFanListResponse response = new UserFanListResponse();
        response.setUserFanList(userFanList);
        return response;
        
	}
}

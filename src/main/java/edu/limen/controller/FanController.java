package edu.limen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.limen.model.json.JsonRequestObj;
import edu.limen.model.json.JsonResponseObj;
import edu.limen.model.json.UserFanDetailItem;
import edu.limen.model.json.UserFanListItem;
import edu.limen.model.json.UserFanListResponse;
import edu.limen.service.IFanService;

@Controller
@RequestMapping("/fan")
public class FanController {

	@Autowired
	IFanService fanService;

	@RequestMapping(value="/list", method = RequestMethod.POST)
	public @ResponseBody UserFanListResponse listUserFan(@RequestParam(value = "json", required = true) String json) {
		Gson gson = new Gson();
		JsonRequestObj requestObj = gson.fromJson(json, JsonRequestObj.class);
		
		Integer userId = -1;
		
		userId = requestObj.getUserId();
		
		List<UserFanListItem> userFanList = fanService.listUserFan(userId);
        UserFanListResponse response = new UserFanListResponse();
        response.setUserFanList(userFanList);
                
        return response;
        
	}
	
	@RequestMapping(value="/view", method = RequestMethod.POST)
	public @ResponseBody UserFanDetailItem viewUserDetail(@RequestParam(value = "json", required = true) String json) {
		Gson gson = new Gson();
		JsonRequestObj requestObj = gson.fromJson(json, JsonRequestObj.class);
		
		Integer userId = -1;

		userId = requestObj.getUserId();

		UserFanDetailItem userFanDetailItem = fanService.viewUserDetail(userId);

        return userFanDetailItem;
	}

	@RequestMapping(value="/add", method = RequestMethod.POST)
	public @ResponseBody JsonResponseObj addFriend(@RequestParam(value = "json", required = true) String json) {
		Gson gson = new Gson();
		JsonRequestObj requestObj = gson.fromJson(json, JsonRequestObj.class);
		
		JsonResponseObj jsonResponse = new JsonResponseObj();
		if ((requestObj.getUserId() == null) || (requestObj.getUserIdList().isEmpty())) {
			System.out.println("data is not valud in add frields");
		} else {
			fanService.addFans(requestObj.getUserId(), requestObj.getUserIdList());
			jsonResponse.setResponseStatus("success");
		}
		
		return jsonResponse;
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public @ResponseBody JsonResponseObj unfriend(@RequestParam(value = "json", required = true) String json) {
		Gson gson = new Gson();
		JsonRequestObj requestObj = gson.fromJson(json, JsonRequestObj.class);
		
		JsonResponseObj jsonResponse = new JsonResponseObj();
		if ((requestObj.getUserId() == null) || (requestObj.getUserIdList().isEmpty())) {
			System.out.println("data is not valud in delete frields");
		} else {
			fanService.removeFans(requestObj.getUserId(), requestObj.getUserIdList());
			jsonResponse.setResponseStatus("success");
		}
		
		return jsonResponse;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public @ResponseBody JsonResponseObj updateStatus(@RequestParam(value = "json", required = true) String json) {
		Gson gson = new Gson();
		JsonRequestObj requestObj = gson.fromJson(json, JsonRequestObj.class);
		
		JsonResponseObj jsonResponse = new JsonResponseObj();
		if ((requestObj.getUserId() == null) || (requestObj.getUserIdList().isEmpty()) || requestObj.getStatus() == null) {
			System.out.println("data is not valud in update frields");
		} else {
			fanService.updateFansStatus(
					requestObj.getUserId(),
					requestObj.getUserIdList(),
					requestObj.getStatus());
			jsonResponse.setResponseStatus("success");
		}
		
		return jsonResponse;
	}
	
}

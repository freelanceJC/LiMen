package edu.limen.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.limen.model.json.JsonRequestObj;
import edu.limen.model.json.UserFanListItem;
import edu.limen.model.json.UserFanListResponse;
import edu.limen.model.pojo.User;
import edu.limen.model.pojo.UserDetail;
import edu.limen.service.IFanService;
import edu.limen.service.IGroupService;
import edu.limen.service.IUserService;


@Controller
public class UserController {

	@Autowired
	IUserService userService;
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	@ResponseBody
	public List<User> search(@RequestBody JsonRequestObj requestObj)
	{
		String searchType = requestObj.getType();
		String searchInput = requestObj.getInput();
		Integer userId = requestObj.getUserId();
		if (searchInput == null || searchType == null){
			return new ArrayList<User>();
		}
		switch (searchType) {
			case "username":
				return userService.searchUserByUserName(searchInput);
			case "group":
				if (userId == null) {
					return new ArrayList<User>();
				} else {
					return userService.searchUserByGroupName(searchInput, userId);
				}
				
			case "email":
				return userService.searchUserByEmail(searchInput);
		}
		return new ArrayList<User>();
	}
}

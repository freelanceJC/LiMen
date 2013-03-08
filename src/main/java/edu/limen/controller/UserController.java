package edu.limen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.limen.model.json.JsonRequestObj;
import edu.limen.model.pojo.User;
import edu.limen.service.IUserService;


@Controller
public class UserController {

	@Autowired
	IUserService userService;
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	@ResponseBody
	public List<User> search(@RequestParam(value = "json", required = true) String json) {
		Gson gson = new Gson();
		JsonRequestObj requestObj = gson.fromJson(json, JsonRequestObj.class);
	
		String searchType = requestObj.getType();
		String searchInput = requestObj.getKeyword();
		Integer userId = requestObj.getUserId();
		if (searchInput == null || searchType == null || "".equals(searchInput)){
			return new ArrayList<User>();
		}
		switch (searchType) {
			case "user":
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

package edu.limen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.limen.model.pojo.User;
import edu.limen.model.view.SchoolUserView;
import edu.limen.service.IGroupService;
import edu.limen.service.ISchoolUserService;
import edu.limen.service.IUserService;
import edu.limen.utility.constant.HttpRequestConstant;

@Controller
public class LimenController {

	@Autowired
	@Qualifier(value="groupService")
	IGroupService groupService;
	@Autowired
	@Qualifier(value="userService")
	IUserService userService;
	
	@RequestMapping(value="/main", method = RequestMethod.POST)
	public HttpEntity<String> response(@RequestParam(value="json", required=false) String json)
	{
		String res = null;
		HttpHeaders header = new HttpHeaders();
		String requestType = null;
		switch(requestType){
			case HttpRequestConstant.GET_SCHOOL_LIST: 
			case HttpRequestConstant.GET_GROUP_LIST:
			default:
		}
		return new HttpEntity<String>(res, header);
	}
}

package edu.limen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.limen.model.pojo.Group;
import edu.limen.service.IGroupService;

@Controller
public class GroupController {

	@Autowired
	IGroupService groupService;
	
	@RequestMapping(value="/group", method = RequestMethod.GET)
	@ResponseBody
	public List<Group> listGroup()
	{
		
		return groupService.listGroup();
	}
	
	
	@RequestMapping(value="/group/post", method = RequestMethod.POST)
	@ResponseBody
	public String showPost(@RequestParam(value="id", required=false) String post)
	{
		System.out.println(post);
		return post;
	}
	
	@RequestMapping(value="/group/search", method = RequestMethod.POST)
	@ResponseBody
	public List<Group> searchGroup(@RequestParam(value="json", required=false) String post)
	{
		System.out.println(post);
		return groupService.listGroup(post);
	}
}

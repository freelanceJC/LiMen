package edu.limen.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.limen.model.json.JsonRequestObj;
import edu.limen.model.json.MessageRequestObj;
import edu.limen.model.json.MessageResponseObj;
import edu.limen.model.json.UserFanListItem;
import edu.limen.model.json.UserFanListResponse;
import edu.limen.model.pojo.User;
import edu.limen.model.pojo.UserDetail;
import edu.limen.model.pojo.UserMessage;
import edu.limen.service.IFanService;
import edu.limen.service.IGroupService;
import edu.limen.service.IMessageService;
import edu.limen.service.IUserService;


@Controller
public class MessageController {

	@Autowired
	IUserService userService;

	@Autowired
	IMessageService messageService;

	
	@RequestMapping(value="/send", method = RequestMethod.POST)
	@ResponseBody
	public MessageResponseObj send(@RequestBody MessageRequestObj msgRequestObj)
	{
		MessageResponseObj response = new MessageResponseObj();
		Integer userId = msgRequestObj.getUserId();
		String content = msgRequestObj.getContent();
		String title = msgRequestObj.getTitle();
		String dateFormatString = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormatString);
		Timestamp startTime;
		Timestamp endTime;
		try {
			startTime = new Timestamp(sdf.parse(msgRequestObj.getStartTime()).getTime());
			endTime = new Timestamp(sdf.parse(msgRequestObj.getEndTime()).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setDescription("You don't own this group");
			response.setResultCode("999");
			return response;
		}
		
		Integer targetId = msgRequestObj.getTargetId();
		String targetType = msgRequestObj.getTargetType();
		UserMessage userMessage = null;
		
		switch (targetType) {
			case "group":
				List<User> uList = userService.getUserByGroupIdUserId(targetId, userId);
				if (uList == null || uList.size() == 0 ) {
					response.setDescription("You dont own this group");
					response.setResultCode("999");
					return response;
				}
				for (User user : uList) {
					userMessage = new UserMessage();
					userMessage.setContent(content);
					userMessage.setTitle(title);
					userMessage.setStartTime(startTime);
					userMessage.setEndTime(endTime);
					userMessage.setFromGroupingID(targetId);
					userMessage.setFromUserID(userId);
					userMessage.setToUserID(user.getId());
					userMessage.setStatus(new Integer(4).byteValue());
					messageService.addUserMessage(userMessage);
				}
				break;
			case "user":
				userMessage = new UserMessage();
				userMessage.setContent(content);
				userMessage.setTitle(title);
				userMessage.setStartTime(startTime);
				userMessage.setEndTime(endTime);
				userMessage.setFromUserID(userId);
				userMessage.setToUserID(targetId);
				userMessage.setStatus(new Integer(4).byteValue());
				messageService.addUserMessage(userMessage);
				break;
			default:
		}
		response.setDescription("Success");
		response.setResultCode("200");
		return response;
	}
}

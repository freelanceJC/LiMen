package edu.limen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.limen.model.json.MessageRequestObj;
import edu.limen.model.json.MessageResponseObj;
import edu.limen.model.pojo.UserMessage;
import edu.limen.service.IMessageService;
import edu.limen.service.IUserService;


@Controller
public class MessageController {

	@Autowired
	IUserService userService;

	@Autowired
	IMessageService messageService;

	
	@RequestMapping(value="/sendAddFriendMessage", method = RequestMethod.POST)
	@ResponseBody
	public MessageResponseObj send(@RequestParam(value = "json", required = true) String json) {
		Gson gson = new Gson();
		MessageRequestObj msgRequestObj = gson.fromJson(json, MessageRequestObj.class);

		MessageResponseObj response = new MessageResponseObj();
		Integer fromUserId = msgRequestObj.getFromUserId();
		Integer toUserId = msgRequestObj.getTargetId();
		String content = msgRequestObj.getContent();
	
		if (fromUserId == null || toUserId == null) {
			response.setDescription("INVALID_INPUT");
			response.setResultCode("10001");
			return response;
		}
		
		if (!messageService.canSendFriendMessage(fromUserId, toUserId)){
			response.setDescription("TARGET_NOT_IN_PENDING_FD_LIST");
			response.setResultCode("90001");
			return response;
		}
		
		UserMessage userMessage = new UserMessage();
		userMessage.setContent(content);
		userMessage.setFromUserID(fromUserId);
		userMessage.setToUserID(toUserId);
		userMessage.setStatus(new Integer(0).byteValue());
		messageService.addUserMessage(userMessage);

		response.setDescription("Success");
		response.setResultCode("200");
		return response;
	}
}

package edu.limen.service;

import java.util.List;

import edu.limen.model.json.UserFanListItem;
import edu.limen.model.pojo.UserDetail;

public interface IFanService {

	public List<UserDetail> listUserDetail();
	public List<UserFanListItem> listUserFan(String userId);

}

package edu.limen.service;

import java.util.List;

import edu.limen.model.json.UserFanDetailItem;
import edu.limen.model.json.UserFanListItem;

public interface IFanService {

	public List<UserFanListItem> listUserFan(Integer userId);
	public UserFanDetailItem viewUserDetail(Integer userId);
	public void addFans(Integer userId, List<String> fanUserIds);
	public void removeFans(Integer userId, List<String> fanUserIds);
	public void updateFansStatus(Integer userId, List<String> fanUserIds, int status);
	
}

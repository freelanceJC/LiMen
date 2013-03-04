package edu.limen.dao.impl;

import java.util.Iterator;

import edu.limen.dao.IGetGroupListDAO;
import edu.limen.model.view.UserGrouping;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

@Repository
public class GetGroupListDAOImpl implements IGetGroupListDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String getGroupList(String jsonstr) {
		// TODO Auto-generated method stub
		JSONStringer outputjson = new JSONStringer();
		try {
			JSONObject inputjson = new JSONObject(jsonstr);
			outputjson.array();
			Iterator iterator = sessionFactory.getCurrentSession().getNamedQuery("findGroupByUId").setParameter("user_id", inputjson.getInt("uid")).iterate();
			while(iterator.hasNext()){
				UserGrouping usergroup = (UserGrouping)iterator.next();
				outputjson.object();
				outputjson.key("groupid").value(usergroup.getGrouping_id());
				outputjson.key("groupname").value(usergroup.getGrouping_name());
				outputjson.key("groupdetail").value(usergroup.getGrouping_description());
				outputjson.endObject();
			}
			outputjson.endArray();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return "[]";
		}
		return outputjson.toString();
	}

}

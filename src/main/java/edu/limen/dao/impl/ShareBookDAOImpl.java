package edu.limen.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.limen.dao.IShareBookDAO;
//import edu.limen.pojo.User;

//=========Testing JSON=============
//{\"uid\":\"1\",\"books\":[\"22\",\"45\"],\"to\":[{\"groupid\":\"10\",\"is_all_group\":1,\"to_users\":[\"15\",\"16\"]},{\"groupid\":\"20\",\"is_all_group\":0,\"to_users\":[\"17\",\"18\"]}]}
//==================================

public class ShareBookDAOImpl implements IShareBookDAO {
	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	private Session session = sessionFactory.getCurrentSession();
	private Transaction transaction = session.beginTransaction();
	private int uid, book_id, group_id, to_user;
	private JSONObject mainjsonobj, tojsonobj;
	private JSONArray booksjsonarray, tojsonarray, to_usersjsonarray;
	
	@Override
	public void shareBookAdd(String jsonstr) {
		// TODO Auto-generated method stub
		try{
			mainjsonobj = new JSONObject(jsonstr);
			uid = Integer.parseInt(mainjsonobj.getString("uid"));
			booksjsonarray = mainjsonobj.getJSONArray("books");
			tojsonarray = mainjsonobj.getJSONArray("to");

			for(int i = 0; i < booksjsonarray.length(); i++){
				book_id = Integer.parseInt(booksjsonarray.getString(i));
				//session.create
				for(int j = 0; j < tojsonarray.length(); j++){
					tojsonobj = tojsonarray.getJSONObject(j);
					group_id = Integer.parseInt(tojsonobj.getString("groupid"));
					if(tojsonobj.getInt("is_all_group") == 1){
						System.out.println("From UID: " + uid + ", Book ID: " + book_id + ", Share to all group member");
						}
					else{
						String output = "From UID: " + uid + ", Book ID: " + book_id + ", Share to:";
						to_usersjsonarray = tojsonobj.getJSONArray("to_users");
						for(int k = 0; k < to_usersjsonarray.length(); k++){
							to_user = to_usersjsonarray.getInt(k);
							output += " " + to_user + ",";
							}
						output = output.substring(0, output.length() - 1);
						System.out.println(output);
						}
					}
				}
		}
		catch(JSONException e){}
		catch(HibernateException e){}
	}

}

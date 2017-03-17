package sri.userservice.dao;

import java.util.ArrayList;
import java.util.List;

import sri.userservice.vo.User;

public class UserDao
{
	private static List<User> _userList;
	
	static
	{
		_userList = new ArrayList<User>();
		User user;
		for (int i=0; i<10; i++)
		{
			user = new User();
			user.setId("" + (i+1));
			user.setName("name" + (i+1));
			user.setEmail("email" + (i+1));
			_userList.add(user);
		}
	}

	public List<User> getAllUsers()
	{
		return _userList;
	}
	
	public User getUserById(String id)
	{
		for (User user : _userList)
			if (id.equals(user.getId()))
				return user;
		
		return null;
	}
	
	public User getUserByName(String name)
	{
		for (User user : _userList)
			if (name.equalsIgnoreCase(user.getName()))
				return user;
		
		return null;
	}
}

package sri.userservice.service;

import java.util.List;

import sri.userservice.dao.UserDao;
import sri.userservice.vo.User;

public class UserService
{
	// returns a list of all users
	public List<User> getAllUsers()
	{
		return new UserDao().getAllUsers();
	}

	// returns a single user by id
	public User getUserById(String id)
	{
		return new UserDao().getUserById(id);
	}
	
	// returns a single user by name
	public User getUserByName(String name)
	{
		return new UserDao().getUserByName(name);
	}

	// creates a new user
	public User createUser(String name, String email)
	{
		return null;
	}

	// updates an existing user
	public User updateUser(String id, String name, String email)
	{
		return null;
	}
	
	public int getUserCount()
	{
		return 5; // some testing value
	}

}

package sri.userservice.controller;

import static spark.Spark.get;
import static sri.userservice.util.JsonUtil.json;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;
import sri.userservice.service.UserService;
import sri.userservice.util.JsonTransformer;
import sri.userservice.vo.User;

public class UserController
{
	public UserController(final UserService userService)
	{
		// browser url --> http://localhost:4567/userCount 
		get("/userCount", new Route()
		{
			@Override
			public Object handle(Request request, Response response)
			{
				return userService.getUserCount();
			}
		});
		
		// browser url --> http://localhost:4567/getAllUsers 
		get("/getAllUsers", new Route()
		{
			@Override
			public Object handle(Request request, Response response)
			{
				return userService.getAllUsers();
			}
		});
		
		// browser url --> http://localhost:4567/getAllUsersJson 
		get("/getAllUsersJson", new Route()
		{
			@Override
			public Object handle(Request request, Response response)
			{
				return userService.getAllUsers();
			}
		}, json());
		
		// browser url --> http://localhost:4567/getAllUsersJson2 
		get("/getAllUsersJson2", new Route()
		{
			@Override
			public Object handle(Request request, Response response)
			{
				return userService.getAllUsers();
			}
		}, new JsonTransformer());
		
		// browser url --> http://localhost:4567/getAllUsersJson3
		Gson gson = new Gson();
		get("/getAllUsersJson3", new Route()
		{
			@Override
			public Object handle(Request request, Response response)
			{
				return userService.getAllUsers();
			}
		}, gson::toJson); // or new Gson()::toJson 
		
		// browser url --> http://localhost:4567/users/{id}		
		get("/user/:id", (req, res) -> 
		{
			String id = req.params(":id");
			  
			User user = userService.getUserById(id);
			if (null != user)
				return user;
			  
			res.status(400);
			return new String("No user with id <" + id + "> found.");
		}, json());
		
		// browser url --> http://localhost:4567/users/{id}		
		get("/user", (req, res) -> 
		{
			String name = req.queryParams("name");
			  
			User user = userService.getUserByName(name);
			if (null != user)
				return user;
			  
			res.status(400);
			return new String("No user with name <" + name + "> found.");
		}, json());
	}
}

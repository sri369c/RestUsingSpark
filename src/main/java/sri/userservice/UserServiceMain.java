package sri.userservice;

import sri.userservice.controller.UserController;
import sri.userservice.service.UserService;

public class UserServiceMain
{
		public static void main(String[] args) 
		{
			new UserController(new UserService());
		}
}

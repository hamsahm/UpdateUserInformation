package service;

import dao.UserDAO;
import model.User;

public class UserService {

	public User fetchUserDetails(User user) {

		UserDAO dao = new UserDAO();
		return dao.retrieveUserDetails(user.getUserId());
	}

	public void updateUserDetails(User user) {
		UserDAO dao = new UserDAO();
		dao.update(user);

	}

}

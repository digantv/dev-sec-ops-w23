package org.dnyanyog.service;

import static java.util.Objects.nonNull;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl {

	Logger logger = LoggerFactory.getLogger(UserManagementServiceImpl.class);
	@Autowired
	UsersRepository userRepo; // Ask Spring to give object of 'Query class for Users' i.e UserRepository
	@Autowired
	AddUserResponse userResponse;
	@Autowired
	private List<Long> userIds;

	public Optional<AddUserResponse> addUpdateUser(AddUserRequest request) {

		Users usersTable = new Users(); // Create table object in which we set data from request

		usersTable.setAge(request.getAge());
		usersTable.setEmail(request.getEmail());
		usersTable.setPassword(request.getPassword());
		usersTable.setUsername(request.getUsername());

		usersTable = userRepo.save(usersTable); // Ask repostiry to save the data from userTable to DB Table

		userResponse.setMessage("User added successfuly"); // Response set
		userResponse.setStatus("Success");
		userResponse.setUserId(usersTable.getUserId()); // get id from saved data and set it in response object
		userResponse.setStatus("Success");
		userResponse.setMessage("User found");

		userResponse.setUserId(usersTable.getUserId());
		userResponse.getUserData().setEmail(usersTable.getEmail());
		userResponse.getUserData().setUsername(usersTable.getUsername());
		userResponse.getUserData().setPassword(usersTable.getPassword());
		userResponse.getUserData().setAge(usersTable.getAge());

		return Optional.of(userResponse);
	}

	public AddUserResponse getSingleUser(Long userId) {

		Optional<Users> receivedData = userRepo.findById(userId);

		if (receivedData.isEmpty()) {
			userResponse.setStatus("Fail");
			userResponse.setMessage("User not found");
		} else {
			Users user = receivedData.get();
			userResponse.setStatus("Success");
			userResponse.setMessage("User found");
			userResponse.setUserId(user.getUserId());
			userResponse.getUserData().setEmail(user.getEmail());
			userResponse.getUserData().setUsername(user.getUsername());
			userResponse.getUserData().setPassword(user.getPassword());
			userResponse.getUserData().setAge(user.getAge());
		}
		return userResponse;
	}

	public List<Users> getAllUser() {
		return userRepo.findAll();
	}

	public List<Long> getAllUserIds() {

		List<Users> users = userRepo.findAll();

		for (Users user : users) {
			if (nonNull(user)) {
				userIds.add(user.getUserId());
			}
		}
		return userIds;
	}

	public List<Users> getFilteredUser(String email, String username) {
		if (email != null && username != null) {
			return userRepo.findByEmailAndUsername(email, username);
		} else if (email != null) {
			return userRepo.findByEmail(email);
		} else if (username != null) {
			return userRepo.findByUsername(username);
		} else {
			return userRepo.findAll();
		}
	}
}

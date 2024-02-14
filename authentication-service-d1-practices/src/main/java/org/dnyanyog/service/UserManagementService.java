package org.dnyanyog.service;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;
import org.dnyanyog.entity.Users;

public interface UserManagementService {

	Optional<AddUserResponse> addUpdateUser(AddUserRequest request);

	public AddUserResponse getSingleUser(Long userId);

	public List<Users> getAllUser();

	public List<Long> getAllUserIds();

	public List<Users> getFilteredUser();

}

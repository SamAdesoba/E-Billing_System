package EBillingSystem.services;

import EBillingSystem.data.models.User;
import EBillingSystem.data.repositories.UserRepository;
import EBillingSystem.dtos.requests.AddUserRequest;
import EBillingSystem.dtos.requests.DeleteUserRequest;
import EBillingSystem.dtos.requests.EditUserRequest;
import EBillingSystem.dtos.requests.SearchUserRequest;
import EBillingSystem.dtos.responses.AddUserResponse;
import EBillingSystem.dtos.responses.DeleteUserResponse;
import EBillingSystem.dtos.responses.EditUserResponse;
import EBillingSystem.dtos.responses.SearchUserResponse;
import EBillingSystem.exceptions.DuplicateUserException;
import org.springframework.beans.factory.annotation.Autowired;



import static EBillingSystem.Utils.Mapper.*;

public class UserServiceImp implements UserServices{
	@Autowired
	private UserRepository userRepository;

	@Override
	public AddUserResponse addUser(AddUserRequest request) {
		if(userRepository.existsByEmail(request.getEmail()))
			throw new DuplicateUserException("User already exist!!");

		User user = new User();
		map(request, user);

		User savedUser = userRepository.save(user);

		AddUserResponse response = new AddUserResponse();
		map(savedUser, response);

		return response;
	}



	@Override
	public EditUserResponse editUser(EditUserRequest request) {
		return null;
	}

	@Override
	public DeleteUserResponse deleteUser(DeleteUserRequest request) {
		return null;
	}

	@Override
	public SearchUserResponse searchUser(SearchUserRequest request) {
		return null;
	}
}

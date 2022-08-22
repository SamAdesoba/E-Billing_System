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
import EBillingSystem.exceptions.DuplicateUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import static EBillingSystem.Utils.Mapper.*;
@Service
public class UserServiceImp implements UserServices{

	private UserRepository userRepository;
	@Autowired
	public UserServiceImp(UserRepository userRepository){
		this.userRepository = userRepository;
	}

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
		if(!userRepository.existsByEmail(request.getEmail()))
			throw new DuplicateUserException("User doesn't exist!!");

		User foundUser = userRepository.findByEmail(request.getEmail());

		foundUser.setEmail(request.getEmail());
		foundUser.setUserName(request.getUserName());
		foundUser.setDob(request.getDob());
		foundUser.setAddress(request.getAddress());

		User editedUser = userRepository.save(foundUser);
		EditUserResponse response = new EditUserResponse();
		map(editedUser, response);

		return response;
	}

	@Override
	public DeleteUserResponse deleteUser(DeleteUserRequest request) {
		if(!userRepository.existsByEmail(request.getEmail()))
			throw new DuplicateUserException("User doesn't exist!!");

		User foundUser = userRepository.findByEmail(request.getEmail());
		userRepository.delete(foundUser);
		DeleteUserResponse response = new DeleteUserResponse();
		if (!userRepository.equals(foundUser)) {
			response.setDeleteMessage("User deleted");
		}
		return response;
	}

	@Override
	public User searchUser(SearchUserRequest request) {
		if(!userRepository.existsByEmail(request.getEmail()))
			throw new DuplicateUserException("User doesn't exist!!");

		User foundUser = userRepository.findByEmail(request.getEmail());

		return foundUser;
	}
}

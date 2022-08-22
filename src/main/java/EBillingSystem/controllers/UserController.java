package EBillingSystem.controllers;

import EBillingSystem.dtos.requests.AddUserRequest;
import EBillingSystem.dtos.requests.DeleteUserRequest;
import EBillingSystem.dtos.requests.EditUserRequest;
import EBillingSystem.dtos.requests.SearchUserRequest;
import EBillingSystem.dtos.responses.APIResponse;
import EBillingSystem.exceptions.DuplicateUserException;
import EBillingSystem.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping("/EBilling")
public class UserController {

	@Autowired
	private UserServices userServices;

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody AddUserRequest addUserRequest) {
		try {
			var servicesResponse = userServices.addUser(addUserRequest);
			APIResponse response = new APIResponse(true, servicesResponse);
			return new ResponseEntity<>(response, CREATED);
		} catch (DuplicateUserException ex){
			APIResponse response = new APIResponse(false, ex.getMessage());
			return new ResponseEntity<>(response, BAD_REQUEST);
		}
	}


	@PostMapping("/edit")
	public ResponseEntity<?> edit(@RequestBody EditUserRequest editUserRequest){
		try {
			var servicesResponse = userServices.editUser(editUserRequest);
			APIResponse response = new APIResponse(true, servicesResponse);
			return new ResponseEntity<>(response, ACCEPTED);
		} catch (DuplicateUserException ex){
			APIResponse response = new APIResponse(false, ex.getMessage());
			return new ResponseEntity<>(response, BAD_REQUEST);
		}
	}


	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody DeleteUserRequest deleteUserRequest){
		try {
			var servicesResponse = userServices.deleteUser(deleteUserRequest);
			APIResponse response = new APIResponse(true, servicesResponse);
			return new ResponseEntity<>(response, GONE);
		} catch (DuplicateUserException ex){
			APIResponse response = new APIResponse(false, ex.getMessage());
			return new ResponseEntity<>(response, BAD_REQUEST);
		}
	}

	@GetMapping("/user")
	public ResponseEntity<?> searchUser(@RequestBody SearchUserRequest searchUserRequest){
		try {
			var servicesResponse = userServices.searchUser(searchUserRequest);
			APIResponse response = new APIResponse(true, servicesResponse);
			return new ResponseEntity<>(response, FOUND);
		} catch (DuplicateUserException ex){
			APIResponse response = new APIResponse(false, ex.getMessage());
			return new ResponseEntity<>(response, NOT_FOUND);
		}
	}

}

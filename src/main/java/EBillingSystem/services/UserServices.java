package EBillingSystem.services;

import EBillingSystem.data.models.User;
import EBillingSystem.dtos.requests.AddUserRequest;
import EBillingSystem.dtos.requests.DeleteUserRequest;
import EBillingSystem.dtos.requests.EditUserRequest;
import EBillingSystem.dtos.requests.SearchUserRequest;
import EBillingSystem.dtos.responses.AddUserResponse;
import EBillingSystem.dtos.responses.DeleteUserResponse;
import EBillingSystem.dtos.responses.EditUserResponse;

public interface UserServices {

	AddUserResponse addUser(AddUserRequest request);

	EditUserResponse editUser(EditUserRequest request);

	DeleteUserResponse deleteUser(DeleteUserRequest request);

	User searchUser(SearchUserRequest request);
}

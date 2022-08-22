package EBillingSystem.Utils;

import EBillingSystem.data.models.User;
import EBillingSystem.dtos.requests.AddUserRequest;
import EBillingSystem.dtos.responses.AddUserResponse;
import EBillingSystem.dtos.responses.EditUserResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {

	public static void map(User savedUser, AddUserResponse response) {
		response.setUserName(savedUser.getUserName());
		response.setEmail(savedUser.getEmail());
		response.setDate(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy, hh:mm, a").format(savedUser.getDatedAdded()));
	}

	public static void map(User foundUser, EditUserResponse response) {
		response.setUserName(foundUser.getUserName());
		response.setEmail(foundUser.getEmail());
		response.setDate(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy, hh:mm, a").format(foundUser.getDatedAdded()));
	}

	public static void map(AddUserRequest request, User user) {
		user.setEmail(request.getEmail());
		user.setUserName(request.getUserName());
		user.setPassword(request.getPassword());
		user.setAddress(request.getAddress());
		user.setDob(String.valueOf(DateTimeFormatter.ofPattern("d MMM uuuu").parse(request.getDob())));
	}
}

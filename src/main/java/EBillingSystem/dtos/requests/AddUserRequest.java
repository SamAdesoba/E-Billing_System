package EBillingSystem.dtos.requests;

import lombok.Data;

@Data
public class AddUserRequest {
	private String userName;
	private String email;
	private String dob;
	private String address;
	private String password;
}

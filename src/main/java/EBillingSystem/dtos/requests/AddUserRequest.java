package EBillingSystem.dtos.requests;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AddUserRequest {
	private String userName;
	private String email;
	private LocalDateTime dob;
	private String address;
	private String password;
}

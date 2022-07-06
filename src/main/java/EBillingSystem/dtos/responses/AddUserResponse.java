package EBillingSystem.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AddUserResponse {

	private String userName;
	private String email;
	private String date;
}

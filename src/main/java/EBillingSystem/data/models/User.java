package EBillingSystem.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	@Id
	private String id;
	@NonNull
	private int roleId;
	private String userName;
	private String email;
	private String dob;
	private String address;
	private String password;
	private LocalDateTime datedAdded = LocalDateTime.now();


}

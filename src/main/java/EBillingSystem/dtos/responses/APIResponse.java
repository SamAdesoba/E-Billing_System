package EBillingSystem.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APIResponse {
	private boolean isSuccessful;
	private Object data;
}

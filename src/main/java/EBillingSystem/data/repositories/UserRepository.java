package EBillingSystem.data.repositories;

import EBillingSystem.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	boolean existsByEmail(String email);

	User findByEmail(String email);
}

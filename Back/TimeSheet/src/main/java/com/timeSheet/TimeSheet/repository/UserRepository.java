package com.timeSheet.TimeSheet.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.timeSheet.TimeSheet.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByEmail(String email);
}

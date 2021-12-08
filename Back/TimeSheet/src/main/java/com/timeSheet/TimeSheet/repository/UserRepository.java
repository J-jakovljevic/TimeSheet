package com.timeSheet.TimeSheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timeSheet.TimeSheet.mail.model.Mail;
import com.timeSheet.TimeSheet.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

	User findByEmail(String email);

	User findByEmail(Mail mail);
}

package com.timeSheet.TimeSheet.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.timeSheet.TimeSheet.dto.LoginDTO;
import com.timeSheet.TimeSheet.dto.PasswordChangeDTO;
import com.timeSheet.TimeSheet.dto.UserDTO;
import com.timeSheet.TimeSheet.model.User;

public interface IUserService {
	ResponseEntity<UserDTO> login(LoginDTO loginDTO);
	List<User> findAll();
	User findById(Long id);
	User findByEmail(String email);
	UserDTO register(UserDTO userDTO) throws Exception;
	ResponseEntity<User> changePassword(PasswordChangeDTO passwordChangedDTO);
	ResponseEntity<User> createNewPassword(PasswordChangeDTO passwordChangedDTO);
	User findByUsername(String username);
	

}

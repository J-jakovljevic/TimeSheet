package com.timeSheet.TimeSheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.timeSheet.TimeSheet.dto.LoginDTO;
import com.timeSheet.TimeSheet.dto.UserDTO;
import com.timeSheet.TimeSheet.model.User;
import com.timeSheet.TimeSheet.repository.UserRepository;
@Service
public class UserService  implements IUserService  {
	
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseGet(null);
	}
	
	@Override
	public ResponseEntity<UserDTO> login(LoginDTO loginDTO) {
		List<User> users = userRepository.findAll();
		for(User user : users) {
			if(loginDTO.getUsername().contains("@")) {
				if(user.getEmail().equals(loginDTO.getUsername())) {
					if(user.getPassword().equals(loginDTO.getPassword())) {
						return new ResponseEntity<UserDTO>(new UserDTO(user),HttpStatus.OK);
					}
				}
			}
			else {
				if(user.getUsername().equals(loginDTO.getUsername())) {
					if(user.getPassword().equals(loginDTO.getPassword())) {
						return new ResponseEntity<UserDTO>(new UserDTO(user),HttpStatus.OK);
					}
				}
			}
		}
		return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
}
package com.timeSheet.TimeSheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.timeSheet.TimeSheet.controller.AlreadyExistsException;
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
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElse(null);
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

	@Override
	public UserDTO register(UserDTO userDTO) throws Exception {
		if ( userRepository.findByEmail(userDTO.getEmail()).orElse(null) != null) {
            throw new AlreadyExistsException(String.format("User with email %s, already exists", userDTO.getEmail()));
	}
		if(userRepository.findByEmail(userDTO.getEmail()).orElse(null) == null) {
			User user = new User(userDTO.getName(), userDTO.getSurname(), userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword());
			user = this.userRepository.save(user);
			return new UserDTO(user);
		}
		return null;
	}
}

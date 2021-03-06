package com.timeSheet.TimeSheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.timeSheet.TimeSheet.dto.LoginDTO;
import com.timeSheet.TimeSheet.dto.PasswordChangeDTO;
import com.timeSheet.TimeSheet.dto.UserDTO;
import com.timeSheet.TimeSheet.model.User;
import com.timeSheet.TimeSheet.repository.RoleRepository;
import com.timeSheet.TimeSheet.repository.UserRepository;
import com.timeSheet.exception.AlreadyExistsException;
import com.timeSheet.exception.NotFoundException;

@Service
public class UserService  implements IUserService  {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	@Autowired
	public UserService(UserRepository userRepository,  RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
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
		User user = userRepository.findByEmail(email);
	      if (user == null)
	            throw new NotFoundException("User with email " + email + "doesn't exists");
	        return user;
	}
	
	@Override
	public User findByUsername(String username) {
		User user = userRepository.findByUsername(username);
	      if (user == null)
	            throw new NotFoundException("User with email " + username + "doesn't exists");
	        return user;
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
	public String getRandomQuestion(Long id) {
		User user = userRepository.findById(id).get();
		List<String> questions = user.getQuestions();
		
		int numberOfQuestions = questions.size();
		int min = 0;
		int max = numberOfQuestions - 1;
		
		return questions.get((int) ((Math.random() * (max - min)) + min));
		
	}
	
	@Override
	public boolean isAnswerCorrect(Long id, String answer) {
		User user = userRepository.findById(id).get();
		
		return user.isAnswerCorrect(answer);
	}

	@Override
	public UserDTO register(UserDTO userDTO) throws Exception {
		if ( userRepository.findByEmail(userDTO.getEmail()) != null) {
            throw new AlreadyExistsException(String.format("User with email %s, already exists", userDTO.getEmail()));
	}
		if ( userRepository.findByUsername(userDTO.getUsername()) != null) {
            throw new AlreadyExistsException(String.format("User with email %s, already exists", userDTO.getEmail()));
	}
		
		if(userRepository.findByEmail(userDTO.getEmail()) == null) {
			User user = new User(userDTO.getName(), userDTO.getSurname(), userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword(), roleRepository.findById(Long.valueOf(2)).get(), 
						userDTO.getHouse_number(), userDTO.getFirst_job(), userDTO.getGrandmother_name(), userDTO.getFirst_pet(), userDTO.getOldest_child(), userDTO.getFirst_concert(),
						userDTO.getFirst_car(), userDTO.getParents_meet(), userDTO.getFavorite_place(), userDTO.getDream_job());
			user = this.userRepository.save(user);
			return new UserDTO(user);
		}
		return null;
	}
	
	@Override
	public ResponseEntity<User> changePassword(PasswordChangeDTO passwordChangedDTO) {
		List<User> users = userRepository.findAll();
		for(User user : users) {
		  
			if(passwordChangedDTO.getEmail().contains("@")) {
				if(user.getEmail().equals(passwordChangedDTO.getEmail())) {
					if(passwordChangedDTO.getNewPassword().equals(passwordChangedDTO.getConfirmPassword())) {
						
						user.setPassword(passwordChangedDTO.getNewPassword());
						userRepository.save(user);
						return new ResponseEntity<User>(user,HttpStatus.OK);
					}
				}
			}
			else {
				if(user.getUsername().equals(passwordChangedDTO.getEmail())) {
					if(passwordChangedDTO.getNewPassword().equals(passwordChangedDTO.getConfirmPassword())) {
						user.setPassword(passwordChangedDTO.getNewPassword());
						 userRepository.save(user);
						return new ResponseEntity<User>(user,HttpStatus.OK);
					}
				}
			}
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}

	
	@Override
	public ResponseEntity<User> createNewPassword(PasswordChangeDTO passwordChangedDTO) {
		List<User> users = userRepository.findAll();
		for(User user : users) {
	
				if(user.getEmail().equals(passwordChangedDTO.getEmail())) {
					if(passwordChangedDTO.getNewPassword().equals(passwordChangedDTO.getConfirmPassword())) {
						user.setPassword(passwordChangedDTO.getNewPassword());
						userRepository.save(user);
						return new ResponseEntity<User>(user,HttpStatus.OK);
					}
				}
		
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}





}

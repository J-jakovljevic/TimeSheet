package com.timeSheet.TimeSheet.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.timeSheet.TimeSheet.dto.LoginDTO;
import com.timeSheet.TimeSheet.dto.PasswordChangeDTO;
import com.timeSheet.TimeSheet.dto.UserDTO;
import com.timeSheet.TimeSheet.model.User;
import com.timeSheet.TimeSheet.service.IUserService;

@ResponseBody
@RestController
@RequestMapping(value = "api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDTO>> getAllUsers()
	{
		List<User> userList = userService.findAll();
		List<UserDTO> userListDTO = new ArrayList<>(); 
		for(User u : userList) {
			userListDTO.add(new UserDTO(u));
		}
		return new ResponseEntity<List<UserDTO>>(userListDTO, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/login-user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> login(@RequestBody LoginDTO loginDTO) throws Exception{
		return userService.login(loginDTO);
	}
	
	@PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) throws Exception 
		{
			UserDTO registeredUser = userService.register(userDTO);
			if(registeredUser == null) {
				return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<UserDTO>(registeredUser, HttpStatus.OK);
		}
	
	 @PutMapping(value = "/change-password")
		public ResponseEntity<User> changePassword(@RequestBody PasswordChangeDTO passwordChangedDTO) throws Exception{
			return userService.changePassword(passwordChangedDTO);
		}
	 
	 @PutMapping(value = "/create-new-password")
		public ResponseEntity<User> createNewPassword(@RequestBody PasswordChangeDTO passwordChangedDTO) throws Exception{
			return userService.createNewPassword(passwordChangedDTO);
		}
	 
	 @CrossOrigin(origins = "http://localhost:4200")
	 @GetMapping(value = "/random-question/{id}", produces = MediaType.APPLICATION_JSON_VALUE) 
		 public ResponseEntity<String> getRandomQuestion(@PathVariable Long id){
			return new ResponseEntity<String> (userService.getRandomQuestion(id), HttpStatus.OK);
	 }
		 
	 
	 @PostMapping(value = "/is-answer-correct/{id}/{answer}")
	 	public ResponseEntity<Boolean> isAnswerCorrect(@PathVariable Long id, @PathVariable String answer) {
	 		return new ResponseEntity<Boolean>(userService.isAnswerCorrect(id, answer), HttpStatus.OK);
	 	}
}
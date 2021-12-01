package com.timeSheet.TimeSheet.dto;

import java.util.HashSet;
import java.util.Set;

import com.timeSheet.TimeSheet.model.Role;
import com.timeSheet.TimeSheet.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {

	private Long id;

	private String name;

	private String surname;
	
	private String email;
	
	private String username;

	private String password;
	
	private Set<Role> roles = new HashSet<Role>();
	
	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.email = user.getEmail();
		this.username = user.getUsername();
		this.password = user.getPassword();
	//	this.roles = user.getRoles();
	}
}

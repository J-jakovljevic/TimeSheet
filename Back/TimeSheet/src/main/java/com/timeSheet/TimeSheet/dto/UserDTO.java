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
	
	private String house_number;
	
	private String first_job;
	
	private String grandmother_name;
	
	private String first_pet;
	
	private String oldest_child;
	
	private String first_concert;
	
	private String first_car;
	
	private String parents_meet;
	
	private String favorite_place;
	
	private String dream_job;
	
	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.email = user.getEmail();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.roles = user.getRoles();
		this.house_number = user.getHouse_number();
		this.first_job = user.getFirst_job();
		this.grandmother_name = user.getGrandmother_name();
		this.first_pet = user.getFirst_pet();
		this.oldest_child = user.getOldest_child();
		this.first_car = user.getFirst_car();
		this.parents_meet = user.getParents_meet();
		this.favorite_place = user.getFavorite_place();
		this.dream_job = user.getDream_job();
	}
}

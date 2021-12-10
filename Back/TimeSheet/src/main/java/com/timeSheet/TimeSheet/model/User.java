package com.timeSheet.TimeSheet.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "surname", nullable = false)
	private String surname;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;
	
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	private Set<Role> roles = new HashSet<Role>();
    
    @Column(name = "house_number_as_child", nullable = false)  // What was the house number you lived in as a child?
	private String house_number;
    
    @Column(name = "first_job_city", nullable = false)  //In what city was your first full time job?
	private String first_job;
    
    @Column(name = "grandmother_name", nullable = false)  //What is your grandmother name?
	private String grandmother_name;
    
    @Column(name = "first_pet_name", nullable = false)  // What was the name of your first pet?
	private String first_pet;
    
    @Column(name = "oldest_child_name", nullable = false)  // What is the name of your oldest child?
   	private String oldest_child;
       
    @Column(name = "first_concert", nullable = false) // Whose first concert were you at?
   	private String first_concert;
       
    @Column(name = "first_car_model", nullable = false) // What was the model of your first car?
   	private String first_car;
       
    @Column(name = "parents_meet_city", nullable = false) // In which city did your parents meet?
   	private String parents_meet; 
       
    @Column(name = "favorite_place_as_child", nullable = false)  //What was your favorite place to visit as a child?
   	private String favorite_place;
       
    @Column(name = "dream_job_as_child", nullable = false)  // What was your dream job as a child?
   	private String dream_job;
       
    public User(String name, String surname, String username, String email, String password, Role role,
    			String house_number, String first_job, String grandmother_name, String first_pet, 
    			String oldest_child, String first_concert, String first_car, String parents_meet,
    			String favorite_place, String dream_job) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles.add(role);
		this.house_number = house_number;
		this.first_job = first_job;
		this.grandmother_name = grandmother_name;
		this.first_pet = first_pet; 
		this.oldest_child = oldest_child;
		this.first_concert = first_concert;
		this.first_car = first_car;
		this.parents_meet = parents_meet;
		this.favorite_place = favorite_place;
		this.dream_job = dream_job;
	}




	
}

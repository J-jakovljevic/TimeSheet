package com.timeSheet.TimeSheet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PasswordChangeDTO {
	
	private String email;
	private String newPassword;
	private String confirmPassword;
	private String securityQuestion;
	private String securityAnswer;

}

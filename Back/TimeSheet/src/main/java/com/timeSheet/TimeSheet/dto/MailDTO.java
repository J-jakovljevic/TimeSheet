package com.timeSheet.TimeSheet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailDTO {
	
	private String mailFrom;
	private String mailTo;
	private String mailSubject;
	private String mailContent;


}
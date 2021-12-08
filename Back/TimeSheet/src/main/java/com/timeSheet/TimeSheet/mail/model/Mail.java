package com.timeSheet.TimeSheet.mail.model;

import com.timeSheet.TimeSheet.dto.MailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mail {
    
	private String mailFrom;
    private String mailTo;
    private String mailSubject;
    private String mailContent;
    
    public Mail(MailDTO mailDTO) {
		this.mailFrom = mailDTO.getMailFrom();
		this.mailTo = mailDTO.getMailTo();
		this.mailSubject = mailDTO.getMailSubject();
		this.mailContent = mailDTO.getMailContent();
	}



   
}
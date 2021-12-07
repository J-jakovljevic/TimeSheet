package com.timeSheet.TimeSheet.mail.model;

import java.util.List;
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
    private String mailCc;
    private String mailBcc;
    private String mailSubject;
    private String mailContent;
    private String contentType;
    private List <Object> attachments;
    
    public Mail(MailDTO mailDTO) {
		this.mailFrom = mailDTO.getMailFrom();
		this.mailTo = mailDTO.getMailTo();
		this.mailCc = mailDTO.getMailCc();
		this.mailBcc = mailDTO.getMailBcc();
		this.mailSubject = mailDTO.getMailSubject();
		this.mailContent = mailDTO.getMailContent();
		this.contentType = mailDTO.getContentType();
		this.attachments = mailDTO.getAttachments();
	}
   
}
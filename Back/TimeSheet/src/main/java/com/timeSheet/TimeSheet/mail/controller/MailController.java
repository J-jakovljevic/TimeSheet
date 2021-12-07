package com.timeSheet.TimeSheet.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.timeSheet.TimeSheet.dto.MailDTO;
import com.timeSheet.TimeSheet.mail.model.Mail;
import com.timeSheet.TimeSheet.mail.service.MailService;

@RestController
@RequestMapping(value = "api/email")
public class MailController {
	
	private MailService emailService;
	
	@Autowired
	public MailController(MailService emailService) {
		this.emailService = emailService;
	}
	
	@PostMapping(value = "/email-sent", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean requestAbsence(@RequestBody MailDTO emailDTO) throws Exception{
		Mail mail = new Mail(emailDTO);
		return emailService.sendMail(mail);
	}
}
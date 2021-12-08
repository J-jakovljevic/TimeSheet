package com.timeSheet.TimeSheet.mail.service;

import java.util.List;

import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.timeSheet.TimeSheet.mail.model.Mail;
import com.timeSheet.TimeSheet.model.User;
import com.timeSheet.TimeSheet.repository.UserRepository;
import com.timeSheet.TimeSheet.service.UserService;

@Service
public class MailService implements IMailService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
    private final JavaMailSender javaMailSender;
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);
    private static final String MAIL_FROM = "timesheetjoksi@gmail.com";
    @Value("${custom.addr}")
    private String ADDR;
    @Value("${custom.fport}")
    private String PORT;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public boolean sendMail(Mail mail) {
    	List<User> users = userRepository.findAll();
		for(User user : users) {
			if(!user.getEmail().equals(mail.getMailTo().toString())) {
		    	return false;
		    } else {
		    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		 
	        try {
	            MimeMessageHelper mimeHelper = new MimeMessageHelper(mimeMessage, true);
	
	            mimeHelper.setSubject(mail.getMailSubject());
	            mimeHelper.setFrom(MAIL_FROM);
	            mimeHelper.setTo(mail.getMailTo());
	            mimeHelper.setText(mail.getMailContent());
	            javaMailSender.send(mimeHelper.getMimeMessage());
	            return true;
	        } catch (Exception e) {
	            logger.error("Exception while sending mail: {}", e.getMessage());
	            return false;
	        }
		}
	}
		return false;
} }
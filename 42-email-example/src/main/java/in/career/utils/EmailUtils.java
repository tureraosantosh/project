package in.career.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;

	public boolean sendEmail(String to,String subject,String body) {
		boolean isSent = false;
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		try {			
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setText(body);			
			mailSender.send(mimeMessageHelper.getMimeMessage());
			
			isSent=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
                     
		
		return isSent;
	}

}

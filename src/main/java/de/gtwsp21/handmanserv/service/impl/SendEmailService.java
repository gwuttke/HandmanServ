package de.gtwsp21.handmanserv.service.impl;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.ISpringTemplateEngine;

import de.gtwsp21.handmanserv.domain.PasswortToken;
import de.gtwsp21.handmanserv.service.ISendEmailService;

@Service
public class SendEmailService implements ISendEmailService {
	
	@Autowired
	private ISpringTemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendResetTokenEmail(final PasswortToken token) {
		MimeMessagePreparator message = createPasswortTokenEmail(token,true);
		mailSender.send(message);
	}

	@Override
	public void sendInitialTokenEmail(final PasswortToken token) {
		MimeMessagePreparator message = createPasswortTokenEmail(token,false);
		mailSender.send(message);
	}
	
	private MimeMessagePreparator createPasswortTokenEmail(final PasswortToken token,boolean isForReset) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

		Context context = new Context();
        context.setVariable("benutzer", token.getBenutzer());
        context.setVariable("token", token.getToken());
        context.setVariable("ablauf", token.getAblaufdatum().format(formatter));
        String text = templateEngine.process(isForReset?"resetUserPasswortMail":"newUserPasswortMail", context);
       
        MimeMessagePreparator messagePreparator = mimeMessage -> {
	        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
	        messageHelper.setFrom("no-replay@hoefischebv.by");
	        messageHelper.setSubject(isForReset?"Passwort zurücksetzen":"Herzlich Wilkommen bei HandmanServ");
	        messageHelper.setText(text);
	        messageHelper.setTo(token.getBenutzer().geteMailadresse());
		};
		return messagePreparator;
        
	}
}

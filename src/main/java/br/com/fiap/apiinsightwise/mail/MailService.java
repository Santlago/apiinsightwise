package br.com.fiap.apiinsightwise.mail;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    JavaMailSender mailSender;

    public void sendMail(String message) throws MessagingException {
        var email = mailSender.createMimeMessage();
        var helper = new MimeMessageHelper(email);

        helper.setTo("breno.santiago.8@gmail.com");
        helper.setSubject("Bem vindo ao Insight Wise");
        helper.setText("""
                    <h2>%s</h2>
                    <p>É muito bom ter você por aqui na Insight Wise</p>
                """.formatted(message), true);

        mailSender.send(email);
    }
}

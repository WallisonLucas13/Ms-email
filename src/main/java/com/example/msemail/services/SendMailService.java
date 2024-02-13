package com.example.msemail.services;

import com.example.msemail.models.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Service
public class SendMailService {

    @Autowired
    private JavaMailSender sender;

    public void sendMail(Mail mail){
        try {
            var simple = new SimpleMailMessage();
            simple.setTo(mail.getTo());
            simple.setSubject(mail.getTitulo());
            simple.setText(mail.getConteudo() + "\nEmail enviado as: " + LocalDateTime.now()
                            .format(DateTimeFormatter
                                    .ofLocalizedDateTime(FormatStyle.SHORT)));

            sender.send(simple);

        } catch(MailException e){
            e.printStackTrace();
        }
    }
}

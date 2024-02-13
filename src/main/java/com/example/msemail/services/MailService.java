package com.example.msemail.services;

import com.example.msemail.models.Mail;
import com.example.msemail.dtos.MailDto;
import com.example.msemail.repositories.MailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private MailRepository repository;

    @Autowired
    private SendMailService sendMailService;

    @Transactional
    public void save(MailDto dto){

        Mail mail = Mail.MailBuilder
                .builder()
                .to(dto.to())
                .titulo(dto.titulo())
                .conteudo(dto.conteudo())
                .build();

        repository.save(mail);
        repository.flush();
        sendMailService.sendMail(mail);
    }
}

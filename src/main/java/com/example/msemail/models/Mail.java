package com.example.msemail.models;

import jakarta.persistence.*;

@Entity
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "destinatario", nullable = false)
    private String to;

    @Column(nullable = false)
    private String conteudo;

    @Column(nullable = false)
    private String titulo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public static class MailBuilder{
        private Mail mail = new Mail();

        public static MailBuilder builder(){
            return new MailBuilder();
        }
        public MailBuilder to(String to){
            mail.to = to;
            return this;
        }

        public MailBuilder conteudo(String conteudo){
            mail.conteudo = conteudo;
            return this;
        }

        public MailBuilder titulo(String titulo){
            mail.titulo = titulo;
            return this;
        }

        public Mail build(){
            return mail;
        }
    }
}

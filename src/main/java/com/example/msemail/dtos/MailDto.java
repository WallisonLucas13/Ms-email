package com.example.msemail.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record MailDto(@NotBlank @Email String to,
                      @NotBlank String conteudo,
                      @NotBlank String titulo) {
}

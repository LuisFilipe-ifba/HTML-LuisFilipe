package com.br.ifba.salva_fome.Usuario.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {

    @JsonProperty("nome")
    @NotNull(message = "O nome é obrigatório")
    @NotBlank(message = "O nome não pode ser vazio")
    private String nome;

    @JsonProperty("email")
    @NotNull(message = "O email é obrigatório")
    @NotBlank(message = "O email não pode ser vazio")
    @Email(message = "O email deve ser válido")
    private String email;

    @JsonProperty("senha")
    @NotNull(message = "A senha é obrigatória")
    @NotBlank(message = "A senha não pode ser vazia")
    private String senha;
}
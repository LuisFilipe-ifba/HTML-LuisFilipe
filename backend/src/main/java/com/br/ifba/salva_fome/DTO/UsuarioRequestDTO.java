package com.br.ifba.salva_fome.DTO;

import lombok.Data;

@Data
public class UsuarioRequestDTO {

    private String nome;
    private String email;
    private String senha;
}
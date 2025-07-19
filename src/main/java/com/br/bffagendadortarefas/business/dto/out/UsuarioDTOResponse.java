package com.br.bffagendadortarefas.business.dto.out;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTOResponse {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTOResponse> enderecos; // EnderecoDTO endereco;
    private List<TelefoneDTOResponse> telefones; // TelefoneDTO telefone;
}

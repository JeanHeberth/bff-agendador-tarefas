package com.br.bffagendadortarefas.business.service.dto.in;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTORequest {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTORequest> enderecos; // EnderecoDTO endereco;
    private List<TelefoneDTORequest> telefones; // TelefoneDTO telefone;
}

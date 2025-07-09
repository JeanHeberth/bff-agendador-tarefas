package com.br.bffagendadortarefas.business.dto.out;
import com.br.bffagendadortarefas.business.service.dto.out.EnderecoDTOResponse;
import com.br.bffagendadortarefas.business.service.dto.out.TelefoneDTOResponse;

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

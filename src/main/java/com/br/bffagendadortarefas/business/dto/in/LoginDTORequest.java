package com.br.bffagendadortarefas.business.dto.in;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTORequest {

    private String email;
    private String senha;
}

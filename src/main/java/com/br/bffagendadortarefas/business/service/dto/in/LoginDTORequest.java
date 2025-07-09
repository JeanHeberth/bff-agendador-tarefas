package com.br.bffagendadortarefas.business.service.dto.in;

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

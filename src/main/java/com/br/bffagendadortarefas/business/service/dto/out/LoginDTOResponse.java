package com.br.bffagendadortarefas.business.service.dto.out;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTOResponse {

    private String email;
    private String senha;
}

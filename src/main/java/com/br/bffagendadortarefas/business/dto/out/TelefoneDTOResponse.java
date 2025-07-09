package com.br.bffagendadortarefas.business.service.dto.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TelefoneDTOResponse {

    private String numero;
    private String ddd;
}

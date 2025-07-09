package com.br.bffagendadortarefas.business.service.dto.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TelefoneDTORequest {

    private Long id;
    private String numero;
    private String ddd;
}

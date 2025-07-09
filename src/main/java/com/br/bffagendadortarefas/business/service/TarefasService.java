package com.br.bffagendadortarefas.business.service;


import com.br.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.br.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.br.bffagendadortarefas.infrastructure.client.TarefasClient;
import com.br.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;


    public TarefasDTOResponse gravarTarefa(TarefasDTORequest tarefasDTO, String token) {
        return tarefasClient.gravaTarefa(tarefasDTO, token);
    }

    public List<TarefasDTOResponse> buscarTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                                    LocalDateTime dataFinal,
                                                                    String token) {
        return tarefasClient.buscarTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token);

    }

    public List<TarefasDTOResponse> buscarTarefasPorEmail(String token) {
        return tarefasClient.buscarTarefasPorEmail(token);
    }

    public void deletarTarefaPorId(String id,
                                   String token) {
        tarefasClient.deletarTarefaPorId(id, token);
    }

    public TarefasDTOResponse alteraStatusTarefa(String id, StatusNotificacaoEnum statusNotificacaoEnum,
                                                 String token) {
        return tarefasClient.alteraStatusNotificacao(statusNotificacaoEnum, id, token);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest tarefasDTO,
                                           String id,
                                           String token) {
        return tarefasClient.updateTarefa(tarefasDTO, id, token);
    }

}

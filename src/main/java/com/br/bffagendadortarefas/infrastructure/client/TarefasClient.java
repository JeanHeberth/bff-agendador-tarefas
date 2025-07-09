package com.br.bffagendadortarefas.infrastructure.client;

import com.br.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.br.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.br.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTOResponse gravaTarefa(@RequestBody TarefasDTORequest tarefasDTO,
                                   @RequestHeader("Authorization") String token);


    @GetMapping("/eventos")
    List<TarefasDTOResponse> buscarTarefasAgendadasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);


    @GetMapping()
    List<TarefasDTOResponse> buscarTarefasPorEmail(@RequestHeader("Authorization") String token);


    @DeleteMapping
    void deletarTarefaPorId(@RequestParam("id") String id,
                            @RequestHeader("Authorization") String token);

    @PatchMapping
    TarefasDTOResponse alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                              @RequestParam("id") String id,
                                              @RequestHeader("Authorization") String token);

    @PutMapping
    TarefasDTOResponse updateTarefa(@RequestBody TarefasDTORequest tarefasDTO,
                                   @RequestParam("id") String id,
                                   @RequestHeader("Authorization") String token);
}

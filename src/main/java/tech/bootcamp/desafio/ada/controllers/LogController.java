package tech.bootcamp.desafio.ada.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.bootcamp.desafio.ada.payloads.response.TableLogResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/log")
@Tag(name = "Log", description = "Retornar dados da partida")
public class LogController {

    @GetMapping(path = "/{tableId}", produces = "application/json" )
    public TableLogResponse getTable(){
        return new TableLogResponse();
    }
}

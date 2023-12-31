package tech.bootcamp.desafio.ada.services;


import tech.bootcamp.desafio.ada.entities.PlayTable;
import tech.bootcamp.desafio.ada.payloads.response.CreateTableResponse;
import tech.bootcamp.desafio.ada.payloads.request.CreateTableRequest;
import tech.bootcamp.desafio.ada.payloads.response.PlayTableRoundResponse;
import tech.bootcamp.desafio.ada.payloads.response.TableResponse;

import java.util.List;

public interface PlayTableService {

    CreateTableResponse createTable(CreateTableRequest createTableRequest);
    List<TableResponse> getAllTables();
    PlayTableRoundResponse getTableById(String id);
    TableResponse rollIniciative(String id);
    PlayTableRoundResponse updateTable(PlayTable playTable);
    void deleteTable(String id);
}

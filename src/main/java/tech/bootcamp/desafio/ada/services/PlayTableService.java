package tech.bootcamp.desafio.ada.services;


import tech.bootcamp.desafio.ada.entities.PlayTable;
import tech.bootcamp.desafio.ada.payloads.response.CreateTableResponse;
import tech.bootcamp.desafio.ada.payloads.request.CreateTableRequest;
import tech.bootcamp.desafio.ada.payloads.response.TableResponse;

import java.util.List;

public interface PlayTableService {

    CreateTableResponse createTable(CreateTableRequest createTableRequest);
    List<TableResponse> getAllTables();
    PlayTable getTableById(String id);
    TableResponse rollIniciative(String id);
    void deleteTable(String id);
}

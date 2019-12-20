package com.waz.zclient.core.network.api.client

import com.waz.zclient.core.exception.Failure
import com.waz.zclient.core.functional.Either
import com.waz.zclient.core.network.ApiService
import com.waz.zclient.core.network.NetworkClient
import com.waz.zclient.core.network.NetworkHandler
import com.waz.zclient.features.clients.ClientEntity

class ClientsService(private val networkClient: NetworkClient, networkHandler: NetworkHandler) : ApiService(networkHandler) {

    private val clientsApi by lazy { networkClient.create(ClientsApi::class.java) }

    fun allClients(): Either<Failure, List<ClientEntity>> =
        request(clientsApi.allClients(), emptyList())

    fun clientById(clientId: String?): Either<Failure, ClientEntity> =
        request(clientsApi.clientById(clientId), ClientEntity.empty())
}

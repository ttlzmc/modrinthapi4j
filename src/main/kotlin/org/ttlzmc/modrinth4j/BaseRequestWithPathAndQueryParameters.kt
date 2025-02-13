package org.ttlzmc.modrinth4j

import org.ttlzmc.modrinth4j.enums.Endpoint
import org.ttlzmc.modrinth4j.parameter.RequestParameter
import org.ttlzmc.modrinth4j.typed.ModrinthObject
import java.net.HttpURLConnection

abstract class BaseRequestWithPathAndQueryParameters<T : ModrinthObject>(
    endpoint: Endpoint,
    pathParameters: Collection<RequestParameter>,
    val queryParameters: Collection<RequestParameter>,
) : BaseRequestWithPathParameters<T>(endpoint, pathParameters) {
    abstract fun addQueryParameters(indexedParameters: List<RequestParameter>, connection: HttpURLConnection)
}
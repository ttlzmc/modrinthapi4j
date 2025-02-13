package org.ttlzmc.modrinth4j

import org.ttlzmc.modrinth4j.enums.Endpoint
import org.ttlzmc.modrinth4j.parameter.RequestParameter
import org.ttlzmc.modrinth4j.typed.ModrinthObject

abstract class BaseRequestWithPathParameters<T : ModrinthObject>(
    endpoint: Endpoint,
    val parameters: Collection<RequestParameter>
) : BaseRequest<T>(endpoint)
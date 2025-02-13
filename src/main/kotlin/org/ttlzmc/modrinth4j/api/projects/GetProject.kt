package org.ttlzmc.modrinth4j.api.projects

import org.json.JSONObject
import org.ttlzmc.modrinth4j.BaseRequestWithPathParameters
import org.ttlzmc.modrinth4j.enums.Endpoint
import org.ttlzmc.modrinth4j.parameter.RequestParameter
import org.ttlzmc.modrinth4j.typed.ModrinthObject
import org.ttlzmc.modrinth4j.typed.ModrinthProject
import org.ttlzmc.modrinth4j.enums.ProjectType
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL

class GetProject(idSlug: RequestParameter) : BaseRequestWithPathParameters<ModrinthObject>(
    Endpoint.PROJECT, listOf(idSlug)
) {

    private val url = "$BASE_URL${Endpoint.PROJECT.key}/$idSlug"

    override fun connection() = createConnection()

    override fun createConnection(): HttpURLConnection {
        val url = createURL()
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.connectTimeout = TIMEOUT
        connection.readTimeout = TIMEOUT
        return connection
    }

    override fun createURL(): URL {
        return URI.create(url).toURL()
    }

    override fun parseResponse(jsonResponse: JSONObject): ModrinthObject {
        val type = ProjectType.fromString(jsonResponse.getString("project_type"))
        return ModrinthProject(jsonResponse, type)
    }
}
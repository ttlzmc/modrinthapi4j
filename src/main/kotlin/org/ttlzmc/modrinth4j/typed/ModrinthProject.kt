package org.ttlzmc.modrinth4j.typed

import org.json.JSONObject
import org.ttlzmc.modrinth4j.api.EnvironmentSupport
import org.ttlzmc.modrinth4j.enums.Environment
import org.ttlzmc.modrinth4j.enums.ProjectType

class ModrinthProject(apiResponse: JSONObject, private val projectType: ProjectType): ModrinthObject(apiResponse) {
    val id = apiResponse.getString("id")
    val slug = apiResponse.getString("slug")

    val name = apiResponse.getString("title")
    val description = apiResponse.getString("description")

    val team = apiResponse.getString("team")

    val environmentSupport: EnvironmentSupport
    val license = License(apiResponse.getJSONObject("license"))

    val downloads = apiResponse.getInt("downloads")
    val followers = apiResponse.getInt("followers")

    init {
        val client = Environment.parseSupportability(apiResponse.getString("client_side"))
        val server = Environment.parseSupportability(apiResponse.getString("server_side"))
        environmentSupport = EnvironmentSupport(client, server)
    }

    fun getType() = projectType
}
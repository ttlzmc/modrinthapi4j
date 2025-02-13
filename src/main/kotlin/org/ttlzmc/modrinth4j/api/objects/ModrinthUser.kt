package org.ttlzmc.modrinth4j.api.objects

import org.json.JSONObject
import org.ttlzmc.modrinth4j.typed.ModrinthObject

class ModrinthUser(apiResponse: JSONObject) : ModrinthObject(apiResponse) {
    val id = apiResponse.getString("id")

    val username = apiResponse.getString("username")
    val displayName: String? = apiResponse.optString("name")

    val avatarURL = apiResponse.optString("avatar_url")
    val bio = apiResponse.optString("bio")
}
package org.ttlzmc.modrinth4j.typed

import org.json.JSONObject

class License(apiResponse: JSONObject) : ModrinthObject(apiResponse) {
    val id: String = apiResponse.getString("id")
    val name: String = apiResponse.getString("name")
    val url: String? = apiResponse.optString("url", null)
}
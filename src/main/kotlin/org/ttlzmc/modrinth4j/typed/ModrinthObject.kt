package org.ttlzmc.modrinth4j.typed

import org.json.JSONObject

abstract class ModrinthObject(private val response: JSONObject) {
    fun apiResponse() = response
}
package org.ttlzmc.modrinth4j

import org.json.JSONObject
import org.ttlzmc.modrinth4j.enums.Endpoint
import org.ttlzmc.modrinth4j.typed.ModrinthObject
import java.net.HttpURLConnection
import java.net.URL

/**
 * Represents a basic request object to `com.modrinth.api`
 */
abstract class BaseRequest<T : ModrinthObject>(private val endpoint: Endpoint) {

    @Throws(Exception::class)
    fun execute(): T {
        val connection = connection()
        val responseCode = connection.responseCode
        if (responseCode !in 200..299) { throw RuntimeException("Connection failed: $responseCode") }
        return parseResponse(JSONObject(connection.inputStream.bufferedReader().readText()))
    }

    protected abstract fun connection(): HttpURLConnection

    protected abstract fun createConnection(): HttpURLConnection

    protected abstract fun createURL(): URL

    protected abstract fun parseResponse(jsonResponse: JSONObject): T

    companion object {
        const val BASE_URL = "https://api.modrinth.com/v2/"
        const val TIMEOUT = 5000
    }
}
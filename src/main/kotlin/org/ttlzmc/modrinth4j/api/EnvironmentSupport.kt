package org.ttlzmc.modrinth4j.api

import org.ttlzmc.modrinth4j.enums.Environment

class EnvironmentSupport(
    private val client: Environment.Supportability,
    private val server: Environment.Supportability
) {
    fun isClientSide(): Boolean {
        return ((client == Environment.Supportability.REQUIRED)
                || (client == Environment.Supportability.OPTIONAL))
    }

    fun isServerSide(): Boolean {
        return ((server == Environment.Supportability.REQUIRED)
                || (server == Environment.Supportability.OPTIONAL))
    }

    fun client() = client
    fun server() = server
}
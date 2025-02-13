package org.ttlzmc.modrinth4j.enums

import org.ttlzmc.modrinth4j.api.EnvironmentSupport

/**
 * Environment supportability builder.
 *
 * Basically mods can support only client, or server, or both, etc.
 */
enum class Environment {
    CLIENT,
    SERVER
    ;

    companion object {
        fun of(environment: Environment, supports: Supportability): Pair<Environment, Supportability>  {
            return Pair(environment, supports)
        }

        fun of(client: Supportability, server: Supportability): EnvironmentSupport {
            return EnvironmentSupport(client, server)
        }

        fun parseEnvironment(environmentString: String): Environment {
            return Environment.valueOf(environmentString.uppercase())
        }

        fun parseSupportability(supportability: String): Supportability {
            return Supportability.valueOf(supportability.uppercase())
        }
    }

    enum class Supportability {
        REQUIRED,
        OPTIONAL,
        UNSUPPORTED
    }
}
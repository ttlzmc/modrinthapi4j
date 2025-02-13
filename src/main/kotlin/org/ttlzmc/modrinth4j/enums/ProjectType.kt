package org.ttlzmc.modrinth4j.enums

/**
 * All project types available on Modrinth
 * @author xw1w1
 * @since 1.0
 */
enum class ProjectType {
    MOD,
    MODPACK,
    RESOURCEPACK,
    SHADER
    ;

    companion object {
        fun fromString(str: String): ProjectType {
            return ProjectType.valueOf(str.uppercase())
        }
    }
}
package org.ttlzmc.modrinth4j.enums

enum class Endpoint(val key: String) {
    SEARCH("search"),
    PROJECT("project"),
    PROJECTS_RANDOM("projects"),
    CHECK("check"),
    DEPENDENCIES("dependencies"),

    VERSION("version"),
    VERSIONS("versions"),

    VERSION_FILE("versions"),

    USER("user"),
    USERS("users"),

}
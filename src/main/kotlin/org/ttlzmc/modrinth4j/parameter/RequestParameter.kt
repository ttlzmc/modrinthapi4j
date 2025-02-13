package org.ttlzmc.modrinth4j.parameter

data class RequestParameter(val name: String?, val param: String) {
    companion object {
        fun of(name: String, value: String) = RequestParameter(name, value)
    }
}
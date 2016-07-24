package com.genericapp.extnds.mozillarecpro

/**
 * Created by Nooba(PratickRoy) on 23-07-2016.
 */
data class Table(val id: Long?) {
    var products: List<Item>? = null
    var success: Int? = null
    var message: String? = null
}
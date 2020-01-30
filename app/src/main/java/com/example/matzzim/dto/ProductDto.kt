package com.example.matzzim.dto

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import java.time.LocalDateTime

data class ProductDto (
     var userId : Int = 0
    ,var userName: String? = null
    ,var userEmail: String? = null
    ,var id : Int = 0
    ,var name: String? = null
    ,var description: String? = null
    ,var category: String? = null
    ,var startPrice : Int = 0
    ,var immediatePurchasePrice : Int = 0
    ,var status : Int = 0
    ,var image: String? = null
    ,var term : Int = 0
    ,var endLine: LocalDateTime? = null
    ,var endTime: LocalDateTime? = null
    ,var isMaxPrice : Int = 0
    ,var bidPirce : Int = 0
) {

}
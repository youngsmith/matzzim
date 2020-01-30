package com.example.matzzim.dto

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class ProductDtoList (
    var productList : List<ProductDto>
) {

}
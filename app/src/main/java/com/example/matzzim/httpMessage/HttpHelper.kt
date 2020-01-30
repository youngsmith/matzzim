package com.example.matzzim.httpMessage

import com.example.matzzim.dto.ProductDto
import com.example.matzzim.dto.ProductDtoList
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.kittinunf.fuel.core.Headers
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import org.json.JSONArray
import org.json.JSONObject


class HttpHelper {
    private val ENDPOINT : String = "http://10.0.2.2:8080/product"
    private val TOKEN : String = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJncmVlbi1hdWN0aW9uIiwiZXhwIjoxNTgxMzYzNzA3LCJzdWIiOiJzZWN1cmUtYXBwIiwicm9sZSI6WyJST0xFX0FETUlOIl0sImVtYWlsIjoibWFzdGVyQGF1Y3Rpb24uY29tIiwidWlkIjoyN30.avAaRIZ_1J5Q1Z3GRaCx3z_8DYOjnDUyxiFOcgY8_od7PnPu9ufPmUAIpXqh2bGyzCNeuDWLS2X1ObMF_1LrIQ"

    fun getProductList() : List<ProductDto> {
        val productDtoList : List<ProductDto> = emptyList()

        val httpAsync = ENDPOINT
            .httpGet()
            .header(Headers.AUTHORIZATION, TOKEN)
            .responseString { request, response, result ->
                //do something with response
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                    }
                    is Result.Success -> {
                        val data : String = result.get()
                        var mapper = jacksonObjectMapper()
                        mapper.registerKotlinModule()
                        mapper.registerModule(JavaTimeModule())

                        val d = mapper.readValue(data, ProductDtoList::class.java)
                        println(d)


//                        for (i in 0 until list.length()) {
//                            val obj = list.getJSONObject(i)
//                            val title = obj.getString("name")
//                            println(title)
//                        }
                    }
                }
            }

        httpAsync.join()
        return  productDtoList
    }


}
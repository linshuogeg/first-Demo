package com.example.net


import com.example.net.protocol.TokenRespEntity
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST



interface TokenApi {

@FormUrlEncoded
@POST("token")
fun getToken(
    @Field("gtant_type") grant_type:String?,
    @Field("username") username:String?,
    @Field("password") password:String?
    ):Call<TokenRespEntity?>?
}
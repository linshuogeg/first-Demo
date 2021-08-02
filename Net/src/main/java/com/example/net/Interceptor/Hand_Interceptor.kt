package com.example.net.Interceptor

import okhttp3.Interceptor
import okhttp3.Response

class Hand_Interceptor() : Interceptor {
    private lateinit var hand :String
    constructor(string: String) : this() {
        this.hand = string
    }
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newBuilder = request.newBuilder()
        newBuilder.url(request.url())
            .addHeader("Authorization","bearer T0ujFIBQH_hafCQqMSOuKQmr0EQHIXQ8OE3dylVo_ulT9SLCMfipI2Zd_lI6mbweBgu2hQh6Y2eM7yO_dONk3FKsLhrl113jZBZzBXSCtgExUG2xuAlQvWP0b9cAxfVASXfsSALH9DfxDS_R4vpJUFl8x2JJMCugMdddplZy7FWA5cyIAONAEFLBwtNnvAoTQNFlk9WkjNouaR0I0Db_jv-69uyeQDjvjAwq98am6gYBao5KG5Yxr17rhvAidGplptuVekl_h0p0zLsEmme-0NyQyGR42ROkjsBvd2KXcvY")
//                      .addHeader("Authorization",hand)
        return chain.proceed(newBuilder.build())
    }
}
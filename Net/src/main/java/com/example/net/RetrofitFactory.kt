package com.example.net

import android.util.Log
import com.example.common.App.SPProDelegate
import com.example.common.Constant
import com.example.net.Interceptor.Hand_Interceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitFactory private constructor(){

//    private var token:String by SPProDelegate<String>("token","",false)
//    private var token ="szdKevwmntGnEo5uWLmCWc8K_kMeQYJ2aC29F-emFhR-uP7WSyzdr-5SWMguPXsWIfu1Fuof72dCTAKwsKgzH8L1Xcp3DPQg8W8E0xqxLEXihQ8ykJDMl6zMGVGV3S2_m9OZxmqpLfUGPc_kl8Jdotjob_0Sq7HLEvKREcmYS6utcc415p2SEJ4zw9fYNC32RtK4738XVBCR0KHSVHUAgo1mSfW0xevm4cWF1Z7Q563EVTi7yV7WEFC5ye07VJSM9ZPg3Pr5LAlOh4t3oZkVubOp9s9gVQiblB2WPf9QUnE\n"
    private var token = "T0ujFIBQH_hafCQqMSOuKQmr0EQHIXQ8OE3dylVo_ulT9SLCMfipI2Zd_lI6mbweBgu2hQh6Y2eM7yO_dONk3FKsLhrl113jZBZzBXSCtgExUG2xuAlQvWP0b9cAxfVASXfsSALH9DfxDS_R4vpJUFl8x2JJMCugMdddplZy7FWA5cyIAONAEFLBwtNnvAoTQNFlk9WkjNouaR0I0Db_jv-69uyeQDjvjAwq98am6gYBao5KG5Yxr17rhvAidGplptuVekl_h0p0zLsEmme-0NyQyGR42ROkjsBvd2KXcvY"


    companion object{
        val retrofitInstance:RetrofitFactory by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitFactory()
        }
    }


    val retrofit:Retrofit
    init {
        retrofit=Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(createOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun createOkHttpClient():OkHttpClient{
        return OkHttpClient.Builder()
            .readTimeout(Constant.TIMEOUT,TimeUnit.SECONDS)
            .writeTimeout(Constant.TIMEOUT,TimeUnit.SECONDS)
            .connectTimeout(Constant.TIMEOUT,TimeUnit.SECONDS)
            .addInterceptor(Hand_Interceptor())
            .addInterceptor(createLogInterceptor())
            .addNetworkInterceptor(createTokenInterceptor())
            .build()
    }
    private fun createTokenInterceptor():Interceptor{
        val interceptor= Interceptor {
            val request=it.request()
            var response:Response?=null
            if (token.isNotBlank()){
                response=doRequest(request,it)
                Log.e("token.isNotBlank()","133")
            }else{
                response=it.proceed(request)
                Log.e("token.isNotBlank()","456")
            }
            if (response!!.code()==401){
                requestToken()
                doRequest(request,it)
            }else{
                Log.e("bearer","bearer")
                response
            }

        }
        return interceptor
    }

    private fun setRequestHeader(request:Request,chain:Interceptor.Chain):Request{

        return request.newBuilder()
            .addHeader("Authorization","bearer $token")
            .build()
    }

    private fun doRequest(request: Request,chain: Interceptor.Chain): Response? {
        return chain.proceed(setRequestHeader(request,chain))
    }
    private fun requestToken(){
        val tokenApi:TokenApi=create(TokenApi::class.java)
        val tokenService=tokenApi.getToken("password",Constant.AUTHCODE,"")
        val result=tokenService!!.execute()
        val resultToken=result.body()!!.acess_token

        Log.e("asdfghjkl","bearer $resultToken")
        token=resultToken
    }
    private fun createLogInterceptor():Interceptor{
        val logInterceptor=HttpLoggingInterceptor()
        logInterceptor.level=HttpLoggingInterceptor.Level.BODY
        return logInterceptor
    }

    fun <T>create(service:Class<T>):T{
        return retrofit.create(service)
    }
}
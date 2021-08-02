package com.example.usercenterq.model.api
import com.example.usercenterq.protocol.req.RespGoodEntity
import com.example.net.protocol.BaseRespEntity
import com.example.usercenter.model.protocol.resp.RespTypeEntity
import com.example.usercenterq.protocol.req.UserEntitiy
import com.example.usercenterq.protocol.resp.RespUserEntity
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url


/*
/应用程序接口
 */
interface UserCenterApi {
    //注册
    @POST("api/User/register")
    fun register(@Body params: UserEntitiy):Observable<BaseRespEntity<RespUserEntity>>

    //登录
    @POST("api/User/login")
    fun login(@Body params: UserEntitiy):Observable<BaseRespEntity<RespUserEntity>>

    //商品分类
    @GET("api/GoodsType/getRecommendTypes")
    fun getRecommendType():Observable<BaseRespEntity<List<RespTypeEntity>>>
    //商品信息
    @GET()
    fun requestTB(@Url url: String):Observable<RespGoodEntity>
}
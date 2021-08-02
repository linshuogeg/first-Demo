package com.example.usercenterq.model.service

import com.example.usercenterq.protocol.req.RespGoodEntity
import com.example.net.RetrofitFactory
import com.example.net.protocol.BaseRespEntity
import com.example.usercenter.model.protocol.resp.RespTypeEntity


import com.example.usercenterq.contract.UserCenterContract
import com.example.usercenterq.model.api.UserCenterApi
import com.example.usercenterq.protocol.req.UserEntitiy
import com.example.usercenterq.protocol.resp.RespUserEntity
import io.reactivex.Observable

class UserCenterModelImpl  : UserCenterContract.UserCenterModel {
    override fun register(entiy: UserEntitiy): Observable<BaseRespEntity<RespUserEntity>> {
        val service=RetrofitFactory.retrofitInstance.create(UserCenterApi::class.java)
        return service.register(entiy)
    }

    override fun login(entiy: UserEntitiy): Observable<BaseRespEntity<RespUserEntity>> {
        val service=RetrofitFactory.retrofitInstance.create(UserCenterApi::class.java)
        return service.login(entiy)
    }
    override fun getRecommendtype(): Observable<BaseRespEntity<List<RespTypeEntity>>> {
        return RetrofitFactory.retrofitInstance
            .create(UserCenterApi::class.java)
            .getRecommendType()
    }
    override fun requestTB(page: Int): Observable<RespGoodEntity> {
        val service=RetrofitFactory.retrofitInstance.create(UserCenterApi::class.java)
        return service.requestTB("api/Goods/getRecommendGoods?page="+page+"&pagesize=30")
    }

    override fun getauthcode(): Observable<Int> {
        TODO("Not yet implemented")
    }

//    override fun getauthcode(): Observable<Int> {.
//        val service=RetrofitFactory.retrofitInstance.create(UserCenterApi::class.java)
//        return service.authcode()
//    }

}
package com.example.usercenterq.repository

import com.example.usercenterq.protocol.req.RespGoodEntity
import com.example.net.protocol.BaseRespEntity
import com.example.usercenter.model.protocol.resp.RespTypeEntity


import com.example.usercenterq.contract.UserCenterContract
import com.example.usercenterq.model.service.UserCenterModelImpl
import com.example.usercenterq.protocol.req.UserEntitiy
import com.example.usercenterq.protocol.resp.RespUserEntity
import io.reactivex.Observable

class UserCenterRepositoryImpl: UserCenterContract.UserCenterRepository() {
    override fun register(entiy: UserEntitiy): Observable<BaseRespEntity<RespUserEntity>> {
        return mModel.register(entiy)
    }

    override fun login(entiy: UserEntitiy): Observable<BaseRespEntity<RespUserEntity>> {
        return mModel.login(entiy)
    }

    override fun getRecommendtype(): Observable<BaseRespEntity<List<RespTypeEntity>>> {
        return mModel.getRecommendtype()
    }
    override fun requestTB(page: Int): Observable<RespGoodEntity> {
        return mModel.requestTB(page)
    }

    override fun creatrModel(): UserCenterContract.UserCenterModel {
       return  UserCenterModelImpl()
    }

    override fun getauthcode(): Observable<Int> {
        return mModel.getauthcode()
    }


}
package com.example.usercenterq.contract


import com.example.usercenterq.protocol.req.RespGoodEntity
import com.example.mvpkt.BasePresenter
import com.example.mvpkt.BaseRepository
import com.example.mvpkt.IModel
import com.example.mvpkt.IView
import com.example.net.protocol.BaseRespEntity
import com.example.usercenter.model.protocol.resp.RespTypeEntity
import com.example.usercenterq.model.service.UserCenterModelImpl
import com.example.usercenterq.protocol.req.UserEntitiy

import com.example.usercenterq.protocol.resp.RespUserEntity

import io.reactivex.Observable
/*
/接口层
 */
interface UserCenterContract {

    interface UserCenterModel: IModel {
        //注册业务
        fun register(entiy: UserEntitiy):Observable<BaseRespEntity<RespUserEntity>>
        //登录业务
        fun login(entiy: UserEntitiy):Observable<BaseRespEntity<RespUserEntity>>
        //分类业务
        fun getRecommendtype():Observable<BaseRespEntity<List<RespTypeEntity>>>
        fun requestTB(page: Int): Observable<RespGoodEntity>
        fun getauthcode(): Observable<Int>
    }
    abstract class UserCenterRepository: BaseRepository<UserCenterModel>(){
        //注册业务
        abstract fun register(entiy: UserEntitiy):Observable<BaseRespEntity<RespUserEntity>>
        //登录业务
        abstract fun login(entiy: UserEntitiy):Observable<BaseRespEntity<RespUserEntity>>
        //分类业务
        abstract fun getRecommendtype():Observable<BaseRespEntity<List<RespTypeEntity>>>

        abstract fun getauthcode(): Any
        //商品信息业务
        abstract fun requestTB(page: Int) :Observable<RespGoodEntity>
    }

    interface UserCenterView: IView {
        fun <T> registerSuccess(data:T)
        fun registerFailed(throwable: Throwable)
        fun getRecommendtypeSuccess(data: BaseRespEntity<List<RespTypeEntity>>)
        fun getRecommendtypeFail(throwable: Throwable)
        fun registerFaild(e: Throwable)
        //商品信息业务
        fun requestTB(data:RespGoodEntity)
    }
    abstract class UserCenterPresenter(view:UserCenterView): BasePresenter<UserCenterRepository, UserCenterView>(view){
        //注册业务
        abstract fun register(entity: UserEntitiy)
        //登录业务
        abstract fun login(entiy: UserEntitiy)
        //分类业务
        abstract fun getRecommendtype()
        abstract fun getauthcode()
        //商品信息业务
        abstract fun requestTB(page: Int):Any
    }
}
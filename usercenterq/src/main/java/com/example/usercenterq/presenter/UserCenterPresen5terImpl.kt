package com.example.usercenterq.presenter

import android.util.Log
import com.example.usercenterq.protocol.req.RespGoodEntity
import com.example.net.protocol.BaseRespEntity
import com.example.net.rxjava.BllOvserver
import com.example.net.rxjava.ObservableUtils
import com.example.usercenter.model.protocol.resp.RespTypeEntity
import com.example.usercenterq.contract.UserCenterContract
import com.example.usercenterq.protocol.req.UserEntitiy
import com.example.usercenterq.protocol.resp.RespUserEntity
import com.example.usercenterq.repository.UserCenterRepositoryImpl
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class UserCenterPresen5terImpl(_view: UserCenterContract.UserCenterView):UserCenterContract.UserCenterPresenter(_view) {
    override fun register(entity: UserEntitiy) {
      ObservableUtils.getInstance().doObservable(mRepository.register(entity),object :
      BllOvserver<BaseRespEntity<RespUserEntity>>(){
          override fun onNext(t: BaseRespEntity<RespUserEntity>) {
              super.onNext(t)
              mView.get()!!.registerSuccess(t)
          }

          override fun onError(e: Throwable) {
              super.onError(e)
              mView.get()!!.registerFailed(e)
          }
      },mView.get()!!.getLifecycleOwner())

    }

    override fun login(entiy: UserEntitiy) {
       ObservableUtils.getInstance().doObservable(mRepository.login(entiy),object :
       BllOvserver<BaseRespEntity<RespUserEntity>>(){
           override fun onNext(t: BaseRespEntity<RespUserEntity>) {
               super.onNext(t)
               mView.get()!!.registerSuccess(t)
           }

           override fun onError(e: Throwable) {
               super.onError(e)
               mView.get()!!.registerFailed(e)
           }
       },mView.get()!!.getLifecycleOwner())
    }

    override fun getRecommendtype() {
        ObservableUtils.getInstance().doObservable(mRepository.getRecommendtype(),object :BllOvserver<BaseRespEntity<List<RespTypeEntity>>>(){
            override fun onNext(t: BaseRespEntity<List<RespTypeEntity>>) {
                super.onNext(t)
                mView.get()!!.getRecommendtypeSuccess(t)
            }
            override fun onError(e: Throwable) {
                super.onError(e)
                Log.i("TAG111", "onError: "+e.message)
                Log.i("TAG111", "onError: "+e.localizedMessage)
                mView.get()!!.getRecommendtypeFail(e)
            }
        },mView.get()!!.getLifecycleOwner())
    }

    override fun getauthcode() {
        TODO("Not yet implemented")
    }

    override fun requestTB(page: Int) {
       ObservableUtils.getInstance().doObservable(mRepository.requestTB(page),object :BllOvserver<RespGoodEntity>(){
           override fun onNext(t: RespGoodEntity) {
               super.onNext(t)
               mView.get()!!.requestTB(t)
           }

           override fun onError(e: Throwable) {
               super.onError(e)
               mView.get()!!.registerFaild(e)
           }

       },mView.get()!!.getLifecycleOwner())
    }


    override fun createRepository(): UserCenterContract.UserCenterRepository {
        return UserCenterRepositoryImpl()
    }

}





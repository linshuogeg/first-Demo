package com.example.mvpkt.view


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mvpkt.common.ConstValue


abstract class BaseFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(),container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData(savedInstanceState)
        initEvent()
        if(isClearStatBar()){
            ClearStatBar()
        }

    }
    fun jumpActivity(otherActivity:Class<*>){
        startActivity(Intent(context,otherActivity))
    }

    fun jumpActivity(otherActivity:Class<*>,params:Bundle?){
        val intent: Intent = Intent(context,otherActivity)
        intent.putExtra(ConstValue.JUMP_ACTIVITY_PARAMS_KEY,params)
        startActivity(intent)
    }
    fun showMsg(msg:String){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    abstract fun initEvent()

    protected open fun isClearStatBar(): Boolean{
        return true
    }
    abstract fun initData(savedInstanceState: Bundle?)
    abstract fun ClearStatBar()
    abstract fun getLayoutId(): Int
    abstract fun releaseResource()
}

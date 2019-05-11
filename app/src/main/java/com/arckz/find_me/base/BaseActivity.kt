package com.arckz.find_me.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.arckz.find_me.util.ActivityManager
import com.gyf.immersionbar.ktx.immersionBar

/**
 * <pre>
 *
 *     author: Hy
 *     time  : 2019/05/05  下午 3:06
 *     desc  : BaseActivity
 *
 * </pre>
 */
abstract class BaseActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityManager.getInstance().addActivity(this)
        actionBar?.hide()
        initView()
        initFullScreen()
        initListener()
        initData()
    }

    private fun initFullScreen() {
        immersionBar {
            transparentBar()  //透明状态栏和导航栏
            autoDarkModeEnable(true)  //状态栏字体颜色自动切换
            statusBarDarkFont(true) //置顶状态栏颜色
            supportActionBar(true) //支持ActionBar
        }
    }

    override fun onDestroy() {
        ActivityManager.getInstance().removeActivity(this)
        super.onDestroy()
    }

    override fun onClick(v: View?) {

    }

    abstract fun initData()

    abstract fun initListener()

    abstract fun initView()


}
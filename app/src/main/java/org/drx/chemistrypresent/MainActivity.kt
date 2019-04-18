package org.drx.chemistrypresent

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : Activity(), View.OnClickListener {

    val STICK_NONE = 0
    val STICK_TAN = 1
    val STICK_TIE = 2
    val STICK_TONG = 3

    val LIQUID_NONE = 0
    val LIQUID_LVHUANA = 1
    val LIQUID_ZHETANG = 2

    var checkBtn: Button? = null
    var resetBtn: Button? = null
    var stickTan1Btn: Button? = null
    var stickTie1Btn: Button? = null
    var stickTong1Btn: Button? = null
    var stickTan2Btn: Button? = null
    var stickTie2Btn: Button? = null
    var stickTong2Btn: Button? = null
    var liquidLvhuanaBtn: Button? = null
    var liquidZhetangBtn: Button? = null
    var liquidIv: ImageView? = null
    var stick1Iv: ImageView? = null
    var stick2Iv: ImageView? = null
    var lightIv: ImageView? = null
    var stick1Value: Int = STICK_NONE
    var stick2Value: Int = STICK_NONE
    var liquidValue: Int = LIQUID_NONE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        checkBtn = findViewById(R.id.check_btn)
        resetBtn = findViewById(R.id.reset_btn)
        stickTan1Btn = findViewById(R.id.stick_tan_1)
        stickTie1Btn = findViewById(R.id.stick_tie_1)
        stickTong1Btn = findViewById(R.id.stick_tong_1)
        stickTan2Btn = findViewById(R.id.stick_tan_2)
        stickTie2Btn = findViewById(R.id.stick_tie_2)
        stickTong2Btn = findViewById(R.id.stick_tong_2)
        liquidLvhuanaBtn = findViewById(R.id.liquid_lvhuana_btn)
        liquidZhetangBtn = findViewById(R.id.liquid_zhetang_btn)
        stick1Iv = findViewById(R.id.stick_1_iv)
        stick2Iv = findViewById(R.id.stick_2_iv)
        liquidIv = findViewById(R.id.liquid_iv)
        lightIv = findViewById(R.id.light_iv)
        checkBtn?.setOnClickListener(this)
        resetBtn?.setOnClickListener(this)
        stickTan1Btn?.setOnClickListener(this)
        stickTie1Btn?.setOnClickListener(this)
        stickTong1Btn?.setOnClickListener(this)
        stickTan2Btn?.setOnClickListener(this)
        stickTie2Btn?.setOnClickListener(this)
        stickTong2Btn?.setOnClickListener(this)
        liquidLvhuanaBtn?.setOnClickListener(this)
        liquidZhetangBtn?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            checkBtn -> checkResult()
            resetBtn -> {
                hideIv(stick1Iv)
                hideIv(stick2Iv)
                hideIv(liquidIv)
                hideIv(lightIv)
            }
            stickTan1Btn -> selectStick1(STICK_TAN)
            stickTie1Btn -> selectStick1(STICK_TIE)
            stickTong1Btn -> selectStick1(STICK_TONG)
            stickTan2Btn -> selectStick2(STICK_TAN)
            stickTie2Btn -> selectStick2(STICK_TIE)
            stickTong2Btn -> selectStick2(STICK_TONG)
            liquidLvhuanaBtn -> selectLiquid(LIQUID_LVHUANA)
            liquidZhetangBtn -> selectLiquid(LIQUID_ZHETANG)
        }
    }

    fun selectStick1(value: Int) {
        if (lightIv?.visibility == View.VISIBLE) {
            Toast.makeText(this, "请重置", Toast.LENGTH_SHORT).show()
            return
        }

        stick1Value = value
        when(stick1Value) {
            STICK_TAN -> {
                stick1Iv?.setImageResource(R.mipmap.stick_tan)
                showIv(stick1Iv)
            }
            STICK_TIE -> {
                stick1Iv?.setImageResource(R.mipmap.stick_tie)
                showIv(stick1Iv)
            }
            STICK_TONG -> {
                stick1Iv?.setImageResource(R.mipmap.stick_tong)
                showIv(stick1Iv)
            }
            STICK_NONE -> {
                hideIv(stick1Iv)
            }
        }
    }

    fun selectStick2(value: Int) {
        if (lightIv?.visibility == View.VISIBLE) {
            Toast.makeText(this, "请重置", Toast.LENGTH_SHORT).show()
            return
        }

        stick2Value = value
        when (stick2Value) {
            STICK_TAN -> {
                stick2Iv?.setImageResource(R.mipmap.stick_tan)
                showIv(stick2Iv)
            }
            STICK_TIE -> {
                stick2Iv?.setImageResource(R.mipmap.stick_tie)
                showIv(stick2Iv)
            }
            STICK_TONG -> {
                stick2Iv?.setImageResource(R.mipmap.stick_tong)
                showIv(stick2Iv)
            }
            STICK_NONE -> {
                hideIv(stick2Iv)
            }
        }
    }

    fun selectLiquid(value: Int) {
        if (lightIv?.visibility == View.VISIBLE) {
            Toast.makeText(this, "请重置", Toast.LENGTH_SHORT).show()
            return
        }

        liquidValue = value
        when (liquidValue) {
            LIQUID_LVHUANA -> {
                liquidIv?.setImageResource(R.mipmap.liquid_na)
                showIv(liquidIv)
            }
            LIQUID_ZHETANG -> {
                liquidIv?.setImageResource(R.mipmap.liquid_yichun)
                showIv(liquidIv)
            }
            LIQUID_NONE -> {
                hideIv(liquidIv)
            }
        }
    }

    fun checkResult() {
        if (stick1Value == STICK_NONE) {
            Toast.makeText(this, "请选择左侧的金属棒", Toast.LENGTH_SHORT).show()
            return
        }
        if (stick2Value == STICK_NONE) {
            Toast.makeText(this, "请选择右侧的金属棒", Toast.LENGTH_SHORT).show()
            return
        }
        if (liquidValue == LIQUID_NONE) {
            Toast.makeText(this, "请选择合适的溶液", Toast.LENGTH_SHORT).show()
            return
        }
        if (stick1Value != stick2Value && liquidValue == LIQUID_LVHUANA) {
            // 灯亮
            lightIv?.setImageResource(R.mipmap.light_on)
        } else {
            // 灯不亮
            lightIv?.setImageResource(R.mipmap.light_off)
        }
        showIv(lightIv)
    }

    fun showIv(iv: ImageView?) {
        val anim = AlphaAnimation(0f, 1f)
        anim.duration = 1000
        anim.fillAfter = true
        iv?.startAnimation(anim)
        iv?.visibility = View.VISIBLE
    }

    fun hideIv(iv: ImageView?) {
        iv?.visibility = View.INVISIBLE
        iv?.clearAnimation()
    }

}
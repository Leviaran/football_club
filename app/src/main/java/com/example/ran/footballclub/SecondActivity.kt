package com.example.ran.footballclub

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class SecondActivity : AppCompatActivity() {

    companion object {
        val keteranganID = 3
        val POSITIONEXTRA = "position_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        val list = intent.getParcelableExtra<Football>(POSITIONEXTRA)

        SecondActivityUI(list).setContentView(this)

    }

    inner class SecondActivityUI(var list: Football) : AnkoComponent<SecondActivity>{

        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
        override fun createView(ui: AnkoContext<SecondActivity>) = with(ui){
            var position = 0
            linearLayout {
                orientation = LinearLayout.VERTICAL
                lparams(matchParent, matchParent)

                imageView(){
                    Glide.with(this).load(list.image).into(this)
                    id = FootballUI.imageId
                    padding = dip(10)

                    this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(dip(80), dip(80))

                textView{
                    id = FootballUI.nameId
                    text = list.nama
                    textSize = sp(10).toFloat()
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(10)
                }

                textView{
                    id = keteranganID
                    text = list.keterangan
                    gravity = Gravity.CENTER_HORIZONTAL
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    padding = dip(10)
                }

            }
        }

    }
}

package com.example.ran.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    var footballItem : MutableList<Football> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        verticalLayout {
            lparams(matchParent, matchParent)
            orientation = LinearLayout.VERTICAL

            recyclerView {
                lparams(matchParent, matchParent)
                layoutManager = LinearLayoutManager(context)
                adapter = FootballAdapter(footballItem){
                    startActivity<SecondActivity>(SecondActivity.POSITIONEXTRA to it)
                    val toast = Toast.makeText(context, it.nama, Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
        }


    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val keterangan = resources.getStringArray(R.array.club_info)

        footballItem.clear()

        for (i in name.indices){
            footballItem.add(Football(name[i], image.getResourceId(i,0), keterangan[i] ))
        }
        Log.e("info", footballItem.size.toString())

        image.recycle()

    }

}

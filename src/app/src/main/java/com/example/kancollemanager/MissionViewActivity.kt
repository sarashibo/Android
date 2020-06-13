package com.example.kancollemanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_mission_view.*

class MissionViewActivity : AppCompatActivity() {

    private var expandableView: TextView? = null
    private var Bd1expandableView: TextView? = null
    private var originalHeight = 0
    private var Bd1originalHeight = 0
    private var content: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mission_view)
        content = findViewById(R.id.content)
        expandableView = findViewById(R.id.expandable_view) as TextView
        Bd1expandableView = findViewById(R.id.Bd1expandable_view) as TextView

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        // ExpandするViewの元のサイズを保持する
        originalHeight = expandableView!!.height

        // ビューを閉じるアニメーションを生成
        val collapseAnimation =
            ResizeAnimation(expandableView!!, -expandableView!!.height, expandableView!!.height)
        collapseAnimation.duration = 300
        // ビューを開くアニメーションを生成
        val expandAnimation = ResizeAnimation(expandableView!!, originalHeight, 0)
        expandAnimation.duration = 300
        expandableView!!.startAnimation(collapseAnimation)
        button!!.setOnClickListener {
                expandableView!!.clearAnimation()
                if (expandableView!!.height > 0) {
                    expandableView!!.startAnimation(collapseAnimation)
                } else {
                    expandableView!!.startAnimation(expandAnimation)
                }
        }


        // ExpandするViewの元のサイズを保持する
        Bd1originalHeight = Bd1expandableView!!.height

        // ビューを閉じるアニメーションを生成
        val Bd1collapseAnimation = ResizeAnimation(Bd1expandableView!!, -Bd1expandableView!!.height, Bd1expandableView!!.height)
        Bd1collapseAnimation.duration = 300
        // ビューを開くアニメーションを生成
        val Bd1expandAnimation = ResizeAnimation(Bd1expandableView!!, Bd1originalHeight, 0)
        Bd1expandAnimation.duration = 300
        Bd1expandableView!!.startAnimation(Bd1collapseAnimation)

        Bd1!!.setOnClickListener {
            Bd1expandableView!!.clearAnimation()
            if (Bd1expandableView!!.height > 0) {
                Bd1expandableView!!.startAnimation(Bd1collapseAnimation)
            } else {
                Bd1expandableView!!.startAnimation(Bd1expandAnimation)
            }
        }
    }


}



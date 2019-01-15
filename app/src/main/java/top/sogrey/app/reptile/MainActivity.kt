package top.sogrey.app.reptile

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import top.sogrey.lib.reptile.Reptile
import top.sogrey.lib.reptile.bean.ImageResult
import top.sogrey.lib.reptile.listener.ImageResultListener
import top.sogrey.lib.reptile.listener.ResultListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Reptile.getImageByUrl("", object : ImageResultListener {
//            override fun result(imageList: HashSet<ImageResult>) {
//
//
//            }
//        })
//
//        Reptile.getAttributeByTag("","img", listOf("src"),object: ResultListener {
//            override fun result(list: HashSet<ArrayList<String>>) {
//            }
//        })

    }
}

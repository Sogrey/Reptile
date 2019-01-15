package top.sogrey.lib.reptile.listener

import top.sogrey.lib.reptile.bean.ImageResult

/**
 * 描述：
 * Created by Sogrey on 2019/1/15.
 */
interface ImageResultListener {
    fun result(imageList: HashSet<ImageResult>)
}
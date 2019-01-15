package top.sogrey.lib.reptile

import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread
import org.jsoup.Jsoup
import top.sogrey.lib.reptile.bean.ImageResult
import top.sogrey.lib.reptile.listener.ImageResultListener
import top.sogrey.lib.reptile.listener.ResultListener

/**
 * 描述：
 * Created by Sogrey on 2019/1/15.
 */
class Reptile {
    companion object {

        /**
         * 下载制定网站所有图片信息
         *
         * @param url 网站地址
         * @param result 数据返回
         * HashSet 自动去重
         */
        fun getImageByUrl(url: String, result: ImageResultListener) {
            val mList: HashSet<ImageResult> = HashSet()
            if (url.isEmpty()) result.result(mList)
            async {
                val doc = Jsoup.connect(url).get()
                val body = doc.body()
                body.allElements.forEach {
                    val select = it.select("img")
                    if (null != select && select.size > 0) {
                        val url = select.attr("data-original")
                        val desc = select.attr("alt")
                        var name: String = ""
                        url.split("/").forEach {
                            if (it.contains("jpg") || it.contains("png") || it.contains("bmp")
                                    || it.contains("gif") || it.contains("jpeg"))
                                name = it
                        }
                        val bean = ImageResult(name, url, desc, "")
                        mList.add(bean)
                    }
                }
                uiThread {
                    result.result(mList)
                }
            }
        }

        /**
         * 获取制定标签下的制定属性
         *
         * @param url 网站地址
         * @param result 数据返回
         * @param tag 标签 img （例如：<img />）
         * @param attribute 属性 src  （例如：<img  src=""/>）
         * HashSet 自动去重
         */
        fun getAttributeByTag(url: String, tag: String, attribute: List<String>, result: ResultListener) {

            val mList: HashSet<ArrayList<String>> = HashSet()
            if (url.isEmpty()||attribute.isEmpty()) result.result(mList)
            async {
                val doc = Jsoup.connect(url).get()
                val body = doc.body()
                body.allElements.forEach {
                    val select = it.select(tag)
                    if (null != select && select.size > 0) {
                        val mListItem: ArrayList<String> = ArrayList()
                        attribute.forEach {
                            val it = select.attr(it)
                            mListItem.add(it)
                        }

                        mList.add(mListItem)
                    }
                }
                uiThread {
                    result.result(mList)
                }
            }
        }
    }
}
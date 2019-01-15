package top.sogrey.lib.reptile.bean

/**
 * 描述：图片结果
 * Created by Sogrey on 2019/1/15.
 */
data class ImageResult(val name:String
                       ,val url:String
                       ,val desc:String
                       ,val extendOne:String){
    override fun toString(): String {
        return "ImageResult(name='$name', url='$url', desc='$desc', extendOne='$extendOne')"
    }
}
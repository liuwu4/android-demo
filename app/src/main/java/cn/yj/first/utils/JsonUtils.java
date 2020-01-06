package cn.yj.first.utils;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author liuwu4
 * 解析JSON数据
 */
public class JsonUtils {
    private String TAG = getClass().getSimpleName();
    public JSONObject analysisObject(Object object){
            JSONObject jsonObject = JSON.parseObject(object.toString());
            return jsonObject;
    }
}

package cn.yj.first.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author liuwu4
 * 解析JSON数据
 */
public class AnalysisJson {
    public JSONObject analysisObject(Object object){
            JSONObject jsonObject = JSON.parseObject(object.toString());
            return jsonObject;
    }
}

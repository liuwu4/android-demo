package cn.yj.store.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class AnalysisJson {
    public JSONObject analysisObject(Object object){
            JSONObject jsonObject = JSON.parseObject(object.toString());
            return jsonObject;
    }
}

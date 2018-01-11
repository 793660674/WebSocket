package socket.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import java.lang.reflect.Array;

/**
 * JSON转换工具类
 *
 * @author kevin
 * @date 2014-04-04
 */
public class JsonUtilTool {

    /**
     * 对象转换成JSON字符串
     *
     * @param obj
     *            需要转换的对象
     * @return 对象的string字符
     */
    public static String toJson(Object obj) {
        if(obj instanceof Array){
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
            JSONArray json = JSONArray.fromObject(obj, jsonConfig);
            return json.toString();

        }else {
            JSONObject jSONObject = JSONObject.fromObject(obj);
            return jSONObject.toString();
        }
    }

    /**
     * JSON字符串转换成对象
     *
     * @param jsonString
     *            需要转换的字符串
     * @param type
     *            需要转换的对象类型
     * @return 对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T fromJson(String jsonString, Class<T> type) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        return (T) JSONObject.toBean(jsonObject, type);
    }



}

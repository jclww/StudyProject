package com.lww.learn.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class JsonParse {
    public static void main(String[] args) {
        JSONObject jsonObject = JSONObject.parseObject(str);

        JSONArray data = (JSONArray) jsonObject.get("data");
        List<String> mounth = data.stream().map(jsonObjects -> (String) ((JSONObject) jsonObjects).get("mounth")).distinct().sorted().collect(Collectors.toList());
        List<String> subDepartment = data.stream().map(jsonObjects -> (String) ((JSONObject) jsonObjects).get("subDepartment")).distinct().sorted().collect(Collectors.toList());
        Map<Object, List<JSONObject>> mounth2Info = data.stream().collect(Collectors.toMap(jsonObjects -> ((JSONObject) jsonObjects).get("mounth").toString(),
                jsonObjects -> Lists.newArrayList((JSONObject)jsonObjects),
                (List<JSONObject> newValueList, List<JSONObject> oldValueList) -> {oldValueList.addAll(newValueList); return oldValueList;}));
        List<JSONObject> returnValue = new ArrayList<>();

        // 填充月/子部门/总量 信息
        mounth.forEach(str -> {
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("mounth", str);
            IntStream.range(0, subDepartment.size()).forEach(i -> {
                int chendan = mounth2Info.get(str).stream().
                        filter(jsonObject2 -> jsonObject2.get("subDepartment").equals(subDepartment.get(i))).
                        map(jsonObject2 -> (int)jsonObject2.get("chendan")).findFirst().orElse(0);
                jsonObject1.put("subDepartment" + i, chendan);
            });
            IntSummaryStatistics total = mounth2Info.get(str).stream().collect(Collectors.summarizingInt(jsonObject2 -> (int) jsonObject2.get("chendan")));
            jsonObject1.put("total", total.getSum());
            jsonObject1.put("growRate", 0);
            returnValue.add(jsonObject1);
        });
        // 填充增长率 从第一个开始，第0个没有比较对象
        IntStream.range(1, returnValue.size()).forEach(i -> {
            if ((long) returnValue.get(i).get("total") == 0 || (long) returnValue.get(i-1).get("total") == 0) {
                return;
            }
            returnValue.get(i).put("growRate", (long) returnValue.get(i).get("total") * 100 / (long) returnValue.get(i-1).get("total"));
        });
        // config
        JSONObject returnConfig = new JSONObject();
        JSONObject x = new JSONObject();
        x.put("variableName", "mounth");
        x.put("name", "统计时间（月）");
        returnConfig.put("x", x);
        List<JSONObject> y = new ArrayList<>();
        IntStream.range(0, subDepartment.size()).forEach(i -> {
            JSONObject tempy = new JSONObject();
            tempy.put("variableName", "subDepartment" + i);
            tempy.put("name", subDepartment.get(i));
            y.add(tempy);
        });
        JSONObject total = new JSONObject();
        total.put("variableName", "total");
        total.put("name", "总成单量（个）");
        y.add(total);

        JSONObject growRate = new JSONObject();
        total.put("variableName", "growRate");
        total.put("name", "订单环比增长率");
        y.add(growRate);
        returnConfig.put("y", y);


        System.out.println();
    }

    private static String str = "{\n" +
            "    \"msg\": \"successful\",\n" +
            "    \"code\": 200,\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "            \"mounth\": \"2018-01\",\n" +
            "            \"subDepartment\": \"子部门1\",\n" +
            "            \"chendan\": 100\n" +
            "        },\n" +
            "        {\n" +
            "            \"mounth\": \"2018-01\",\n" +
            "            \"subDepartment\": \"子部门2\",\n" +
            "            \"chendan\": 101\n" +
            "        },\n" +
            "        {\n" +
            "            \"mounth\": \"2018-01\",\n" +
            "            \"subDepartment\": \"子部门3\",\n" +
            "            \"chendan\": 33\n" +
            "        },\n" +
            "        {\n" +
            "            \"mounth\": \"2018-02\",\n" +
            "            \"subDepartment\": \"子部门1\",\n" +
            "            \"chendan\": 102\n" +
            "        },\n" +
            "        {\n" +
            "            \"mounth\": \"2018-02\",\n" +
            "            \"subDepartment\": \"子部门2\",\n" +
            "            \"chendan\": 192\n" +
            "        },\n" +
            "        {\n" +
            "            \"mounth\": \"2018-03\",\n" +
            "            \"subDepartment\": \"子部门1\",\n" +
            "            \"chendan\": 104\n" +
            "        },\n" +
            "        {\n" +
            "            \"mounth\": \"2018-03\",\n" +
            "            \"subDepartment\": \"子部门2\",\n" +
            "            \"chendan\": 12\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}

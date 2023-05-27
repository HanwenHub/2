package com.example.demo.aop;

import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class TableSchemaBuilder {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String content ="[小米,华为,jd,ali,tia]";
        String template = "insert into %s (%s) values (%s);";
        //String content = "q,m，pm,l，l，k";
        //String[] words = content.split("[,，]");
        String str = String.format("%s","user");
        List<String> str1 =gson.fromJson(content,new TypeToken<List<String>>() {}.getType());
        List<String> list = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            String randomStr = str1.get(RandomUtils.nextInt(0, str1.size()));
            System.out.println(randomStr);
        }
        TableSchema.Field field = new TableSchema.Field();
        field.setFieldType("text");
        String ss = "user";
        String sa = "name";
        String sb = String.format("%s.%s",ss,sa);

        FieldTypeEnum[] fil = FieldTypeEnum.values();
        System.out.println(sb);
        for (int i =0;i<25;i++){
            System.out.println(fil[i]);
        }
        List<String> ls = new ArrayList<>();
        ls.add("aa");
        ls.add("bb");
        ls.add("cc");
        ls.add("dd");
        List<String> lm = ls.stream().filter(l ->{return true;}).collect(Collectors.toList());
       //System.out.println(lm.toString());
        String strs = getValueStr(field,"CURRENT_TIMESTAMP");
        System.out.println(strs);
        List<Map<String,Object>> lmw = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map1 = new HashMap<>();
        map.put("username","jd");
        map.put("userid",1);
        map.put("userage",18);
        map1.put("username","jd");
        map1.put("userid",1);
        map1.put("userage",18);
        lmw.add(map);
        lmw.add(map1);
        Gson gsons = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        System.out.println(gsons.toJson(lmw));
        String mn = "user";
        String upperCamelTableName = StringUtils.capitalize(StrUtil.toCamelCase(mn));
        System.out.println(upperCamelTableName);
        List<String> sss = Arrays.stream(FieldTypeEnum.values()).map(FieldTypeEnum::getValue).collect(Collectors.toList());
        System.out.println(sss);
        Pattern pattern = Pattern.compile("[0-9]+[.]{0,1}[0-9]*[dD]{0,1}");
        Matcher isNum = pattern.matcher(str);
    }
    public static String getValueStr(TableSchema.Field field, Object value) {

        if(StringUtils.isNotBlank(field.toString())){

        }
        if (field == null || value == null) {
            return "''";
        }
        FieldTypeEnum fieldTypeEnum = Optional.ofNullable(FieldTypeEnum.getEnumByValue(field.getFieldType()))
                .orElse(FieldTypeEnum.TEXT);
        String result = String.valueOf(value);
        switch (fieldTypeEnum) {
            case DATETIME:
            case TIMESTAMP:
                return result.equalsIgnoreCase("CURRENT_TIMESTAMP") ? result : String.format("%s______________", value);
            case DATE:
            case TIME:
            case CHAR:
            case VARCHAR:
            case TINYTEXT:
            case TEXT:
                return "11111";
            case MEDIUMTEXT:
            case LONGTEXT:
            case TINYBLOB:
            case BLOB:
            case MEDIUMBLOB:
            case LONGBLOB:
            case BINARY:
            case VARBINARY:
                return String.format("%s", value);
            default:
                return result;
        }
    }
}

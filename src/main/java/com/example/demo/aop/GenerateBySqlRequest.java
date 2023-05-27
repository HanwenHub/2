package com.example.demo.aop;

import com.google.gson.Gson;
import lombok.Data;

import java.io.Serializable;

@Data
public class GenerateBySqlRequest implements Serializable {
    public static final long serializableId =1L;
    private String StrSql;
    private Gson gson = new Gson();
}

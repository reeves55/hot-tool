package com.xiaolee.hotool.bean.convert.mapper;

import java.util.HashMap;
import java.util.Map;

public class ConvertMap {
    private Map<String, String> fieldMap;

    private ConvertMap(Map<String, String> map) {
        this.fieldMap = map;
    }

    public static ConvertMapBuilder builder() {
        return new ConvertMapBuilder();
    }


    public static class ConvertMapBuilder {
        Map<String, String> fieldsMap;

        ConvertMapBuilder() {
            fieldsMap = new HashMap<String, String>(8);
        }

        public ConvertMapBuilder field(String source, String target) {
            fieldsMap.put(source, target);
            return this;
        }

        public ConvertMap build() {
            return new ConvertMap(fieldsMap);
        }
    }
}

package com.suhas.service.lookup.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class CommonUtils {

    private CommonUtils() {
    }

    public static boolean isNullOrEmpty(String string) {
        return null == string || string.isEmpty();
    }

    public static boolean isNullOrEmpty(Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    public static boolean isEmptyAndNotNull(Collection<?> collection) {
        return null != collection && collection.isEmpty();
    }

    public static boolean isNotEmptyAndNotNull(Collection<?> collection) {
        return null != collection && !collection.isEmpty();
    }

    public static boolean isNotNullOrNotEmpty(String string) {
        return null != string && !string.isEmpty();
    }

    public static boolean isNotNull(Iterable<?> iterable) {
        return null != iterable;
    }

    public static boolean isNotEmptyAndNotNull(Map<?, ?> map) {
        return null != map && !map.isEmpty();
    }

    public static <T> boolean isNotNull(T t) {
        return null != t;
    }

    public static <T> T generatePOJOFromJSON(Class<T> classType, String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            return mapper.readValue(jsonString, classType);
        } catch (JsonParseException var4) {
            var4.printStackTrace();
            throw var4;
        } catch (JsonMappingException var5) {
            var5.printStackTrace();
            throw var5;
        } catch (IOException var6) {
            var6.printStackTrace();
            throw var6;
        }
    }

}

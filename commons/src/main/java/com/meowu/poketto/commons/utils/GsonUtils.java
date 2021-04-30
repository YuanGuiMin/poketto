package com.meowu.poketto.commons.utils;

import com.google.gson.*;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;

public class GsonUtils{

    private static final Gson GSON = getGson();

    public static String serialize(Object writer){
        return serialize(GSON, writer);
    }

    public static String serialize(Gson gson, Object writer){
        if(gson == null){
            gson = GSON;
        }

        return gson.toJson(writer);
    }

    public static <T> T deserialize(String reader, Class<T> clazz){
        return deserialize(GSON, reader, clazz);
    }

    public static <T> T deserialize(String reader, Type type){
        return deserialize(GSON, reader, type);
    }

    public static <T> T deserialize(Gson gson, String reader, Class<T> clazz){
        AssertUtils.notNull(clazz, "object deserialization class must not be null");

        if(gson == null){
            gson = GSON;
        }

        return gson.fromJson(reader, clazz);
    }

    public static <T> T deserialize(Gson gson, String reader, Type type){
        AssertUtils.notNull(type, "object deserialization type must not be null");

        if(gson == null){
            gson = GSON;
        }

        return gson.fromJson(reader, type);
    }

    public static Gson getGson(){
        return getGson(false, false, true, null);
    }

    public static Gson getGson(boolean serializeNulls, boolean escapeHtmlChars, boolean timestamp, String datePattern){
        return getBuilder(serializeNulls, escapeHtmlChars, timestamp, datePattern).create();
    }

    private static GsonBuilder getBuilder(boolean serializeNulls, boolean escapeHtmlChars, boolean timestamp, String datePattern){
        GsonBuilder builder = new GsonBuilder();

        if(serializeNulls){
            builder.serializeNulls();
        }
        if(!escapeHtmlChars){
            builder.disableHtmlEscaping();
        }
        if(timestamp){
            builder.registerTypeAdapter(Date.class, new DateDeserializer())
                   .registerTypeAdapter(Date.class, new DateSerializer())
                   .setDateFormat(DateFormat.LONG);
        }
        if(!timestamp && StringUtils.isNotBlank(datePattern)){
            builder.setDateFormat(datePattern);
        }

        return builder;
    }

    private static class DateDeserializer implements JsonDeserializer<Date>{

        @Override
        public Date deserialize(JsonElement element, Type typeOf, JsonDeserializationContext context) throws JsonParseException{
            return new Date(element.getAsJsonPrimitive().getAsLong());
        }
    }

    private static class DateSerializer implements JsonSerializer<Date>{

        @Override
        public JsonElement serialize(Date date, Type typeOf, JsonSerializationContext context){
            return new JsonPrimitive(date.getTime());
        }
    }
}

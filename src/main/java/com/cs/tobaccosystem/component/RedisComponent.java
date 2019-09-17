package com.cs.tobaccosystem.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RedisComponent {
    private static final Logger logger = LoggerFactory.getLogger(RedisComponent.class);

    @Autowired
    private StringRedisTemplate template;

    public <T> void set(String key,T value) throws JsonProcessingException{
        ValueOperations<String,String> ops = this.template.opsForValue();

        ObjectMapper mapper = new ObjectMapper();
        if(!this.template.hasKey(key)){
            String str = mapper.writeValueAsString(value);
            ops.set(key,str);
            logger.info(key + " set succeed\n");
        }else {
            logger.info(key + " already exist\n");
        }
    }

    public <T> T get(String key,Class<T> clazz) throws IOException{
        String str = this.template.opsForValue().get(key);
        T tobacco = null;
        if(str!=null){
            ObjectMapper mapper = new ObjectMapper();
            tobacco = mapper.readValue(str,clazz);
        }
        return tobacco;
    }

    public void del(String key){
        this.template.delete(key);
    }
}

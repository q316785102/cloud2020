package com.qiuxj.springcloud.service;

import com.qiuxj.springcloud.entities.UserEntity;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
@Component
public class StreamProvideService {
    @Resource
    private MessageChannel output;
    public boolean sendMessage(){
        UserEntity entity = new UserEntity();
        entity.setAge(18);
        entity.setId("123");
        entity.setName(UUID.randomUUID().toString());
        System.out.println(entity.toString());
        return output.send(MessageBuilder.withPayload(entity).build());
    }
}

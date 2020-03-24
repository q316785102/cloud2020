package springcloud.service;

import com.qiuxj.springcloud.entities.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
public class StreamConsumerService {
    @Value("${server.port}")
    String serverPort;
    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<UserEntity> message){
        System.out.println(serverPort+"receive message : "+message.getPayload()==null?"null":message.getPayload().toString());
    }
}

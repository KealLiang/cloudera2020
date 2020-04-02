package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author lsr
 * @ClassName ReciveMsgListenerController
 * @Date 2020-04-02
 * @Vertion 1.0
 */
@Component
@EnableBinding(Sink.class)
public class ReciveMsgListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void recive(Message<String> msg) {
        System.out.println(String.format("消费者2号，接收到消息：[%s] port：%s", msg.getPayload(), serverPort));
    }
}

package com.kealliang.springcloud.service.impl;

import cn.hutool.core.lang.UUID;
import com.kealliang.springcloud.service.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author lsr
 * @ClassName MessageProviderImpl
 * @Date 2020-04-02
 * @Vertion 1.0
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements MessageProvider {

    // 这里用@Autowired会找不到，待排查
    @Resource
    private MessageChannel output; // 消息发送管道，这个管道是固定要命名成output，否则Controller注入会失败

    @Override
    public String sendMsg(String msg) {
        String message = UUID.fastUUID().toString().concat(": ").concat(msg);
        System.out.println(String.format("=生产者=发送消息：[%s]", message));
        boolean send = output.send(MessageBuilder.withPayload(message).build());
        return String.valueOf(send);
    }
}

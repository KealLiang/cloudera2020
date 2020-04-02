package com.kealliang.springcloud.controller;

import com.kealliang.springcloud.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lsr
 * @ClassName MessageController
 * @Date 2020-04-02
 * @Vertion 1.0
 */
@RestController
public class MessageController {

    @Autowired
    private MessageProvider messageProvider;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("sendMsg")
    public String sendMsg() {
        return messageProvider.sendMsg(serverPort);
    }
}

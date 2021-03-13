package com.my.config.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wt on 2017/12/7.
 */
@Component
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        LOGGER.info("Received：{}",message);
        latch.countDown();
    }

    /**
     * 其中，它有CountDownLatch这样的一个类，它是用于告诉发送者消息已经收到了，
     * 你不需要在应用程序中具体实现它，只需要latch.countDown()就行了
     * @return
     */
    public CountDownLatch getLatch() {
        return latch;
    }
}

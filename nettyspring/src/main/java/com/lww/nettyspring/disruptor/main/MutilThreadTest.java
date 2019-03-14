package com.lww.nettyspring.disruptor.main;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ThreadFactory;

public class MutilThreadTest {
    /**
     * 消息事件类
     */
    public static class MessageEvent {
        /**
         * 原始消息
         */
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    /**
     * 消息事件工厂类
     */
    public static class MessageEventFactory implements EventFactory<DisruptorTest.MessageEvent> {
        @Override
        public DisruptorTest.MessageEvent newInstance() {
            return new DisruptorTest.MessageEvent();
        }
    }

    /**
     * 消息转换类，负责将消息转换为事件
     */
    public static class MessageEventTranslator implements EventTranslatorOneArg<DisruptorTest.MessageEvent, String> {
        @Override
        public void translateTo(DisruptorTest.MessageEvent messageEvent, long l, String s) {
            messageEvent.setMessage(s);
        }
    }

    /**
     * 消费者线程工厂类
     */
    public static class MessageThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "Simple Disruptor Test Thread");
        }
    }

    /**
     * 消息事件处理类，这里只打印消息
     */
    public static class MessageEventHandler implements EventHandler<DisruptorTest.MessageEvent> {
        @Override
        public void onEvent(DisruptorTest.MessageEvent messageEvent, long l, boolean b) throws Exception {
            System.out.println(messageEvent.getMessage());
        }
    }

    /**
     * 异常处理类
     */
    public static class MessageExceptionHandler implements ExceptionHandler<DisruptorTest.MessageEvent> {
        @Override
        public void handleEventException(Throwable ex, long sequence, DisruptorTest.MessageEvent event) {
            ex.printStackTrace();
        }

        @Override
        public void handleOnStartException(Throwable ex) {
            ex.printStackTrace();

        }

        @Override
        public void handleOnShutdownException(Throwable ex) {
            ex.printStackTrace();

        }
    }

    /**
     * 消息生产者类
     */
    public static class MessageEventProducer {
        private RingBuffer<DisruptorTest.MessageEvent> ringBuffer;

        public MessageEventProducer(RingBuffer<DisruptorTest.MessageEvent> ringBuffer) {
            this.ringBuffer = ringBuffer;
        }

        /**
         * 将接收到的消息输出到ringBuffer
         *
         * @param message
         */
        public void onData(String message) {
            EventTranslatorOneArg<DisruptorTest.MessageEvent, String> translator = new DisruptorTest.MessageEventTranslator();
            ringBuffer.publishEvent(translator, message);
        }
    }

    public static void main(String[] args) {
        String message = "Hello Disruptor!";
        int ringBufferSize = 8;//必须是2的N次方
        Disruptor<DisruptorTest.MessageEvent> disruptor = new Disruptor<DisruptorTest.MessageEvent>(new DisruptorTest.MessageEventFactory(),
                ringBufferSize,
                new DisruptorTest.MessageThreadFactory(),
                ProducerType.MULTI,
                new BlockingWaitStrategy());
        disruptor.handleEventsWith(new DisruptorTest.MessageEventHandler(), new DisruptorTest.MessageEventHandler());
//        disruptor.handle
        disruptor.setDefaultExceptionHandler(new DisruptorTest.MessageExceptionHandler());
        RingBuffer<DisruptorTest.MessageEvent> ringBuffer = disruptor.start();
        DisruptorTest.MessageEventProducer producer = new DisruptorTest.MessageEventProducer(ringBuffer);
        for (int i = 0; i < 100; i++) {
            producer.onData(message + i);
        }
        disruptor.shutdown();
    }
}

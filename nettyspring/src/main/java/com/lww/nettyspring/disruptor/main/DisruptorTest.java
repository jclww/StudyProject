package com.lww.nettyspring.disruptor.main;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DisruptorTest {
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
    public static class MessageEventFactory implements EventFactory<MessageEvent> {
        @Override
        public MessageEvent newInstance() {
            return new MessageEvent();
        }
    }

    /**
     * 消息转换类，负责将消息转换为事件
     */
    public static class MessageEventTranslator implements EventTranslatorOneArg<MessageEvent, String> {
        @Override
        public void translateTo(MessageEvent messageEvent, long l, String s) {
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
    public static class MessageEventHandler implements EventHandler<MessageEvent> {
        @Override
        public void onEvent(MessageEvent messageEvent, long l, boolean b) throws Exception {
            System.out.println(messageEvent.getMessage());
        }
    }

    /**
     * 异常处理类
     */
    public static class MessageExceptionHandler implements ExceptionHandler<MessageEvent> {
        @Override
        public void handleEventException(Throwable ex, long sequence, MessageEvent event) {
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
        private RingBuffer<MessageEvent> ringBuffer;

        public MessageEventProducer(RingBuffer<MessageEvent> ringBuffer) {
            this.ringBuffer = ringBuffer;
        }

        /**
         * 将接收到的消息输出到ringBuffer
         *
         * @param message
         */
        public void onData(String message) {
            EventTranslatorOneArg<MessageEvent, String> translator = new MessageEventTranslator();
            ringBuffer.publishEvent(translator, message);
        }
    }

    public static void main(String[] args) {
        String message = "Hello Disruptor!";
        int ringBufferSize = 8;//必须是2的N次方
        Disruptor<MessageEvent> disruptor = new Disruptor<MessageEvent>(new MessageEventFactory(),
                ringBufferSize,
                new MessageThreadFactory(),
                ProducerType.SINGLE,
                new BlockingWaitStrategy());
        disruptor.handleEventsWith(new MessageEventHandler(), new MessageEventHandler());
//        disruptor.handle
        disruptor.setDefaultExceptionHandler(new MessageExceptionHandler());
        RingBuffer<MessageEvent> ringBuffer = disruptor.start();
        MessageEventProducer producer = new MessageEventProducer(ringBuffer);
        for (int i = 0; i < 100; i++) {
            producer.onData(message + i);
        }
        disruptor.shutdown();
    }

    public static void main2(String[] args) {
//        Executor executor = Executors.newCachedThreadPool();
//        BatchHandler handler1 = new MyBatchHandler1();
//        BatchHandler handler2 = new MyBatchHandler2();
//        BatchHandler handler3 = new MyBatchHandler3()
//        RingBuffer ringBuffer = new RingBuffer(ENTRY_FACTORY, RING_BUFFER_SIZE);
//        ConsumerBarrier consumerBarrier1 = ringBuffer.createConsumerBarrier();
//        BatchConsumer consumer1 = new BatchConsumer(consumerBarrier1, handler1);
//        BatchConsumer consumer2 = new BatchConsumer(consumerBarrier1, handler2);
//        ConsumerBarrier consumerBarrier2 =
//                ringBuffer.createConsumerBarrier(consumer1, consumer2);
//        BatchConsumer consumer3 = new BatchConsumer(consumerBarrier2, handler3);
//        executor.execute(consumer1);
//        executor.execute(consumer2);
//        executor.execute(consumer3);
//        ProducerBarrier producerBarrier =
//                ringBuffer.createProducerBarrier(consumer3);
    }
}
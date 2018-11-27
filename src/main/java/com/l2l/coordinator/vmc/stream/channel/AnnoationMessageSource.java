package com.l2l.annotation.processor.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface AnnoationMessageSource {
    String ANNOTATION_CHANNEL_CONSUMER = "annotation-channel-consumer";


    @Input(ANNOTATION_CHANNEL_CONSUMER)
    SubscribableChannel annotationConsumer();
//    @Output(ANNOTATION_CHANNEL_PRODUCER)
//    MessageChannel annotationProducer();
//    @Output(ANNOTATION_CHANNEL_RESPONSE)
//    MessageChannel annotationResponse();

}

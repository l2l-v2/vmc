package com.l2l.annotation.processor.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface AnnoationResponseSink {
    String ANNOTATION_CHANNEL_RESPONSE = "annotation-channel-response";

    @Input(ANNOTATION_CHANNEL_RESPONSE)
    SubscribableChannel annotationResponse();

}

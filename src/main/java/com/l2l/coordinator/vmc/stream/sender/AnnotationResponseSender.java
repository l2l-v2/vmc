package com.l2l.annotation.processor.stream.sender;

import com.l2l.annotation.processor.stream.channel.AnnoationResponseSink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.xnio.channels.MessageChannel;

import java.io.IOException;
import java.nio.ByteBuffer;
@EnableBinding(value = {AnnoationResponseSink.class})
public class AnnotationResponseSender {
    @Autowired
    private AnnoationResponseSink annoationResponseSink ;

    public void annotationSend (String annotationText) throws IOException {
        annoationResponseSink.annotationResponse().send(MessageBuilder.withPayload("produce a message to  channel" + annotationText).build());
    }

}

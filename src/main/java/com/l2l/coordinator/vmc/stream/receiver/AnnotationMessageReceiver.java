package com.l2l.annotation.processor.stream.receiver;

import com.l2l.annotation.processor.stream.channel.AnnoationMessageSource;
import com.l2l.annotation.processor.stream.sender.AnnotationResponseSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.io.IOException;

@EnableBinding(value = {Sink.class,AnnoationMessageSource.class})
public class AnnotationMessageReceiver {
    @Autowired
    AnnotationResponseSender annotationResponseSender;
    private static Logger logger = LoggerFactory.getLogger(AnnotationMessageReceiver.class);
    @StreamListener(AnnoationMessageSource.ANNOTATION_CHANNEL_CONSUMER)
    public void receive(String annotationText) throws IOException {
        logger.info("Received from default annotationchannel : {}", annotationText);
        annotationResponseSender.annotationSend("hello");
    }
}



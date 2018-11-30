package com.l2l.coordinator.vmc.connectors.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.l2l.coordinator.vmc.connectors.channels.AnnotationMessageChannels;
import com.l2l.coordinator.vmc.connectors.channels.IntegrationConnector;
import com.l2l.coordinator.vmc.connectors.configuration.ConnectorProperties;
import org.activiti.cloud.api.process.model.IntegrationRequest;
import org.activiti.cloud.api.process.model.IntegrationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@EnableBinding(AnnotationMessageChannels.class)
public class IntegtrationConnectorImpl implements IntegrationConnector {
    private final IntegrationResultSender integrationResultSender;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private ConnectorProperties connectorProperties;

    public IntegtrationConnectorImpl(IntegrationResultSender integrationResultSender) {
        this.integrationResultSender = integrationResultSender;
    }

    @StreamListener(value = AnnotationMessageChannels.ANNOTAION_CONSUMER)
    public void rewardTopRankedUsers(IntegrationRequest event) {
        // business logic goes here​

        //  build and send result back
        Map<String, Object> results = new HashMap<>();
        results.put("rewards", "test");
        Message<IntegrationResult> message = IntegrationResultBuilder.resultFor(event,
            connectorProperties)
            .withOutboundVariables(results)
            .buildMessage();

        integrationResultSender.send(message);
    }
}

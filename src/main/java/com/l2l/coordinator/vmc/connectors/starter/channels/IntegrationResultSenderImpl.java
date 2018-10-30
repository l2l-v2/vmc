package com.l2l.coordinator.vmc.connectors.starter.channels;

import org.activiti.cloud.api.process.model.IntegrationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.binding.BinderAwareChannelResolver;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class IntegrationResultSenderImpl implements IntegrationResultSender {
    @Value("${ACT_INT_RES_CONSUMER:}")
    private String resultDestinationOverride;
    private final BinderAwareChannelResolver resolver;

    @Autowired
    public IntegrationResultSenderImpl(BinderAwareChannelResolver resolver) {
        this.resolver = resolver;
    }

    public void send(Message<IntegrationResult> message) {
        String destination = this.resultDestinationOverride != null && !this.resultDestinationOverride.isEmpty() ? this.resultDestinationOverride : "integrationResult:" + ((IntegrationResult)message.getPayload()).getIntegrationRequest().getServiceFullName();
        this.resolver.resolveDestination(destination).send(message);
    }
}
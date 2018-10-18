package com.l2l.coordinator.vmc.connectors.starter.model;

import com.l2l.coordinator.vmc.connectors.starter.configuration.ConnectorProperties;
import org.activiti.cloud.api.process.model.IntegrationRequest;
import org.activiti.cloud.api.process.model.IntegrationResult;
import org.activiti.cloud.api.process.model.impl.IntegrationResultImpl;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;

public class IntegrationResultBuilder {
    private IntegrationRequest requestEvent;
    private IntegrationResultImpl integrationResult;

    private IntegrationResultBuilder(IntegrationRequest integrationRequest, ConnectorProperties connectorProperties) {
        this.requestEvent = integrationRequest;
        this.integrationResult = new IntegrationResultImpl(integrationRequest, integrationRequest.getIntegrationContext());
        if (connectorProperties != null) {
            this.integrationResult.setAppName(connectorProperties.getAppName());
            this.integrationResult.setAppVersion(connectorProperties.getAppVersion());
            this.integrationResult.setServiceFullName(connectorProperties.getServiceFullName());
            this.integrationResult.setServiceType(connectorProperties.getServiceType());
            this.integrationResult.setServiceVersion(connectorProperties.getServiceVersion());
            this.integrationResult.setServiceName(connectorProperties.getServiceName());
        }

    }

    public static IntegrationResultBuilder resultFor(IntegrationRequest integrationRequest, ConnectorProperties connectorProperties) {
        return new IntegrationResultBuilder(integrationRequest, connectorProperties);
    }

    public IntegrationResultBuilder withOutboundVariables(Map<String, Object> variables) {
        this.integrationResult.getIntegrationContext().addOutBoundVariables(variables);
        return this;
    }

    public IntegrationResult build() {
        return this.integrationResult;
    }

    public Message<IntegrationResult> buildMessage() {
        return this.getMessageBuilder().build();
    }

    public MessageBuilder<IntegrationResult> getMessageBuilder() {
        // @bqzhu : cast 'this.integrationResult to IntegrationResult Type
        return MessageBuilder.withPayload((IntegrationResult)this.integrationResult).setHeader("targetService", this.requestEvent.getServiceFullName());
    }
}

package com.l2l.coordinator.vmc.connectors.model;

import com.l2l.coordinator.vmc.connectors.annotatoionDomain.AnnotationIntegrationRequestImpl;
import com.l2l.coordinator.vmc.connectors.annotatoionDomain.AnnotationIntegrationResultImpl;
import com.l2l.coordinator.vmc.connectors.configuration.ConnectorProperties;
import org.activiti.cloud.api.process.model.IntegrationRequest;
import org.activiti.cloud.api.process.model.IntegrationResult;
import org.activiti.cloud.api.process.model.impl.IntegrationResultImpl;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;

public class AnnotationIntegrationResultBuilder {
    private AnnotationIntegrationRequestImpl requestEvent;
    private AnnotationIntegrationResultImpl annotationIntegrationResult;

    private AnnotationIntegrationResultBuilder(AnnotationIntegrationRequestImpl integrationRequest, ConnectorProperties connectorProperties) {
        this.requestEvent = integrationRequest;
        this.annotationIntegrationResult = new AnnotationIntegrationResultImpl(integrationRequest, integrationRequest.getAnnotationIntergrationContext());
        if (connectorProperties != null) {
            this.annotationIntegrationResult.setAppName(connectorProperties.getAppName());
            this.annotationIntegrationResult.setAppVersion(connectorProperties.getAppVersion());
            this.annotationIntegrationResult.setServiceFullName(connectorProperties.getServiceFullName());
            this.annotationIntegrationResult.setServiceType(connectorProperties.getServiceType());
            this.annotationIntegrationResult.setServiceVersion(connectorProperties.getServiceVersion());
            this.annotationIntegrationResult.setServiceName(connectorProperties.getServiceName());
        }

    }

    public static AnnotationIntegrationResultBuilder resultFor(AnnotationIntegrationRequestImpl integrationRequest, ConnectorProperties connectorProperties) {
        return new AnnotationIntegrationResultBuilder(integrationRequest, connectorProperties);
    }

    public AnnotationIntegrationResultBuilder withOutboundVariables(Map<String, Object> variables) {
        this.annotationIntegrationResult.getIntegrationContext().addOutBoundVariables(variables);
        return this;
    }

    public IntegrationResult build() {
        return this.annotationIntegrationResult;
    }

    public Message<IntegrationResult> buildMessage() {
        return this.getMessageBuilder().build();
    }

    public MessageBuilder<IntegrationResult> getMessageBuilder() {
        // @bqzhu : cast 'this.integrationResult to IntegrationResult Type
        return MessageBuilder.withPayload((IntegrationResult)this.annotationIntegrationResult).setHeader("targetService", this.requestEvent.getServiceFullName());
    }
}

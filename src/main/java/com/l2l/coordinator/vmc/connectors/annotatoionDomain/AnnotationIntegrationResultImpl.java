package com.l2l.coordinator.vmc.connectors.annotatoionDomain;

import org.activiti.api.process.model.IntegrationContext;
import org.activiti.cloud.api.model.shared.impl.CloudRuntimeEntityImpl;
import org.activiti.cloud.api.process.model.IntegrationRequest;
import org.activiti.cloud.api.process.model.IntegrationResult;

public class AnnotationIntegrationResultImpl extends CloudRuntimeEntityImpl implements IntegrationResult {
    private AnnotationIntegrationRequestImpl annotationIntegrationRequest;
    private IntegrationContext integrationContext;

    public AnnotationIntegrationResultImpl() {
    }

    public AnnotationIntegrationResultImpl(AnnotationIntegrationRequestImpl integrationRequest, IntegrationContext integrationContext) {
        this.annotationIntegrationRequest = integrationRequest;
        this.integrationContext = integrationContext;
    }

    public IntegrationContext getIntegrationContext() {
        return this.integrationContext;
    }

    @Override
    public IntegrationRequest getIntegrationRequest() {
        return this.annotationIntegrationRequest;
    }

    public AnnotationIntegrationRequestImpl getAnnotationIntegrationRequest() {
        return annotationIntegrationRequest;
    }

    public void setAnnotationIntegrationRequest(AnnotationIntegrationRequestImpl annotationIntegrationRequest) {
        this.annotationIntegrationRequest = annotationIntegrationRequest;
    }

    public void setIntegrationContext(IntegrationContext integrationContext) {
        this.integrationContext = integrationContext;
    }
}

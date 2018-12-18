package com.l2l.coordinator.vmc.connectors.annotatoionDomain;


import org.activiti.api.process.model.IntegrationContext;
import org.activiti.cloud.api.model.shared.impl.CloudRuntimeEntityImpl;
import org.activiti.cloud.api.process.model.IntegrationRequest;

public class AnnotationIntegrationRequestImpl extends CloudRuntimeEntityImpl implements IntegrationRequest {
    private AnnotationIntergrationContextImpl annotationIntergrationContext;

    public AnnotationIntegrationRequestImpl() {
    }

    public AnnotationIntegrationRequestImpl(AnnotationIntergrationContextImpl annotationIntergrationContext) {
        this.annotationIntergrationContext = annotationIntergrationContext;
    }

    public AnnotationIntergrationContextImpl getAnnotationIntergrationContext() {
        return this.annotationIntergrationContext;
    }

    @Override
    public IntegrationContext getIntegrationContext() {
        return null;
    }


}

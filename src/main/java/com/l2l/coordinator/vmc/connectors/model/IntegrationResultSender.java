package com.l2l.coordinator.vmc.connectors.model;


import org.activiti.cloud.api.process.model.IntegrationResult;
import org.springframework.messaging.Message;

public interface IntegrationResultSender {
    void send(Message<IntegrationResult> var1);
}


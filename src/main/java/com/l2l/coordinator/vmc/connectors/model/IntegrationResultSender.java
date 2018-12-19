package com.l2l.coordinator.vmc.connectors.model;


import org.activiti.runtime.api.model.IntegrationResult;
import org.springframework.messaging.Message;

public interface IntegrationResultSender {
    void send(Message<IntegrationResult> var1);
}


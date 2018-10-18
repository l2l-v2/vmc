package com.l2l.coordinator.vmc.connectors.starter.channels;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({ProcessRuntimeChannels.class})
public class CloudConnectorIntegrationHandler {
    public CloudConnectorIntegrationHandler() {
    }
}

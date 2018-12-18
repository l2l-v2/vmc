package com.l2l.coordinator.vmc.extension.activiti.form;

public interface FormService  {
    FormDefinition getStartForm(String processDefinitionId);
    FormDefinition getUserTaskForm(String processDefinitionId, String taskDefinitionKey);
}

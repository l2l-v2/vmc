package com.l2l.coordinator.vmc.extension.activiti.annotation;


import com.l2l.coordinator.vmc.extension.activiti.boot.L2LProcessEngineConfiguration;
import com.l2l.coordinator.vmc.extension.activiti.model.Annotation;

import java.util.List;

public interface AnnotationService {
    List<Annotation>  getActivityAnnotations(String processDefinitionId, String targetElementId);

    List<Annotation> getMsgAnnotations(String processDefinitionId);

    List<Annotation> getAllActivitiesAnnotations(String processDefinitionId);

    L2LProcessEngineConfiguration getL2LProcessEngineConfiguration();
}

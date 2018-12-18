package com.l2l.coordinator.vmc.extension.activiti.annotation;


import com.l2l.coordinator.vmc.extension.activiti.boot.L2LProcessEngineConfiguration;
import com.l2l.coordinator.vmc.extension.activiti.model.Annotation;

import java.util.List;

public interface AnnotationManager  {

    L2LProcessEngineConfiguration getProcessEngineConfiguration();

   void setProcessEngineConfiguration(L2LProcessEngineConfiguration processEngineConfiguration);

   List<Annotation> getAnnotations();

   void setAnnotations(List<Annotation> annotations);

   void setBehavior(Object behavior);

   Object getBehavior();

}

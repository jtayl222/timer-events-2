package com.myspace.timer_events_2;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogWorkitemHandler implements WorkItemHandler {
    private static final Logger logger = LoggerFactory.getLogger(LogWorkitemHandler.class);

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        logger.debug("Execute logger work item");
        logger.info("Logger work item with message: {}", workItem.getParameter("Message"));
        manager.completeWorkItem(workItem.getId(), null);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        logger.warn("ABORTED WORK ITEM");
    }
    
}
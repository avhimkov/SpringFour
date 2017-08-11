package ср18;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

public class StepExecutionStatsListener extends StepExecutionListenerSupport{
    @Override
    public ExitStatus afterStep(StepExecution stepExecution){
        System.out.println("Wrote: " + stepExecution.getWriteCount()+" item in step: " + stepExecution.getStepName());
        return null;
    }
}

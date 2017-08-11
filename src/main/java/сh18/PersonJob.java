package сh18;

import org.springframework.batch.core.jsr.launch.JsrJobOperator;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.JobExecution;
import java.util.Properties;

public class PersonJob {
    public static void main(String[] args) throws Exception {
        JsrJobOperator jobJobOperator = new JsrJobOperator();
        long executionId = jobJobOperator.start("personJob", new Properties());
        JobExecution jobExecution = jobJobOperator.getJobExecution(executionId);
        waitForJob(jobJobOperator, jobExecution);
    }

    private static void waitForJob(
            JsrJobOperator jobJobOperator, JobExecution jobExecution){
        BatchStatus batchStatus = jobExecution.getBatchStatus();

        while (true){
            if (batchStatus==BatchStatus.STOPPED || batchStatus == BatchStatus.COMPLETED || batchStatus == BatchStatus.FAILED){
                return;
            }

            jobExecution = jobJobOperator.getJobExecution(jobExecution.getExecutionId());
            batchStatus = jobExecution.getBatchStatus();
        }
    }
}

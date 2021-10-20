package tasks;

import trace.TraceResult;
import trace.Tracer;

import java.util.concurrent.Callable;

public class TaskExecutorFirst implements Callable<TraceResult> {
    private final Tracer tracer;
    private final MainTask mainTask;

    public TaskExecutorFirst(Tracer tracer) {
        this.tracer = tracer;
        this.mainTask = new MainTask(tracer);
    }

    @Override
    public TraceResult call(){
        tracer.getTraceResult().setThreadId(Thread.currentThread().getId());
        tracer.startTrace();

        mainTask.calculateManyNumbers();
        mainTask.calculateBitOfNumbers();

        tracer.stopTrace();
        return tracer.getTraceResult();
    }
}

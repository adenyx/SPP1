package trace;

import reflect.CustomMethod;

import java.util.ArrayList;

public class TraceImplementation implements Tracer{
    private long startTime;
    private long endTime;
    private TraceResult traceResult;

    public TraceImplementation() {
        traceResult = new TraceResult();
        traceResult.setCustomMethods(new ArrayList<>());
    }

    @Override
    public void startTrace() {
        startTime = System.nanoTime();
    }

    @Override
    public void stopTrace() {
        endTime = System.nanoTime();
        traceResult.setNanoseconds(endTime - startTime);
    }

    @Override
    public TraceResult getTraceResult() {
        return traceResult;
    }

    @Override
    public void addMethodToResult(CustomMethod customMethod){
        traceResult.addMethod(customMethod);
    }
}

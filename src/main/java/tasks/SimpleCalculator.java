package tasks;

import reflect.CustomMethod;
import trace.TraceImplementation;
import trace.Tracer;

public class SimpleCalculator {

    public final CustomMethod method;

    public SimpleCalculator(CustomMethod method) {
        this.method = method;
    }

    public void calculateTwentyNumbersSum(){
        CustomMethod customMethod = new CustomMethod(new Object(){}.getClass().getEnclosingMethod());
        Tracer tracerForCurrentMethod = new TraceImplementation();
        tracerForCurrentMethod.startTrace();

        int sum = 0;
        for (int i = 0; i < 20; i++) {
            sum += i;
        }

        tracerForCurrentMethod.stopTrace();
        customMethod.setNanoseconds(tracerForCurrentMethod.getTraceResult().getNanoseconds());
        method.addMethod(customMethod);
    }

    public void calculateTwoMillionNumbersSum(){
        CustomMethod customMethod = new CustomMethod(new Object(){}.getClass().getEnclosingMethod());
        Tracer tracerForCurrentMethod = new TraceImplementation();
        tracerForCurrentMethod.startTrace();

        int sum = 0;
        for (int i = 0; i < 2_000_000; i++) {
            sum += i;
        }

        tracerForCurrentMethod.stopTrace();
        customMethod.setNanoseconds(tracerForCurrentMethod.getTraceResult().getNanoseconds());
        method.addMethod(customMethod);
    }

    public void calculateTwentyThousandNumbersSum(){
        CustomMethod customMethod = new CustomMethod(new Object(){}.getClass().getEnclosingMethod());
        Tracer tracerForCurrentMethod = new TraceImplementation();
        tracerForCurrentMethod.startTrace();

        int sum = 0;
        for (int i = 0; i < 20_000; i++) {
            sum += i;
        }

        tracerForCurrentMethod.stopTrace();
        customMethod.setNanoseconds(tracerForCurrentMethod.getTraceResult().getNanoseconds());
        method.addMethod(customMethod);
    }

}

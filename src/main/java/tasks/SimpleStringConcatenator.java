package tasks;

import reflect.CustomMethod;
import trace.TraceImplementation;
import trace.Tracer;

public class SimpleStringConcatenator {

    public final CustomMethod method;

    public SimpleStringConcatenator(CustomMethod method) {
        this.method = method;
    }

    public void concatenateTwentyTimes(){
        CustomMethod customMethod = new CustomMethod(new Object(){}.getClass().getEnclosingMethod());
        Tracer tracerForCurrentMethod = new TraceImplementation();
        tracerForCurrentMethod.startTrace();

        String str = "";
        for (int i = 0; i < 20; i++) {
            str += i;
        }

        tracerForCurrentMethod.stopTrace();
        customMethod.setNanoseconds(tracerForCurrentMethod.getTraceResult().getNanoseconds());
        method.addMethod(customMethod);
    }

    public void concatenateTwentyThousandTimes(){
        CustomMethod customMethod = new CustomMethod(new Object(){}.getClass().getEnclosingMethod());
        Tracer tracerForCurrentMethod = new TraceImplementation();
        tracerForCurrentMethod.startTrace();

        String str = "";
        for (int i = 0; i < 20_000; i++) {
            str += i;
        }

        tracerForCurrentMethod.stopTrace();
        customMethod.setNanoseconds(tracerForCurrentMethod.getTraceResult().getNanoseconds());
        method.addMethod(customMethod);
    }

    public void concatenateTwoMillionTimes(){
        CustomMethod customMethod = new CustomMethod(new Object(){}.getClass().getEnclosingMethod());
        Tracer tracerForCurrentMethod = new TraceImplementation();
        tracerForCurrentMethod.startTrace();

        String str = "";
        for (int i = 0; i < 2_000_000; i++) {
            str += i;
        }

        tracerForCurrentMethod.stopTrace();
        customMethod.setNanoseconds(tracerForCurrentMethod.getTraceResult().getNanoseconds());
        method.addMethod(customMethod);
    }
}

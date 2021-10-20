package tasks;

import reflect.CustomMethod;
import trace.TraceImplementation;
import trace.Tracer;

public class MainTask {

    public final Tracer tracer;

    public MainTask(Tracer tracer) {
        this.tracer = tracer;
    }

    public void calculateManyNumbers(){
        CustomMethod customMethod = new CustomMethod(new Object(){}.getClass().getEnclosingMethod());
        Tracer tracerForCurrentMethod = new TraceImplementation();
        tracerForCurrentMethod.startTrace();

        SimpleCalculator simpleCalculator = new SimpleCalculator(customMethod);
        simpleCalculator.calculateTwentyNumbersSum();
        simpleCalculator.calculateTwentyThousandNumbersSum();
        simpleCalculator.calculateTwoMillionNumbersSum();

        tracerForCurrentMethod.stopTrace();
        customMethod.setNanoseconds(tracerForCurrentMethod.getTraceResult().getNanoseconds());
        tracer.addMethodToResult(customMethod);
    }

    public void calculateBitOfNumbers(){
        CustomMethod customMethod = new CustomMethod(new Object(){}.getClass().getEnclosingMethod());
        Tracer tracerForCurrentMethod = new TraceImplementation();
        tracerForCurrentMethod.startTrace();

        SimpleCalculator simpleCalculator = new SimpleCalculator(customMethod);
        simpleCalculator.calculateTwentyNumbersSum();

        tracerForCurrentMethod.stopTrace();
        customMethod.setNanoseconds(tracerForCurrentMethod.getTraceResult().getNanoseconds());
        tracer.addMethodToResult(customMethod);
    }

    public void concatenateBitOfStrings(){
        CustomMethod customMethod = new CustomMethod(new Object(){}.getClass().getEnclosingMethod());
        Tracer tracerForCurrentMethod = new TraceImplementation();
        tracerForCurrentMethod.startTrace();

        SimpleStringConcatenator simpleStringConcatenator = new SimpleStringConcatenator(customMethod);
        simpleStringConcatenator.concatenateTwentyTimes();

        tracerForCurrentMethod.stopTrace();
        customMethod.setNanoseconds(tracerForCurrentMethod.getTraceResult().getNanoseconds());
        tracer.addMethodToResult(customMethod);
    }
}

package trace;

import reflect.CustomMethod;

public interface Tracer {
    void startTrace();
    void stopTrace();
    TraceResult getTraceResult();
    void addMethodToResult(CustomMethod customMethod);
}

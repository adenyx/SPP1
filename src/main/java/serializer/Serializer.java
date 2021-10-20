package serializer;

import trace.TraceResult;

import java.util.List;

public interface Serializer {
    String generateResult(List<TraceResult> traceResults);
}

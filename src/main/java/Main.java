import output.PrintType;
import output.ResultOutput;
import serializer.JsonSerializer;
import serializer.Serializer;
import serializer.XMLSerializer;
import tasks.TaskExecutorFirst;
import tasks.TaskExecutorSecond;
import trace.TraceImplementation;
import trace.TraceResult;
import trace.Tracer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Tracer tracer;
        Callable<TraceResult> task;
        List<TraceResult> list = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            tracer = new TraceImplementation();
            task = getTask(i, tracer);
            Future<TraceResult> result = service.submit(task);
            list.add(result.get());
        }
        service.shutdown();

        Serializer jsonSerializer = new JsonSerializer();
        String json = jsonSerializer.generateResult(list);

        Serializer xmlSerializer = new XMLSerializer();
        String xml = xmlSerializer.generateResult(list);

        ResultOutput resultOutput = PrintType.CONSOLE;
        resultOutput.printResult(json);

        System.out.println("\n\n===============================\n\n");
        resultOutput.printResult(xml);


        ResultOutput resultOutput2 = PrintType.JSON;
        resultOutput2.printResult(json);

        ResultOutput resultOutput3 = PrintType.XML;
        resultOutput3.printResult(xml);

    }

    private static Callable<TraceResult> getTask(int i, Tracer tracer) {
        return (i > 2) ? new TaskExecutorFirst(tracer) : new TaskExecutorSecond(tracer);
    }
}

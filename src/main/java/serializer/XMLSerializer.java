package serializer;

import reflect.CustomMethod;
import trace.TraceResult;

import java.util.List;

public class XMLSerializer implements Serializer{

    public String generateResult(List<TraceResult> traceResults) {
        StringBuilder writer = new StringBuilder("");
        writer.append("<threads> \n");

        for (TraceResult traceResult : traceResults) {
            writer.append("\t<thread> \n");
            writer.append("\t\t<threadId>").append(traceResult.getThreadId()).append("</threadId>\n");
            writer.append("\t\t<time>").append(traceResult.getNanoseconds()).append("ns</time>\n");
            appendMethods(4, writer, traceResult.getCustomMethods());
//            writer.append("\t<>").append(delimeter(traceResult, traceResults)).append("\n");
            writer.append("\t</thread> \n");
        }

        writer.append("</threads>");
        return writer.toString();
    }

    private void appendMethods(int tabs, StringBuilder writer, List<CustomMethod> methods) {
        String tabForTitle = getTab(tabs - 2);
        String tab = getTab(tabs);
        writer.append(tabForTitle).append("<methods>");
        if (methods == null || methods.size() == 0) {
            writer.append("</methods>\n");
            return;
        }

        writer.append("\n");
        for (CustomMethod method : methods) {
            writer.append(tabForTitle).append("\t<method>\n");
            writer.append(tab).append("<name>").append(method.getName()).append("</name>\n");
            writer.append(tab).append("<class>").append(method.getClassName()).append("</class>\n");
            writer.append(tab).append("<time>").append(method.getNanoseconds()).append("ns</time>\n");
            appendMethods(tabs + 2, writer, method.getCustomMethods());
            writer.append(tabForTitle).append("\t</method>").append(delimeter(method, methods)).append("\n");
        }
        writer.append(tabForTitle).append("</methods>\n");
    }

    private String delimeter(CustomMethod method, List<CustomMethod> methods) {
        return methods.indexOf(method) == methods.size() - 1 ? "" : ",";
    }

    private String delimeter(TraceResult traceResult, List<TraceResult> traceResults) {
        return traceResults.indexOf(traceResult) == traceResults.size() - 1 ? "" : ",";
    }

    private String getTab(int tabs) {
        return "" + "\t".repeat(Math.max(0, tabs));
    }
}

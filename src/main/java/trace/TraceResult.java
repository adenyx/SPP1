package trace;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reflect.CustomMethod;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraceResult {
    private long threadId;
    private long nanoseconds;
    private ArrayList<CustomMethod> customMethods;

    public synchronized void addMethod(CustomMethod customMethod){
        customMethods.add(customMethod);
    }

    public long getThreadId() {
        return threadId;
    }

    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }

    public long getNanoseconds() {
        return nanoseconds;
    }

    public void setNanoseconds(long nanoseconds) {
        this.nanoseconds = nanoseconds;
    }

    public ArrayList<CustomMethod> getCustomMethods() {
        return customMethods;
    }

    public void setCustomMethods(ArrayList<CustomMethod> customMethods) {
        this.customMethods = customMethods;
    }
}

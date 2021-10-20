package reflect;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.ArrayList;

@Data
public class CustomMethod {
    private String name;
    private String className;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    private long nanoseconds;
    ArrayList<CustomMethod> customMethods;

    public CustomMethod(Method method) {
        this.name = method.getName();
        this.className = method.getDeclaringClass().getSimpleName();
        customMethods = new ArrayList<>();
    }

    public void addMethod(CustomMethod customMethod){
        customMethods.add(customMethod);
    }
}

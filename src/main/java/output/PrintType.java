package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public enum PrintType implements ResultOutput{
    CONSOLE{
        @Override
        public void printResult(String result){
            System.out.println(result);
        }
    },
    JSON {
        @Override
        public void printResult(String result){
            final File file = new File("output.json");
            try {
                FileWriter writer = new FileWriter(file, false);
                writer.write(result);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    },
    XML {
        @Override
        public void printResult(String result){
            final File file = new File("output.xml");
            try {
                FileWriter writer = new FileWriter(file, false);
                writer.write(result);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    },
}

package chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

/**
 * Created by fall1999y on 2016. 6. 28..
 */
public class ExecuteArroundPattern {
    public static void main(String[] args) {


        try {
            String str = processFile(br -> br.readLine() + br.readLine());
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Function<BufferedReader, String> f = (BufferedReader br) -> {
            try {
                return br.readLine();
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
        };
    }

    @FunctionalInterface
    public interface BufferReaderProcess {
        String process(BufferedReader br) throws IOException;
    }

    public static String processFile(BufferReaderProcess p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ExecuteArroundPattern.class.getResource("test.properties").getPath()))) {
            return p.process(br);
        }
    }
}

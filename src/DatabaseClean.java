import java.io.*;
import java.util.*;


public class DatabaseClean {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] data = new String[N];
        for (int i_data = 0; i_data < N; i_data++) {
            data[i_data] = br.readLine();
        }

        String[] out_ = database_clean(data);
        for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {
            wr.println(out_[i_out_]);
        }

        wr.close();
        br.close();
    }

    static String[] database_clean(String[] data) {
        // Write your code here
        return data;
    }
}

interface Department{
    void setName(String name);
    void dispaly();
}

class ProblemSetter implements Department {
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void dispaly() {

    }
}
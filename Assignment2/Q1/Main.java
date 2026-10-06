import java.io.*;

class LowerCaseReader extends FilterReader {

    public LowerCaseReader(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int ch = super.read();
        if (ch == -1)
            return -1;
        return Character.toLowerCase((char) ch);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int count = super.read(cbuf, off, len);

        if (count == -1)
            return -1;

        for (int i = off; i < off + count; i++) {
            cbuf[i] = Character.toLowerCase(cbuf[i]);
        }

        return count;
    }
}

public class Main{
    public static void main(String[] args) {
        try {
            Reader reader = new LowerCaseReader(new FileReader("input.txt"));

            int ch;
            System.out.println("Contents after converting to lowercase:");

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author Stu Harvey
 * @PID stu
 * @project 3114 - Project 1: File Navigation and Parsing
 * @modified June 2, 2015
 * 
 * Runs a line-by-line diff on the student's results file as compared to the
 * professor's results file. Super quick and dirty so it's not documented at 
 * all.
 */
public class TestProject1 {
    public static void main(String [] args) {
        String fp1, 
               fp2;
        int numArgs = args.length;
        switch (numArgs) {
            case 0: // assuming GISData01.txt and Commands01.txt were used
                fp1 = "Results.txt";
                fp2 = "Results01.txt";
                break;
            case 1:
                // "all test files"
                System.out.println("TODO");
                return;
            case 2:
                fp1 = args[0];
                fp2 = args[1];
                break;
            default:
                String errString = "Expected 2 arguments, received " + numArgs;
                throw new IllegalArgumentException(errString);
        }

        try {
            DiffChecker diff = new DiffChecker(fp1, fp2);
            boolean filesMatched = diff.compareFiles();
            if (filesMatched)
                System.out.println("No significant differences discovered.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Finds the line differences between two files.
     * Things to improve:
     *   - If 
     */
    public static class DiffChecker {
        private RandomAccessFile pre, post;

        public DiffChecker(String fp1, String fp2) throws FileNotFoundException {
            pre = new RandomAccessFile(fp1, "r");
            post = new RandomAccessFile(fp2, "r");
        }

        public boolean compareFiles() throws IOException {
            String preLine, postLine; // holds the lines read from each file
            int lineNum = 0;
            boolean match = true;
            while ((preLine = pre.readLine()) != null && 
                   (postLine = post.readLine()) != null) 
            {
                String result = this.compareLines(preLine, postLine);
                if (result != null) {
                    // then there is a mismatch on these lines
                    print("Found mismatch at line " + lineNum + ": \n" +
                          result);
                    match = false;
                }
                lineNum++;
            }
            return match;
        }

        private String getNextLine() {
            return null;
        }

        private String compareLines(String line1, String line2) {
            StringTokenizer tokenizer1 = new StringTokenizer(line1, " \t"),
                            tokenizer2 = new StringTokenizer(line2, " \t");
            String result = "";
            boolean mismatch = false;
            int t1Count = tokenizer1.countTokens(),
                t2Count = tokenizer2.countTokens();
            if (t1Count != t2Count) {
                result += "\tLine size mismatch:\n\t\t" +
                          "First line has " + t1Count + " tokens, " +
                          "Second line has " + t2Count + " tokens.\n";
                mismatch = true;
            } 
            int minTokens = Math.min(t1Count, t2Count);
            for (int i = 0; i < minTokens; i++) {
                String t1 = tokenizer1.nextToken(),
                       t2 = tokenizer2.nextToken();
                if ( !t1.equals(t2) ) {
                    result += "\tToken mismatch at token " + i + "\n\t\t" +
                              t1 + " != " + t2 + "\n";
                    mismatch = true;
                }
            }
            if (mismatch)
                return result;
            return null;
        }

        private void print(String s) {
            System.out.println(s);
        }
    }

    private static class Project1TestSuite {
        Project1TestSuite() throws Exception {

        }
    }
}
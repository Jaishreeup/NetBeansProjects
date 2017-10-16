import java.io.FileInputStream;
import java.util.Arrays;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FilenameFilter;
import java.util.Locale;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Anirudh Rayabharam
 */
public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		InputStream inputStream;
		try {
			final String regex = "A-(small|large).*[.]in";
			File directory = new File(".");
			File[] candidates = directory.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.matches(regex);
				}
			});
			File toRun = null;
			for (File candidate : candidates) {
				if (toRun == null || candidate.lastModified() > toRun.lastModified())
					toRun = candidate;
			}
			inputStream = new FileInputStream(toRun);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream("a.out");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}
}

class TaskA {
    int m;
    HashMap<String, Integer> names;
    int[] color;
    boolean[][] adj;

    boolean isPossible(int x, int c) {
        color[x] = c;
        boolean p = true;
        for (int i = 0; i < 2 * m; ++i) {
            if (adj[x][i]) {
                if (color[i] == c) {
                    return false;
                } else if (color[i] == -1) {
                    p = p && isPossible(i, 1 - c);
                }
            }
        }
        return p;
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        m = in.nextInt();
        adj = new boolean[2 * m][2 * m];
        names = new HashMap<String, Integer>();
        int next = 0;
        for (int i = 0; i < m; ++i) {
            String a = in.next();
            String b = in.next();
            int aVal, bVal;
            if (names.containsKey(a)) aVal = names.get(a);
            else {
                names.put(a, next);
                aVal = next++;
            }
            if (names.containsKey(b)) bVal = names.get(b);
            else {
                names.put(b, next);
                bVal = next++;
            }
            adj[aVal][bVal] = true;
            adj[bVal][aVal] = true;
        }
        color = new int[2 * m];
        Arrays.fill(color, -1);
        out.print("Case #" + testNumber + ": ");
        if (isPossible(0, 0)) out.println("Yes");
        else out.println("No");
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

}


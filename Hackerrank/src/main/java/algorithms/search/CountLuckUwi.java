package algorithms.search;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Queue;

public class CountLuckUwi {

    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";

    static void solve() {
        for (int T = ni(); T >= 1; T--) {
            int n = ni(), m = ni();
            char[][] map = nm(n, m);
            int sr = -1, sc = -1;
            int gr = -1, gc = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 'M') {
                        sr = i;
                        sc = j;
                        map[i][j] = '.';
                    }
                    if (map[i][j] == '*') {
                        gr = i;
                        gc = j;
                        map[i][j] = '.';
                    }
                }
            }
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{sr, sc});
            int[][] d = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(d[i], 99999999);
            }
            d[sr][sc] = 0;
            int[] dr = {1, 0, -1, 0};
            int[] dc = {0, 1, 0, -1};
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                int cango = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k], nc = c + dc[k];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == '.') {
                        cango++;
                    }
                }
                if (sr == r && sc == c) {
                    cango++;
                }
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k], nc = c + dc[k];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == '.') {
                        if (d[nr][nc] == 99999999) {
                            d[nr][nc] = d[r][c] + (cango <= 2 ? 0 : 1);
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
            int Q = ni();
            out.println(Q == d[gr][gc] ? "Impressed" : "Oops!");
        }
    }

    public static void main(String[] args) throws Exception {
        long S = System.currentTimeMillis();
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
        long G = System.currentTimeMillis();
        tr(G - S + "ms");
    }

    private static boolean eof() {
        if (lenbuf == -1) {
            return true;
        }
        int lptr = ptrbuf;
        while (lptr < lenbuf) {
            if (!isSpaceChar(inbuf[lptr++])) {
                return false;
            }
        }

        try {
            is.mark(1000);
            while (true) {
                int b = is.read();
                if (b == -1) {
                    is.reset();
                    return true;
                } else if (!isSpaceChar(b)) {
                    is.reset();
                    return false;
                }
            }
        } catch (IOException e) {
            return true;
        }
    }

    private static byte[] inbuf = new byte[1024];
    static int lenbuf = 0, ptrbuf = 0;

    private static int readByte() {
        if (lenbuf == -1) {
            throw new InputMismatchException();
        }
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) {
                return -1;
            }
        }
        return inbuf[ptrbuf++];
    }

    private static boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }

    private static double nd() {
        return Double.parseDouble(ns());
    }

    private static char nc() {
        return (char) skip();
    }

    private static String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private static char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private static char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = ns(m);
        }
        return map;
    }

    private static int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ni();
        }
        return a;
    }

    private static int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private static long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private static void tr(Object... o) {
        if (INPUT.length() != 0) {
            System.out.println(Arrays.deepToString(o));
        }
    }
}

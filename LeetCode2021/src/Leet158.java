public class Leet158 {

    public class Solution extends Reader4 {
        char[] myBuf = new char[4];
        int start = 0, end = 0;

        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return The number of actual characters read
         */
        public int read(char[] buf, int n) {
            int i = 0;
            while (i < n) {
                if (start == 0) {
                    end = read4(myBuf);
                }
                if (start == 4) {
                    start = 0;
                    end = read4(myBuf);
                }
                if (start == end || end == 0) break;
                buf[i++] = myBuf[start++];
            }
            return i;
        }
    }

    class Reader4 {
        int read4(char[] buf4) {
            return 0;
        }
    }
}

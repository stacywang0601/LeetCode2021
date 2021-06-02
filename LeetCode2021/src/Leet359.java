import java.util.LinkedList;
import java.util.Queue;

public class Leet359 {
    class Logger {
        class Log {
            int timestamp;
            String message;

            public Log(int t, String m) {
                this.timestamp = t;
                this.message = m;
            }
        }

        Queue<Log> queue;

        /**
         * Initialize your data structure here.
         */
        public Logger() {
            queue = new LinkedList<>();
        }

        /**
         * Returns true if the message should be printed in the given timestamp, otherwise returns false.
         * If this method returns false, the message will not be printed.
         * The timestamp is in seconds granularity.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {
            while (!queue.isEmpty() && (queue.peek().timestamp + 10) <= timestamp) {
                queue.remove();
            }
            for (Log cur : queue) {
                if (cur.message.equals(message)) {
                    return false;
                }
            }
            queue.add(new Log(timestamp, message));
            return true;
        }
    }
}

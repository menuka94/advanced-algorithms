package org.menuka;

public class RedBlackBSTExecute {
    public static void main(String[] args) {
        System.out.println("============== RedBlackBST ===============");
        set("1");
        set("2");
    }

    private static void set(String set) {
        System.out.println("Set: " + set + "\n-------------\n");
        RedBlackBST<Long, Integer> st1 = new RedBlackBST<>();
        for (int j = 1; j <= 3; j++) {
            // insert
            RBinsert(st1, set, Integer.toString(j));

            // search
            RBsearch(st1, set, Integer.toString(j));

            // delete
            RBdelete(st1, set, Integer.toString(j));
        }
    }

    private static void RBinsert(RedBlackBST<Long, Integer> st, String set, String fileNumber) {
        long[] values = Utils.getValuesOfFile("insert", set, fileNumber);
        long starTime = Utils.getTime();
        for (long value : values) {
            st.put(value, (int) value);
        }
        long endTime = Utils.getTime();
        long duration = Utils.getDuration(endTime, starTime);
        Utils.printDuration(duration, "insert", set, fileNumber);
    }

    private static void RBsearch(RedBlackBST<Long, Integer> st, String set, String fileNumber) {
        long[] values = Utils.getValuesOfFile("search", set, fileNumber);
        long starTime = Utils.getTime();
        for (long value : values) {
            st.get(value);
        }
        long endTime = Utils.getTime();
        long duration = Utils.getDuration(endTime, starTime);
        Utils.printDuration(duration, "search", set, fileNumber);

    }

    private static void RBdelete(RedBlackBST<Long, Integer> st, String set, String fileNumber) {
        long[] values = Utils.getValuesOfFile("delete", set, fileNumber);
        long starTime = Utils.getTime();
        for (long value : values) {
            st.delete(value);
        }
        long endTime = Utils.getTime();
        long duration = Utils.getDuration(endTime, starTime);
        Utils.printDuration(duration, "delete", set, fileNumber);

    }
}

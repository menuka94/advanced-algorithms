package org.menuka;

public class BSTExecute {
    public static void main(String[] args) {
        System.out.println("============ BST ====================");
        set("1");
        set("2");
    }

    private static void set(String set) {
        BST<Long, Integer> st1 = new BST<>();
        for (int j = 1; j <= 3; j++) {
            // insert
            BSTinsert(st1, set, Integer.toString(j));

            // search
            BSTsearch(st1, set, Integer.toString(j));

            // delete
            BSTdelete(st1, set, Integer.toString(j));
        }
    }

    private static void BSTinsert(BST<Long, Integer> st, String set, String fileNumber) {
        long[] values = Utils.getValuesOfFile("insert", set, fileNumber);
        long starTime = Utils.getTime();
        for (long value : values) {
            st.put(value, (int) value);
        }
        long endTime = Utils.getTime();
        long duration = Utils.getDuration(endTime, starTime);
        Utils.printDuration(duration, "insert", set, fileNumber);
    }

    private static void BSTsearch(BST<Long, Integer> st, String set, String fileNumber) {
        long[] values = Utils.getValuesOfFile("search", set, fileNumber);
        long starTime = Utils.getTime();
        for (long value : values) {
            st.get(value);
        }
        long endTime = Utils.getTime();
        long duration = Utils.getDuration(endTime, starTime);
        Utils.printDuration(duration, "search", set, fileNumber);
    }

    private static void BSTdelete(BST<Long, Integer> st, String set, String fileNumber) {
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

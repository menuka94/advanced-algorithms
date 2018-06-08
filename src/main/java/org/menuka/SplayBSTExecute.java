package org.menuka;

public class SplayBSTExecute {
    public static void main(String[] args) {
        System.out.println("============ Splay ================");
        set("1");
        set("2");
    }

    private static void set(String set) {
        System.out.println("Set: " + set + "\n-------------\n");
        SplayBST<Long, Integer> st1 = new SplayBST<>();
        for (int j = 1; j <= 3; j++) {
            // insert
            SplayBSTinsert(st1, set, Integer.toString(j));

            // search
            SplayBSTsearch(st1, set, Integer.toString(j));

            // delete
            SplayBSTdelete(st1, set, Integer.toString(j));
        }
    }

    private static void SplayBSTinsert(SplayBST<Long, Integer> st, String set, String fileNumber) {
        long[] values = Utils.getValuesOfFile("insert", set, fileNumber);
        long starTime = Utils.getTime();
        for (long value : values) {
            st.put(value, (int) value);
        }
        long endTime = Utils.getTime();
        long duration = Utils.getDuration(endTime, starTime);
        Utils.printDuration(duration, "insert", set, fileNumber);
    }

    private static void SplayBSTsearch(SplayBST<Long, Integer> st, String set, String fileNumber) {
        long[] values = Utils.getValuesOfFile("search", set, fileNumber);
        long starTime = Utils.getTime();
        for (long value : values) {
            st.get(value);
        }
        long endTime = Utils.getTime();
        long duration = Utils.getDuration(endTime, starTime);
        Utils.printDuration(duration, "search", set, fileNumber);

    }

    private static void SplayBSTdelete(SplayBST<Long, Integer> st, String set, String fileNumber) {
        long[] values = Utils.getValuesOfFile("delete", set, fileNumber);
        long starTime = Utils.getTime();
        for (long value : values) {
            st.remove(value);
        }
        long endTime = Utils.getTime();
        long duration = Utils.getDuration(endTime, starTime);
        Utils.printDuration(duration, "delete", set, fileNumber);

    }
}

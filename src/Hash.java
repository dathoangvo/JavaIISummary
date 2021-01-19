public class Hash {
    private int current_size;
    private int max_size;
    private static final int null_num = -9999;
    private Integer[] mainArray;

    public Hash() {
        current_size = 0;
        max_size = 16;
        mainArray = new Integer[max_size];
    }

    public Hash(int n) {
        current_size = 0;
        max_size = n;
        mainArray = new Integer[max_size];
    }

    public void add(int n) {
        if (current_size > max_size / 2) expand();
        int place_at = n % max_size;
        // Stop if null, null_num, or given num
        while (mainArray[place_at] != null && mainArray[place_at] != null_num && mainArray[place_at] != n) {
            if (place_at == max_size - 1) {
                place_at = 0;
            } else {
                place_at++;
            }
        }
        if (mainArray[place_at] == null || mainArray[place_at] == null_num || mainArray[place_at] != n) {
            current_size++;
            mainArray[place_at] = n;
        }
    }

    private void expand() {
        Hash replacement = new Hash(max_size * 2);
        for (int i = 0; i < max_size; i++) {
            if (mainArray[i] != null && mainArray[i] != null_num) {
                replacement.add(mainArray[i]);
            }
        }
        mainArray = replacement.getMainArray();
        max_size *= 2;
    }

    public Integer[] getMainArray() {
        return mainArray;
    }

    public void remove(int n) {
        int remove_at = findIndex(n);
        if (remove_at != -1) {
            mainArray[remove_at] = null_num;
            current_size--;
        }
    }

    public int findIndex(int n) {
        int searching_at = n % max_size;
        // Continue while
        while (mainArray[searching_at] != null && mainArray[searching_at] != n) {
            if (searching_at == max_size - 1) {
                searching_at = 0;
            } else {
                searching_at++;
            }
        }

        if (mainArray[searching_at] != null && mainArray[searching_at] == n) {
            return searching_at;
        } else {
            return -1;
        }
    }


    public int getSize() { return current_size; }

    public void clear() {
        current_size = 0;
        max_size = 16;
        mainArray = new Integer[max_size];
    }


    public String toString() {
        String builder = "";
        for (int i = 0; i < max_size; i++) {
            if (mainArray[i] != null && mainArray[i] != null_num) {
                builder += i +  "[ " + mainArray[i] + " ] ";
            } else {
                builder += i + "[   ] ";
            }
        }
        return builder;
    }
}

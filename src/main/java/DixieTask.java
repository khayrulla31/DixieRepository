import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class DixieTask {
    public static void main(String[] args) {
        String[] array = {
                "K1/SK1",
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        };

        String[] answer = solution(array);

        //System.out.println(Arrays.toString(answer));

        Arrays.stream(answer).forEach(System.out::println);
    }

    private static String[] solution(String[] array) {
        Set<String> set = new TreeSet<>();

        for (String str : array) {
            missing(str, set);
        }

        String[] arr = set.toArray(set.toArray(new String[0]));

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length() && o2.startsWith(o1))
                    return -1;
                if (o2.length() < o1.length() && o1.startsWith(o2))
                    return 1;
                return o2.compareTo(o1);
            }
        });
        return arr;
    }

    public static Set<String> missing(String s, Set<String> stringSet) {
        int sPointer = 0;
        String ss = "";

        while (sPointer != s.length()) {
            ss = ss + s.charAt(sPointer);
            sPointer++;
            if (sPointer == s.length()) {
                stringSet.add(ss);
                break;
            }
            if (s.charAt(sPointer) == '/') {
                stringSet.add(ss);
            }
        }
        return stringSet;
    }
}


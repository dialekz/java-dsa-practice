package yandexChampionship2019.championship;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskE {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        String regex = "H(([a-fA-F0-9])\\+(([a-fA-F0-9])))";
        Pattern pattern = Pattern.compile(regex);
        boolean continueFlag = true;
        int interCount = -1;

        while (continueFlag) {
            continueFlag = false;
            interCount++;

            Matcher matcher = pattern.matcher(line);
            HashMap<String, String> map = new HashMap<>();
            while (matcher.find()) {
                if (map.containsKey(matcher.group(0))) {
                    continue;
                }
                long x = Long.parseLong(matcher.group(2), 16);
                long y = Long.parseLong(matcher.group(3), 16);
                String replace = Character.toString((char) (16 * x + y));
                map.put(matcher.group(0), replace);
                continueFlag = true;
            }
            if (continueFlag) {
                line = atomicReplace(line, map);
            }
        }
        System.out.println(interCount);
    }

    private static String atomicReplace(String line, HashMap<String, String> map) {
        if (map.isEmpty()) {
            return line;
        }
        String currentKey = map.keySet().stream().findFirst().get();
        String currentValue = map.remove(currentKey);

        if (map.isEmpty()) {
            return line.replace(currentKey, currentValue);
        }

        String[] arr = line.split(currentKey.replace("+", "\\+"));
        if (arr.length == 0)
            return currentValue;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replace(currentKey, currentValue);
            arr[i] = atomicReplace(arr[i], new HashMap<>(map));
        }

        return String.join(currentValue, arr);
    }
}

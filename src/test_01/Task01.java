package test_01;

/**
 * Source:      Task01.java
 * Created:     08.12.2017
 * Project:     Practice-DSA
 * Make:        IntelliJ IDEA
 * <p>
 * {@code Task01} 1.	Последовательность Фибоначчи выглядит следующим образом 0 1 1 2 3 5 8 13 21 34 55 ...,
 * то есть каждый последующий член последовательности равен сумме двух предыдущих.
 * На ввод поступает строка например вида «13213455». Напишите программу,
 * проверяющую является ли строка частью последовательности Фибоначчи.
 *
 * @author dialekz
 */
public class Task01 {

    private static boolean foo(String str) {
        boolean result = false;

        String first, second, third;
        int firstInt, secondInt, thirdInt;
        int startIndex = 0, firstSize = 1, secondSize = 1;
        int mainFirstSize = 1, mainSecondSize = 1;

        while (firstSize + secondSize < str.length()/2 && startIndex + firstSize + secondSize < str.length()) {

            first = str.substring(startIndex, startIndex + firstSize);
            second = str.substring(startIndex + firstSize, startIndex + firstSize + secondSize);

            firstInt = Integer.valueOf(first);
            secondInt = Integer.valueOf(second);

            thirdInt = firstInt + secondInt;
            third = String.valueOf(thirdInt);

            if (str.regionMatches(startIndex + firstSize + secondSize, third, 0, third.length())) {
                startIndex += firstSize;
                firstSize = secondSize;
                secondSize = third.length();
                result = true;
            } else {
                if (mainSecondSize > mainFirstSize) {
                    mainFirstSize++;
                } else {
                    mainSecondSize++;
                }
                startIndex = 0;
                firstSize = mainFirstSize;
                secondSize = mainSecondSize;
                result = false;
            }
        }

        return result;
    }

}

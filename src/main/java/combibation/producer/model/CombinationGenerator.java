package combibation.producer.model;

import java.util.*;

public class CombinationGenerator
{
    private CombinationGenerator()
    {
    }

    @SafeVarargs
    public static <T> List<List<T>> generateOnOffCombination(T disabledValue, T... values)
    {
        if (values.length == 0)
        {
            return Collections.singletonList(Arrays.asList(values));
        }

        final int combinationLength = values.length;

        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        final Map<Integer, T> decipher = new HashMap<>();

        int position = 0;
        for (T value : values)
        {
            decipher.put(position, value);
            position++;
        }

        final char[][] cipheredCombinations = generateBooleanCombination(combinationLength);
        final List<List<T>> combinations = new ArrayList<>();

        int rowCounter = 0;
        for (char[] cipheredRow : cipheredCombinations)
        {
            List<T> decipheredRow = new ArrayList<>();
            for (position = 0; position < values.length; position++)
            {
                T valueToAdd = cipheredRow[position] == '0'
                        ? disabledValue
                        : decipher.get(position);

                decipheredRow.add(position, valueToAdd);
            }
            combinations.addAll(rowCounter, Collections.singleton(decipheredRow));
            rowCounter++;
        }

        return combinations;
    }

    public static char[][] generateBooleanCombination(int length)
    {
        final int totalNumberOfCombination = ((Double) Math.pow(2, length)).intValue();
        final char[][] combinations = new char[totalNumberOfCombination][length];
        for (int combinationNumber = 0; combinationNumber < totalNumberOfCombination; combinationNumber++)
        {
            final StringBuilder binCypher = new StringBuilder(Integer.toBinaryString(combinationNumber));
            while (binCypher.length() < length)
            {
                binCypher.insert(0, "0");
            }

            combinations[combinationNumber] = binCypher.toString().toCharArray();
        }

        return combinations;
    }
}

package combibation.producer.model.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import combibation.producer.model.CombinationGenerator;

public class CombinationGeneratorTest
{
    @Test
    public void generateBooleanCombinationTest()
    {
        final char[][] actualCharArray = (CombinationGenerator.generateBooleanCombination(2));
        final char[][] expectedCharArray = {{'0', '0'}, {'0', '1'}, {'1', '0'}, {'1', '1'}};

        Assert.assertArrayEquals("Arrays are not equal", expectedCharArray, actualCharArray);
    }

    @Test
    public void generateParametrisedCombinationTest()
    {
        final List<List<String>> actualCharArray =
                (CombinationGenerator.generateOnOffCombination("0", "1", "2"));
        final List<List<String>> expectedCharArray = new ArrayList<>();
        expectedCharArray.add(Arrays.asList("0", "0"));
        expectedCharArray.add(Arrays.asList("0", "2"));
        expectedCharArray.add(Arrays.asList("1", "0"));
        expectedCharArray.add(Arrays.asList("1", "2"));

        int rowCounter = 0;
        for (List<String> expectedRow : expectedCharArray)
        {
           Assert.assertEquals("Rows are not equal", expectedRow, actualCharArray.get(rowCounter));
           rowCounter++;
        }
    }
}

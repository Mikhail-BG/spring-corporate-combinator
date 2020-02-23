package combibation.producer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CombinationProducerTest
{
    @Test
    public void CombinationProducerBooleanTest()
    {
        char[][] actualCharArray = (CombinationFactory.generateBooleanCombination(2));
        char[][] expectedCharArray = {{'0', '0'}, {'0', '1'}, {'1', '0'}, {'1', '1'}};

        System.out.println(Arrays.deepToString(actualCharArray));

        Assert.assertArrayEquals("Arrays are not equal", expectedCharArray, actualCharArray);
    }

    @Test
    public void CombinationProducerParametrisedTest()
    {
        List<List<String>> actualCharArray =
                (CombinationFactory.generateOnOffCombination("0", "1", "2"));
        List<List<String>> expectedCharArray = new ArrayList<>();
        expectedCharArray.add(Arrays.asList("0", "0"));
        expectedCharArray.add(Arrays.asList("0", "2"));
        expectedCharArray.add(Arrays.asList("1", "0"));
        expectedCharArray.add(Arrays.asList("1", "2"));

        System.out.println(actualCharArray);

        int rowCounter = 0;
        for (List<String> expectedRow : expectedCharArray)
        {
           Assert.assertEquals("Rows are not equal", expectedRow, actualCharArray.get(rowCounter));
           rowCounter++;
        }
    }
}

package combibation.producer.model;

import org.junit.Assert;
import org.junit.Test;

import combibation.producer.model.bean.CombinationModel;

public class CombinationModelTest
{
    @Test
    public void CreateAndPrintCombinationModelTest()
    {
        final String disabledValue = "00";
        final String switcher1 = "88";
        final String switcher2 = "99";
        final String expectedPattern = "[[%1$s, %1$s], [%1$s, %3$s], [%2$s, %1$s], [%2$s, %3$s]]";
        final String expectedValue = String.format(expectedPattern, disabledValue, switcher1, switcher2);

        final String actualValue = new CombinationModel(disabledValue, switcher1, switcher2).prettyPrintCombinations();

        Assert.assertEquals("Values are not equal", expectedValue, actualValue);
    }
}

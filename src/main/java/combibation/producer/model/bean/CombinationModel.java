package combibation.producer.model.bean;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import combibation.producer.model.CombinationGenerator;

public class CombinationModel
{
    private String disabledValue;
    private String switcher1;
    private String switcher2;
    private List<List<String>> combinations;

    public CombinationModel(String disabledValue, String switcher1, String switcher2)
    {
        this.disabledValue = disabledValue;
        this.switcher1 = switcher1;
        this.switcher2 = switcher2;
        this.combinations = CombinationGenerator.generateOnOffCombination(disabledValue, switcher1, switcher2);
    }

    public String getDisabledValue()
    {
        return disabledValue;
    }

    public String getSwitcher1()
    {
        return switcher1;
    }

    public String getSwitcher2()
    {
        return switcher2;
    }

    public String prettyPrintCombinations()
    {
        return combinations.toString();
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

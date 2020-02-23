package combibation.producer.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import combibation.producer.model.bean.CombinationModel;

@Configuration
@EnableConfigurationProperties
public class ModelConfiguration
{
    //To enable auto configure support it is necessary
    // to add 'spring.factories' file in META-INF folder with enabling this configuration

    //Current spring boot has limitation to load only application.yml file.
    @Value("${combination.disabled}")
    public String disabledValue;

    @Value("${combination.switcher1}")
    public String switcher1;

    @Value("${combination.switcher2}")
    public String switcher2;

    @Bean
    public CombinationModel generateCombinationModel()
    {
        return new CombinationModel(disabledValue, switcher1, switcher2);
    }
}

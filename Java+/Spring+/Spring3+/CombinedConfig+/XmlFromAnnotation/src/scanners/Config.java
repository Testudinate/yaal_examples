package scanners;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import scanners.mayor.MayorAssistant;

@Configuration
@ImportResource("classpath:xml-context.xml")
public class Config {

    @Bean(name = "rightHand")
    public MayorAssistant getRightHand() {
        return new MayorAssistant("Экономистов В.П.");
    }

    @Bean(name = "leftHand")
    public MayorAssistant getLeftHand() {
        return new MayorAssistant("Криворуков Ж.Х.");
    }
}

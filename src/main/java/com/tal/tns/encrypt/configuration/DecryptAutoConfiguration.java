package com.tal.tns.encrypt.configuration;

        import com.tal.tns.encrypt.processor.DecryptAnnotationBeanPostProcessor;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

@Configuration
public class DecryptAutoConfiguration {

    DecryptAnnotationBeanPostProcessor decryptAnnotationBeanPostProcessor;

    @Bean
    DecryptAnnotationBeanPostProcessor getDecrypt() {
        return new DecryptAnnotationBeanPostProcessor();
    }
}

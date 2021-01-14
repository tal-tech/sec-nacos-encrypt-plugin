package com.tal.tns.encrypt.processor;

import com.tal.tns.encrypt.Utils.DesEncrypt;
import com.tal.tns.encrypt.annotation.Decrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import java.lang.reflect.Field;

@Component
public class DecryptAnnotationBeanPostProcessor implements BeanPostProcessor {

    Logger log = LoggerFactory.getLogger(DecryptAnnotationBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();

        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
            Decrypt annotation = declaredField.getAnnotation(Decrypt.class);
            if (null == annotation) {
                continue;
            }
            declaredField.setAccessible(true);
            try {
                // 将value解密
                String value = String.valueOf(declaredField.get(bean));
                declaredField.set(bean, DesEncrypt.decrypt(value));

            } catch (IllegalAccessException e) {
                log.error("", e);
            } catch (Exception e) {
                log.error("", e);
            }

        }
        return bean;
    }
}

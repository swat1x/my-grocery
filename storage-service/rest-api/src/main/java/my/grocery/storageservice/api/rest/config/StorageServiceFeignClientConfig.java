package my.grocery.storageservice.api.rest.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.hc5.ApacheHttp5Client;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StorageServiceFeignClientConfig {

    @Bean
    public Feign.Builder orderFeignBuilder() {
        return Feign.builder()
                .client(new ApacheHttp5Client());
    }

    @Bean
    public ErrorDecoder errorDecoder(ObjectMapper objectMapper) {
        return new FeignClientErrorDecoder(objectMapper);
    }

    /**
     * Объявление маппера для клиентов взаимодействия с модулем приказов
     */
//    @Bean
//    public Decoder orderFeignDecoder() {
//        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(orderRestApiObjectMapper());
//
//        HttpMessageConverters httpMessageConverters = new HttpMessageConverters(jacksonConverter);
//        ObjectFactory<HttpMessageConverters> objectFactory = () -> httpMessageConverters;
//
//        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
//    }
//
//    /**
//     * Объявление маппера для клиентов взаимодействия с модулем приказов (сериализация)
//     */
//    @Bean
//    public Encoder orderFeignEncoder() {
//        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(orderRestApiObjectMapper());
//
//        HttpMessageConverters httpMessageConverters = new HttpMessageConverters(jacksonConverter);
//        ObjectFactory<HttpMessageConverters> objectFactory = () -> httpMessageConverters;
//
//        return new SpringEncoder(objectFactory);
//    }

    /**
     * Объявление маппера для feign клиентов
     */
//    @Bean
//    public ObjectMapper orderRestApiObjectMapper() {
//        return JsonMapper.builder()
//                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
////                .addModule(new Jdk8Module())
////                .addModule(new JavaTimeModule())
//                .build()
//                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//    }

}

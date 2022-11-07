package hello.proxy;

import hello.proxy.config.v1_proxy.concrete_proxy.ConcreteProxyConfig;
import hello.proxy.config.v1_proxy.interface_proxy.InterfaceProxyConfig;
import hello.proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import hello.proxy.config.v2_dynamicproxy.handler.DynamicProxyFilterConfig;
import hello.trace.LogTrace;
import hello.trace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
@Import(DynamicProxyFilterConfig.class)
@SpringBootApplication(scanBasePackages = "hello.proxy.app") //config package 스캔을 하지 않기 위해 별도로 설정
public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }


    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

}

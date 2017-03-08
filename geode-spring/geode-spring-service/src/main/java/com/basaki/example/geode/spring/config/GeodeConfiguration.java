package com.basaki.example.geode.spring.config;

import com.basaki.example.geode.spring.model.Book;
import java.util.Collections;
import java.util.Properties;
import java.util.UUID;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.pdx.PdxSerializer;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.client.ClientCacheFactoryBean;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.client.PoolFactoryBean;
import org.springframework.data.gemfire.config.xml.GemfireConstants;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.data.gemfire.support.ConnectionEndpoint;

/**
 * <tt>GeodeConfiguration</tt> is a Apache Geode configuration class for
 * creating Geode connection (session).
 * <p/>
 *
 * @author Indra Basak
 * @since 2/23/17
 */
@Configuration
@EnableGemfireRepositories("com.basaki.example.geode.spring.repository")
public class GeodeConfiguration {

    @Value("${geode.cache.server.host:localhost}")
    private String host;

    @Value("${geode.cache.server.port:40404}")
    private int port;

    @Value("${geode.cache.log.level:config}")
    private String logLevel;

    @Bean
    public ReflectionBasedAutoSerializer pdxSerializer() {
        ReflectionBasedAutoSerializer serializer =
                new ReflectionBasedAutoSerializer(
                        "com.basaki.example.geode.spring.model.*");
        return serializer;
    }

    @Bean(name = GemfireConstants.DEFAULT_GEMFIRE_POOL_NAME)
    public PoolFactoryBean gemfirePool() {
        PoolFactoryBean gemfirePool = new PoolFactoryBean();
        gemfirePool.setName(GemfireConstants.DEFAULT_GEMFIRE_POOL_NAME);
        gemfirePool.setServers(
                Collections.singletonList(new ConnectionEndpoint(host, port)));

        return gemfirePool;
    }

    @Bean
    public Properties gemfireProperties() {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("name", "GeodeSpringExampleApplication");
        gemfireProperties.setProperty("log-level", logLevel);

        return gemfireProperties;
    }

    @Bean(name = "cache")
    public ClientCacheFactoryBean gemfireCache(Properties gemfireProperties,
            PdxSerializer pdxSerializer) {
        ClientCacheFactoryBean gemfireCache = new ClientCacheFactoryBean();
        gemfireCache.setClose(true);
        gemfireCache.setProperties(gemfireProperties);
        gemfireCache.setPdxSerializer(pdxSerializer);

        return gemfireCache;
    }

    @Bean
    public ClientRegionFactoryBean<UUID, Book> bookRegion(
            @Qualifier("cache") ClientCacheFactoryBean gemfireCache,
            Pool gemfirePool) throws Exception {
        ClientRegionFactoryBean<UUID, Book> region =
                new ClientRegionFactoryBean<>();
        region.setName("Book");
        region.setPool(gemfirePool);
        region.setCache(gemfireCache.getObject());
        region.setShortcut(ClientRegionShortcut.PROXY);

        return region;
    }
}

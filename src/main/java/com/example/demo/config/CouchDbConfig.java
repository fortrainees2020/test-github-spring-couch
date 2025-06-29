// CouchDbConfig.java
package com.example.demo.config;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CouchDbConfig {

    @Value("${couchdb.dbname}")
    private String dbName;

    @Value("${couchdb.protocol}")
    private String protocol;

    @Value("${couchdb.host}")
    private String host;

    @Value("${couchdb.port}")
    private int port;

    @Value("${couchdb.username}")
    private String username;

    @Value("${couchdb.password}")
    private String password;

    @Bean
    public CouchDbClient couchDbClient() {
        CouchDbProperties properties = new CouchDbProperties()
                .setDbName(dbName)
                .setCreateDbIfNotExist(true)
                .setProtocol(protocol)
                .setHost(host)
                .setPort(port)
                .setUsername(username)
                .setPassword(password);

        return new CouchDbClient(properties);
    }
}

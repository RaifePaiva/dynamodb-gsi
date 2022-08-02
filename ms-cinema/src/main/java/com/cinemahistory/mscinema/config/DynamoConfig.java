package com.cinemahistory.mscinema.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoConfig {

    @Value("${aws.endpoint:http://localhost:4566}")
    private String endpoint;

    @Value("${aws.accesskey:123}")
    private String accesskey;

    @Value("${aws.secretkey:123}")
    private String secretkey;

    @Value("${aws.region:sa-east-1}")
    private String region;

    @Bean
    public DynamoDBMapper dynamoDBMapper(){return new DynamoDBMapper(amazonDynamoDb());}

    private AmazonDynamoDB amazonDynamoDb() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accesskey, secretkey)))
                .build();
    }


}

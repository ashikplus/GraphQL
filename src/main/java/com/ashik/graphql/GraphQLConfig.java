//package com.ashik.graphql;
//
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.util.FileCopyUtils;
//
//import graphql.schema.GraphQLSchema;
//import graphql.schema.idl.RuntimeWiring;
//import graphql.schema.idl.SchemaGenerator;
//import graphql.schema.idl.SchemaParser;
//import graphql.schema.idl.TypeDefinitionRegistry;
//
//@Configuration
//public class GraphQLConfig {
//	
//	@Bean
//    public GraphQLSchema graphQLSchema() {
//        SchemaParser schemaParser = new SchemaParser();
//        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(readSchemaFromFile("schema.graphqls"));
//
//        SchemaGenerator schemaGenerator = new SchemaGenerator();
//        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, buildRuntimeWiring());
//    }
//
//    private String readSchemaFromFile(String filePath) {
//        try {
//            Resource resource = new ClassPathResource(filePath);
//            return FileCopyUtils.copyToString(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));
//        } catch (IOException e) {
//            throw new IllegalStateException("Failed to read GraphQL schema file", e);
//        }
//    }
//
//    private RuntimeWiring buildRuntimeWiring() {
//        return RuntimeWiring.newRuntimeWiring().build();
//    }
//
//    @Bean
//    public QueryResolver queryResolver() {
//        return new QueryResolver();
//    }
//}

package api.util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

public class SpecBuilder {

    public static RequestSpecification createSpec() {

        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter());
        filters.add(new ErrorLoggingFilter());

        RequestSpecBuilder builder =  new RequestSpecBuilder();
        builder.setContentType(ContentType.JSON);
        builder.setBaseUri("https://petstore3.swagger.io");
        builder.addFilters(filters);

        return builder.build();

    }
}

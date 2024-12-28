package com.spring.graphql.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.execution.DataFetcherExceptionHandler;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class GraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        ErrorType errorType = null;

        if (ex instanceof DataIntegrityViolationException){
            errorType = ErrorType.BAD_REQUEST;
        }else {
            errorType = ErrorType.INTERNAL_ERROR;
        }
        return GraphqlErrorBuilder.newError(env)
                .errorType(errorType)
                .message(ex.getMessage())
                .build();
    }
}

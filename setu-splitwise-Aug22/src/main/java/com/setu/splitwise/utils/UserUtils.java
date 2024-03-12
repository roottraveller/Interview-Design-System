package com.setu.splitwise.utils;

import com.setu.splitwise.constants.Constants;
import com.setu.splitwise.exception.GenericException;
import com.setu.splitwise.model.request.CreateUserRequest;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.UUID;

@UtilityClass
public class UserUtils {

    public static String generateUserId() {
        return Constants.PREFIX_USER + UUID.randomUUID();
    }

    public static void validate(CreateUserRequest createUserRequest) {
        if (createUserRequest.getName() == null ||
                createUserRequest.getName().length() < 5 ||
                createUserRequest.getEmail() == null ||
                createUserRequest.getEmail().length() < 5) {
            throw GenericException.builder()
                    .httpCode(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .context(Map.of("reason", "empty field value or less than 5 length"))
                    .build();
        }
    }

}

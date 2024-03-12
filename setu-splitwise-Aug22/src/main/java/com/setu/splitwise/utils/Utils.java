package com.setu.splitwise.utils;

import com.setu.splitwise.exception.GenericException;
import lombok.experimental.UtilityClass;
import org.h2.util.StringUtils;
import org.springframework.http.HttpStatus;

import java.util.Map;

@UtilityClass
public class Utils {

    public static void validateUserId(String userId) {
        if (StringUtils.isNullOrEmpty(userId) ||
                StringUtils.isWhitespaceOrEmpty(userId)) {
            throw GenericException.builder()
                    .httpCode(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .context(Map.of("reason", "userId is empty"))
                    .build();
        }
    }

    public static void validateGroupId(String groupId) {
        if (StringUtils.isNullOrEmpty(groupId) ||
                StringUtils.isWhitespaceOrEmpty(groupId)) {
            throw GenericException.builder()
                    .httpCode(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .context(Map.of("reason", "empty field groupId"))
                    .build();
        }
    }

    public static void validate(String groupId, String userId) {
        if (StringUtils.isNullOrEmpty(groupId) ||
                StringUtils.isWhitespaceOrEmpty(groupId) ||
                StringUtils.isNullOrEmpty(userId) ||
                StringUtils.isWhitespaceOrEmpty(userId)) {
            throw GenericException.builder()
                    .httpCode(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .context(Map.of("reason", "empty field groupId or userId"))
                    .build();
        }
    }
}

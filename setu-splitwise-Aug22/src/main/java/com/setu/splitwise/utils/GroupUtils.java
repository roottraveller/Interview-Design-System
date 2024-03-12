package com.setu.splitwise.utils;

import com.setu.splitwise.constants.Constants;
import com.setu.splitwise.exception.GenericException;
import com.setu.splitwise.model.request.AddUsersToGroupRequest;
import com.setu.splitwise.model.request.CreateGroupRequest;
import com.setu.splitwise.model.request.RemoveUserFromGroupRequest;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.UUID;

@UtilityClass
public class GroupUtils {

    public static String generateGroupId() {
        return Constants.PREFIX_GROUP + UUID.randomUUID();
    }

    public static void validate(CreateGroupRequest createGroupRequest) {
        if (createGroupRequest == null ||
                createGroupRequest.getName() == null ||
                createGroupRequest.getType() == null ||
                createGroupRequest.getCreatedBy() == null) {
            throw GenericException.builder()
                    .httpCode(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .context(Map.of("reason", "empty field value"))
                    .build();
        }
    }


    public static void validate(AddUsersToGroupRequest addUsersToGroupRequest) {
        if (addUsersToGroupRequest == null ||
                addUsersToGroupRequest.getGroupId() == null ||
                CollectionUtils.isEmpty(addUsersToGroupRequest.getUidxList())) {
            throw GenericException.builder()
                    .httpCode(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .context(Map.of("reason", "groupId or userId empty"))
                    .build();
        }
    }

    public static void validate(RemoveUserFromGroupRequest removeUserFromGroupRequest) {
        if (removeUserFromGroupRequest == null ||
                removeUserFromGroupRequest.getGroupId() == null ||
                removeUserFromGroupRequest.getUserId() == null) {
            throw GenericException.builder()
                    .httpCode(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .context(Map.of("reason", "groupId or userId empty"))
                    .build();
        }
    }
}

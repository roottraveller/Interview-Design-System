package com.setu.splitwise.utils;

import com.setu.splitwise.constants.Constants;
import com.setu.splitwise.exception.GenericException;
import com.setu.splitwise.model.Expanse;
import com.setu.splitwise.model.request.CreateExpenseRequest;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.UUID;

@UtilityClass
public class ExpenseUtils {

    public static String generateTransactionId() {
        return Constants.PREFIX_TRANSACTION + UUID.randomUUID();
    }

    public static void validate(CreateExpenseRequest createExpenseRequest) {
        if (createExpenseRequest == null ||
                createExpenseRequest.getGroupId() == null ||
                createExpenseRequest.getDescription() == null ||
                createExpenseRequest.getCost() == 0 ||
                CollectionUtils.isEmpty(createExpenseRequest.getExpanses())) {
            throw GenericException.builder()
                    .httpCode(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .context(Map.of("reason", "empty field value"))
                    .build();
        }

        //TODO: validate userId belong to groupId
        long sum = 0;
        for (Expanse expanse : createExpenseRequest.getExpanses()) {
            sum += expanse.getPaidAmount();
            if (expanse.getUserId() == null) {
                throw GenericException.builder()
                        .httpCode(HttpStatus.BAD_REQUEST.value())
                        .httpStatus(HttpStatus.BAD_REQUEST.getReasonPhrase())
                        .context(Map.of("reason", "userId is empty"))
                        .build();
            }
        }

        if (sum != createExpenseRequest.getCost()) {
            throw GenericException.builder()
                    .httpCode(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .context(Map.of("reason", "price mismatch"))
                    .build();
        }
    }
}

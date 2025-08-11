package com.ncai.cheko.validator;

import com.ncai.cheko.dto.ItemRequest;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NoDuplicateItemIds.Validator.class)
@Documented
public @interface NoDuplicateItemIds {

    String message() default "DUPLICATE_ITEM_ID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Component
    final class Validator implements ConstraintValidator<NoDuplicateItemIds, List<ItemRequest>> {

        @Override
        public boolean isValid(List<ItemRequest> items, ConstraintValidatorContext context) {

            Set<Long> seen = new HashSet<>();
            boolean hasDuplicate = false;

            for (ItemRequest item : items) {
                Long id = item.getItemId();
                if (!seen.add(id)) {
                    hasDuplicate = true;
                    break;
                }
            }

            return !hasDuplicate;
        }
    }
}

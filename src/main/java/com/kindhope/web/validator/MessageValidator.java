package com.kindhope.web.validator;

import com.kindhope.entity.Message;
import com.kindhope.entity.User;
import com.kindhope.helper.form.FieldErrors;
import com.kindhope.helper.form.Fields;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Post form validator.
 *
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class MessageValidator implements Validator {
    private static final Logger LOG = Logger.getLogger(MessageValidator.class);

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Message object = (Message) o;
        LOG.trace("OBJECT TO VALIDATE => " + object);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, Fields.MESSAGE_CONTENT_FIELD, FieldErrors.FIELD_IS_REQUIRED_ERROR);
    }
}

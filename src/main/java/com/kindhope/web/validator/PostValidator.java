package com.kindhope.web.validator;

import com.kindhope.entity.Post;
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
public class PostValidator implements Validator {
    private static final Logger LOG = Logger.getLogger(PostValidator.class);

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Post object = (Post) o;
        LOG.trace("OBJECT TO VALIDATE => " + object);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, Fields.POST_FIELD, FieldErrors.FIELD_IS_REQUIRED_ERROR);
    }
}

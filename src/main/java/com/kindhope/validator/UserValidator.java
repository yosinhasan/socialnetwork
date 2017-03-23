package com.kindhope.validator;

import com.kindhope.entity.User;
import com.kindhope.helper.form.FieldErrors;
import com.kindhope.helper.form.Fields;
import com.kindhope.helper.form.Settings;
import com.kindhope.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User form validator.
 *
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class UserValidator implements Validator {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Logger LOG = Logger.getLogger(UserValidator.class);
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LOG.debug("VALIDATE USER START");
        User user = (User) o;
        LOG.trace("USER TO VALIDATE => " + user);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, Fields.USER_EMAIL_FIELD, FieldErrors.FIELD_IS_REQUIRED_ERROR);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail());
        if (!matcher.find()) {
            errors.rejectValue(Fields.USER_EMAIL_FIELD, FieldErrors.USER_EMAIL_INCORRECT_FORMAT_ERROR);
        }
        User oldUser = userService.findByEmail(user.getEmail());
        LOG.trace("OLD USER =============>>>" + oldUser);
        if (oldUser != null) {
            LOG.error("DUPLIATE EMAIL ERROR =============>>>");
            errors.rejectValue(Fields.USER_EMAIL_FIELD, FieldErrors.USER_EMAIL_DUBPLICATE_ERROR);
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, Fields.USER_PASSWORD_FIELD, FieldErrors.FIELD_IS_REQUIRED_ERROR);
        if (user.getPassword().length() < Settings.INPUT_USER_PASSWORD_MIN_LENGTH || user.getPassword().length() > Settings.INPUT_USER_PASSWORD_MAX_LENGTH) {
            LOG.error("PASSWORD LENGTH ERROR =============>>>");
            errors.rejectValue(Fields.USER_PASSWORD_FIELD, FieldErrors.USER_PASSWORD_INVALID_SIZE_ERROR);
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            LOG.error("USER PASSWORD  DOESN'T MATCH WITH REPEAT PASSWORD =============>>>");
            errors.rejectValue(Fields.USER_PASSWORD_CONFIRM_FIELD, FieldErrors.USER_PASSWORD_NOT_MATCH_ERROR);
        }
        LOG.debug("VALIDATE USER END");
    }
}

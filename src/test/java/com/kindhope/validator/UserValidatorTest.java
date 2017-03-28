package com.kindhope.validator;

import com.kindhope.entity.Blacklist;
import com.kindhope.entity.User;
import com.kindhope.helper.form.FieldErrors;
import com.kindhope.helper.form.Fields;
import com.kindhope.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.validation.Errors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>.
 */
public class UserValidatorTest {

    @Mock
    UserService service;

    @Mock
    Errors errors;

    @Spy
    User object;

    @InjectMocks
    UserValidator validator;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        object = getObject();
        doNothing().when(errors).rejectValue(Fields.USER_EMAIL_FIELD, FieldErrors.FIELD_IS_REQUIRED_ERROR, (Object[]) null, (String) null);
        doNothing().when(errors).rejectValue(Fields.USER_EMAIL_FIELD, FieldErrors.USER_EMAIL_DUBPLICATE_ERROR);
        doNothing().when(errors).rejectValue(Fields.USER_EMAIL_FIELD, FieldErrors.USER_EMAIL_INCORRECT_FORMAT_ERROR);
        doNothing().when(errors).rejectValue(Fields.USER_PASSWORD_FIELD, FieldErrors.FIELD_IS_REQUIRED_ERROR);
        doNothing().when(errors).rejectValue(Fields.USER_PASSWORD_FIELD, FieldErrors.USER_PASSWORD_INVALID_SIZE_ERROR);
        doNothing().when(errors).rejectValue(Fields.USER_PASSWORD_CONFIRM_FIELD, FieldErrors.USER_PASSWORD_NOT_MATCH_ERROR);

        when(service.findByEmail(any())).thenReturn(null);

    }

    @Test
    public void supports() throws Exception {
        assertTrue(validator.supports(User.class));
    }

    @Test
    public void supportsShouldReturnFalse() throws Exception {
        assertFalse(validator.supports(Blacklist.class));
    }

    @Test
    public void validate() throws Exception {
        validator.validate(object, errors);
        verify(errors, never()).rejectValue(Fields.USER_EMAIL_FIELD, FieldErrors.USER_EMAIL_INCORRECT_FORMAT_ERROR);
    }

    @Test
    public void validateEmailIncorrectFormat() throws Exception {
        object.setEmail("test");
        validator.validate(object, errors);
        verify(errors, atLeastOnce()).rejectValue(Fields.USER_EMAIL_FIELD, FieldErrors.USER_EMAIL_INCORRECT_FORMAT_ERROR);
    }

    @Test
    public void validateEmailExisted() throws Exception {
        when(service.findByEmail(any())).thenReturn(new User());
        validator.validate(object, errors);
        verify(errors, atLeastOnce()).rejectValue(Fields.USER_EMAIL_FIELD, FieldErrors.USER_EMAIL_DUBPLICATE_ERROR);
    }

    @Test
    public void validatePasswordIncorrectSize() throws Exception {
        object.setPassword("123");
        object.setPasswordConfirm("123");
        validator.validate(object, errors);
        verify(errors, atLeastOnce()).rejectValue(Fields.USER_PASSWORD_FIELD, FieldErrors.USER_PASSWORD_INVALID_SIZE_ERROR);
    }

    @Test
    public void validatePasswordNotMatch() throws Exception {
        object.setPassword("123");
        validator.validate(object, errors);
        verify(errors, atLeastOnce()).rejectValue(Fields.USER_PASSWORD_CONFIRM_FIELD, FieldErrors.USER_PASSWORD_NOT_MATCH_ERROR);
    }

    public User getObject() {
        User object = new User();
        object.setName("Test");
        object.setEmail("yosinhasan@gmail.com");
        object.setPassword("12345678910");
        object.setPasswordConfirm("12345678910");
        return object;
    }
}
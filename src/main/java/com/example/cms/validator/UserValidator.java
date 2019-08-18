package com.example.cms.validator;

import com.example.cms.models.User;
import com.example.cms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator {

    public static final String EMAIL_VERIFICATION = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        // username validation
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if(user.getUsername().length() < 6 || user.getUsername().length() >32){
            errors.rejectValue("username","Size.userForm.username");
        }
        if(userService.findByUsername(user.getUsername()) != null){
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        // email address validation
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if(user.getEmail().length() < 6 || user.getEmail().length() >32){
            errors.rejectValue("email","Size.userForm.email");
        }
        if(userService.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email", "Duplicate.userForm.email");
        }
        if(!user.getEmail().matches(EMAIL_VERIFICATION)){
            errors.rejectValue("email", "Invalid.userForm.email");
        }

        // password validation
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","NotEmpty");
        if(user.getPassword().length() < 8 || user.getPassword().length() > 32){
            errors.rejectValue("password","Size.userForm.password");
        }
        if(!user.getPasswordConfirm().equals(user.getPassword())){
            errors.rejectValue("passwordConfirm","Diff.userForm.passwordConfirm");
        }

    }
}


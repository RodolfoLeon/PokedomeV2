package com.lab206.pokedomev2.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lab206.pokedomev2.models.User;
import com.lab206.pokedomev2.repositories.UserRepository;

@Component
public class UserValidator implements Validator {
    
	private final UserRepository userRepo;
	public UserValidator(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        }
        User user2 = userRepo.findByUsername(user.getUsername());
        if (user2 != null) {
        	errors.rejectValue("email", "Unique");
        }
    }
}
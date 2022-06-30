package de.urr4.mealplanner.application.user;

import de.urr4.mealplanner.domain.user.User;

public interface UserRepository {

    User createUser(User user);

    User updateUser(User user);
}

package ie.aphral.service;

import ie.aphral.entities.User;

public interface UserService {
    User save(String email, String password, String role, String firstName, String lastName);
}

package com.ds.glitchreporter.dto;

/**
 * Data Transfer Object (DTO) for updating user roles in the GlitchReporter application.
 * This class is used to transfer role-related information when updating a user's role.
 */

public class RoleUpdateDTO {
	
	/**
     * The new user role represented as a string, such as "[ROLE_ADMIN]" or "[ROLE_USER]"
     */
	
    private String newRoleString;

    // getter and setter
    public String getNewRoleString() {
        return newRoleString;
    }
    
    /**
     * Retrieves the new user role as a string.
     *
     * @return The new user role.
     */

    public void setNewRoleString(String newRoleString) {
        this.newRoleString = newRoleString;
    }
}
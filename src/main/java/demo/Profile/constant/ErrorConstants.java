package demo.Profile.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorConstants {

    public static final String INVALID_DATE = "Invalid date.";
    public static final String INVALID_FORMAT_FOR_FIRST_NAME = """
            Invalid format for first name. Name must start with capital letter and contain only characters.""";
    public static final String INVALID_FORMAT_FOR_LAST_NAME = """
            Invalid format for last name. Name must start with capital letter and contain only characters.
            """;
    public static final String PROFILE_NOT_FOUND = "Profile not found for user with id: %d.";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error.";
}
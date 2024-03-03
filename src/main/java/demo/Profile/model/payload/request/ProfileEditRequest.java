package demo.Profile.model.payload.request;

import demo.Profile.constant.ErrorConstants;
import demo.Profile.constant.RegexConstants;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record ProfileEditRequest(

        @Pattern(regexp = RegexConstants.NAME_REGEX, message = ErrorConstants.INVALID_FORMAT_FOR_FIRST_NAME)
        String firstName,

        @Pattern(regexp = RegexConstants.NAME_REGEX, message = ErrorConstants.INVALID_FORMAT_FOR_LAST_NAME)
        String lastName,

        @Past(message = ErrorConstants.INVALID_DATE)
        LocalDate bornOn) {
}
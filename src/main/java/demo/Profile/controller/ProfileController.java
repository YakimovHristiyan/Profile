package demo.Profile.controller;

import demo.Profile.constant.HeaderConstants;
import demo.Profile.model.payload.request.ProfileEditRequest;
import demo.Profile.model.payload.response.ProfileResponse;
import demo.Profile.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;

    @PutMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public ProfileResponse edit(@Valid @RequestBody ProfileEditRequest profileEditRequest,
                                @RequestHeader(HeaderConstants.USER_ID) Long userId) {
        return this.profileService.edit(profileEditRequest, userId);
    }

    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public ProfileResponse getById(@RequestHeader(HeaderConstants.USER_ID) Long userId) {
        return this.profileService.getByUserId(userId);
    }
}
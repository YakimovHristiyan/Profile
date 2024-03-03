package demo.Profile.service;

import demo.Profile.model.payload.request.ProfileEditRequest;
import demo.Profile.model.payload.response.ProfileResponse;

public interface ProfileService {

    ProfileResponse edit(ProfileEditRequest profileEditRequest, Long userId);

    ProfileResponse getByUserId(Long userId);
}
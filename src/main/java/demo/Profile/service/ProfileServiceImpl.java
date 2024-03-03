package demo.Profile.service;

import demo.Profile.constant.ErrorConstants;
import demo.Profile.constant.KafkaConstants;
import demo.Profile.constant.TopicConstants;
import demo.Profile.exception.ProfileNotFoundException;
import demo.Profile.mapper.ProfileMapper;
import demo.Profile.model.event.RegistrationEvent;
import demo.Profile.model.payload.request.ProfileEditRequest;
import demo.Profile.model.payload.response.ProfileResponse;
import demo.Profile.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    @Override
    public ProfileResponse edit(ProfileEditRequest profileEditRequest, Long userId) {
        return this.profileRepository.findById(userId)
                .map(existingProfile -> this.profileMapper.map(profileEditRequest, existingProfile))
                .map(this.profileRepository::save)
                .map(this.profileMapper::map)
                .orElseThrow(() -> new ProfileNotFoundException(
                        String.format(ErrorConstants.PROFILE_NOT_FOUND, userId))
                );
    }

    @Override
    public ProfileResponse getByUserId(Long userId) {
        return this.profileRepository.findById(userId)
                .map(this.profileMapper::map)
                .orElseThrow(() -> new ProfileNotFoundException(
                        String.format(ErrorConstants.PROFILE_NOT_FOUND, userId))
                );
    }

    @KafkaListener(topics = TopicConstants.REGISTRATION_TOPIC,
            containerFactory = KafkaConstants.KAFKA_CONSUMER_FACTORY)
    private void register(RegistrationEvent event) {
        this.profileRepository.save(this.profileMapper.map(event));
    }
}
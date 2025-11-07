package com.finefit.auth.service;


import com.finefit.domain.entity.UserEntity;
import com.finefit.domain.model.type.FailedResultType;
import com.finefit.domain.repository.UserRepository;
import com.finefit.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    UserEntity user = userRepository.findById(Long.parseLong(userId))
        .orElseThrow(() -> new GlobalException(FailedResultType.FAILED_USER_NOT_FOUND));

    return org.springframework.security.core.userdetails.User.builder()
        .username(user.getTrainerId())
        .password("")
        .build();
  }
}

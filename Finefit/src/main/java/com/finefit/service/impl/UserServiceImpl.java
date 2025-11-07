package com.finefit.service.impl;

import com.finefit.auth.JwtUtil;
import com.finefit.domain.entity.UserEntity;
import com.finefit.domain.model.dto.LoginDTO;
import com.finefit.domain.model.dto.RegisterDTO;
import com.finefit.domain.model.dto.ResultResponse;
import com.finefit.domain.model.dto.UserDTO;
import com.finefit.domain.model.type.FailedResultType;
import com.finefit.domain.model.type.SuccessResultType;
import com.finefit.domain.model.type.TokenType;
import com.finefit.domain.repository.UserRepository;
import com.finefit.exception.GlobalException;
import com.finefit.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final JwtUtil jwtUtil;
  private final BCryptPasswordEncoder passwordEncoder;

  public UserEntity getUserByAccessToken(HttpServletRequest request) {
    return userRepository.findById(jwtUtil.getUserId(request))
        .orElseThrow(() -> new GlobalException(FailedResultType.FAILED_USER_NOT_FOUND));
  }

  @Override
  public ResultResponse register(RegisterDTO registerDTO) {
    userRepository.save(RegisterDTO.toTrainerEntity(registerDTO, passwordEncoder.encode(registerDTO.getPassword())));

    return ResultResponse.of(SuccessResultType.SUCCESS_ADMIN_REGISTER);
  }

  @Override
  public ResultResponse validateId(String trainerId) {
    boolean isDuplicate = userRepository.existsByTrainerId(trainerId);

    log.info(isDuplicate ? "중복된 아이디" : "사용가능한 아이디");
    return new ResultResponse(SuccessResultType.SUCCESS_VALIDATE_ID, isDuplicate);
  }

  @Override
  public ResultResponse login(LoginDTO loginDTO, HttpServletResponse httpServletResponse) {
    UserEntity user = userRepository.findByTrainerId(loginDTO.getTrainerId())
        .orElseThrow(() -> new GlobalException(FailedResultType.FAILED_USER_NOT_FOUND));

    switch (user.getApprovalStatus()) {
      case PENDING -> throw new GlobalException(FailedResultType.FAILED_ACCESS_PENDING);
      case REJECTED -> throw new GlobalException(FailedResultType.FAILED_ACCESS_REJECTED);
    }

    if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
      throw new GlobalException(FailedResultType.FAILED_PASSWORD_MISMATCH);
    }

    String access = jwtUtil.createJwt("access", user.getUserId(), user.getRole());
    String refresh = jwtUtil.createJwt("refresh", user.getUserId(), user.getRole());

    httpServletResponse.addHeader(TokenType.ACCESS.getValue(), "Bearer " + access);
    httpServletResponse.addCookie(jwtUtil.setCookie(refresh));

    return ResultResponse.of(SuccessResultType.SUCCESS_ADMIN_LOGIN);
  }

  @Override
  public ResultResponse getUserInfo(HttpServletRequest request) {
    UserEntity user = getUserByAccessToken(request);

    UserDTO userDTO = UserDTO.toUserDTO(user);

    return new ResultResponse(SuccessResultType.SUCCESS_GET_USER_INFO, userDTO);
  }
}

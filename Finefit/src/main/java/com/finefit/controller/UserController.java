package com.finefit.controller;

import com.finefit.domain.model.dto.LoginDTO;
import com.finefit.domain.model.dto.RegisterDTO;
import com.finefit.domain.model.dto.ResultResponse;
import com.finefit.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @PostMapping("/auth/register")
  public ResponseEntity<ResultResponse> register(@RequestBody RegisterDTO registerDTO) {

    ResultResponse response = userService.register(registerDTO);
    return new ResponseEntity<>(response, response.getStatus());
  }

  @GetMapping("/auth/validate-id")
  public ResponseEntity<ResultResponse> validateId(@RequestParam("trainerId") String trainerId) {

    ResultResponse response = userService.validateId(trainerId);
    return new ResponseEntity<>(response, response.getStatus());
  }

  @PostMapping("/auth/login")
  public ResponseEntity<ResultResponse> login(HttpServletResponse httpServletResponse, @RequestBody LoginDTO loginDTO) {

    ResultResponse response = userService.login(loginDTO, httpServletResponse);
    return new ResponseEntity<>(response, response.getStatus());
  }

  @GetMapping("/auth/user-info")
  public ResponseEntity<ResultResponse> getUserInfo(HttpServletRequest request)
  {

    ResultResponse response = userService.getUserInfo(request);
    return new ResponseEntity<>(response, response.getStatus());
  }

}

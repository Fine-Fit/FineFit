package com.finefit.service;

import com.finefit.domain.model.dto.LoginDTO;
import com.finefit.domain.model.dto.RegisterDTO;
import com.finefit.domain.model.dto.ResultResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {

  ResultResponse register(RegisterDTO registerDTO);

  ResultResponse validateId(String id);

  ResultResponse login(LoginDTO loginDTO, HttpServletResponse httpServletResponse);

  ResultResponse getUserInfo(HttpServletRequest request);
}

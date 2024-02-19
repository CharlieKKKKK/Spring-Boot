package com.vtxlab.bootcamp.bccryptocoingecko.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.bootcamp.bccryptocoingecko.infra.ApiResponse;
import com.vtxlab.bootcamp.bccryptocoingecko.model.dto.jph.Coin;

public interface Operation {

  @GetMapping(value = "/allCoins")
  ApiResponse<List<Coin>> getAllCoins(@RequestParam(value = "currency", required = true) String currency);


  @GetMapping(value = "/coins")
  ApiResponse<List<Coin>> getCoins(@RequestParam(value = "currency", required = true) String currency,
      @RequestParam(value = "ids", required = false) String ids);
}

package com.vivalahm.coinhub.controller;


import com.vivalahm.coinhub.service.CommonMarketService;
import com.vivalahm.coinhub.service.MarketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MarketController {
  private final Map<String, MarketService> marketServices;
  private static final Logger logger = LoggerFactory.getLogger(MarketController.class);
  private final CommonMarketService commonMarketService;

  @GetMapping("/price") // 코인의 최근 가격: 어떤 마켓, 어떤 코인인지
  public double getPrice(@RequestParam String market, String coin) {
    logger.info("market: {}, coin: {}", market, coin);
    Double resultMessage = commonMarketService.getPrice(market, coin);
    return resultMessage;
  }

  @GetMapping("/Coins") // 코인의 최근 가격: 어떤 마켓, 어떤 코인인지
  public List<String> getCoins(@RequestParam String market) {
    logger.info("market: {}", market);
    return commonMarketService.getMarketService(marketServices, market).getCoins();
  }

  @GetMapping("/common-Coins")
  public List<String> getCommonCoins(@RequestParam String fromMarket, String toMarket) {
    logger.info("fromMarket: {}, toMarket: {}", fromMarket, toMarket);
    return commonMarketService.getCommonCoin(fromMarket, toMarket);
  }
}

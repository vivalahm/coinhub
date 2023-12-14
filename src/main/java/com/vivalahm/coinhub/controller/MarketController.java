package com.vivalahm.coinhub.controller;


import com.vivalahm.coinhub.service.MarketPort;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MarketController {
  private  static final Logger logger = LoggerFactory.getLogger(MarketController.class);
  private final MarketPort marketPort;

    public MarketController(MarketPort marketPort) {
        this.marketPort = marketPort;
    }

    @GetMapping("/price") // 코인의 최근 가격: 어떤 마켓, 어떤 코인인지
  public double getPrice(
    @RequestParam
    String market,
    String coin
  ) {
    logger.info("market: {}, coin: {}", market, coin);
    Double resultMessage = marketPort.getPrice(market, coin);
      return resultMessage;
  }
}

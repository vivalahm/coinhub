package com.vivalahm.coinhub.service;

import com.vivalahm.coinhub.feign.UpbitFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpbitMarketService implements MarketService {
  private final UpbitFeignClient upbitFeignClient;
  @Override
  public double getCoinCurrentPrice(String coin) {
    return upbitFeignClient.getCoinPrice("KRW-" + coin.toUpperCase())
      .get(0)
      .getTrade_price();
  }

  public List<String> getCoins() {
    return List.of("A","B","D");
  }
}

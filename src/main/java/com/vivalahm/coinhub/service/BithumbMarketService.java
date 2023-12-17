package com.vivalahm.coinhub.service;

import com.vivalahm.coinhub.feign.BithumbFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BithumbMarketService implements MarketService {
  private final BithumbFeignClient bithumbFeignClient;
  @Override
  public double getCoinCurrentPrice(String coin) {
    return Double.parseDouble(bithumbFeignClient.getCoinPrice(coin.toUpperCase() + "_KRW")
      .getData()
      .getClosing_price());
  }

  public List<String> getCoins() {
    return List.of("A","B","C");
  }
}

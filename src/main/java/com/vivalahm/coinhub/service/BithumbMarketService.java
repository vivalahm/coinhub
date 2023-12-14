package com.vivalahm.coinhub.service;

import org.springframework.stereotype.Service;

@Service
public class BithumbMarketService implements MarketService {
  @Override
  public double getCoinCurrentPrice(String coin) {
    return 2;
  }
}

package com.vivalahm.coinhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CommonMarketService implements MarketPort {
  @Autowired
  Map<String, MarketService> marketServices;
  @Override
  public double getPrice(String market, String coin) {
    MarketService marketService = null;


      for(String key : marketServices.keySet()) {
        if(key.substring(0,market.length()).equals(market.toLowerCase())) {
          marketService = marketServices.get(key);
        }
      }
    return marketService.getCoinCurrentPrice(coin);
  }
}

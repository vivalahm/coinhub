package com.vivalahm.coinhub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class CoinBuyDTO {
  // 살수 있는 코인의 양 (key: 코인 이름, value: 코인의 양)
  private Map<String, Double> amount;
  // 코인의 매수 호가 (key: 코인 이름, value: 값대비 수량)
  private Map<String, Map<Double, Double>> orderBooks;
}

package com.vivalahm.coinhub.view;

import com.vivalahm.coinhub.dto.TransferCalculateDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class TransferCalculateResponseView {
  private String coin;
  private Double amount;
  private Map<Double, Double> buyOrderBook;
  private Map<Double, Double> sellOrderBook;

  //TODO: DTO => View 로 변경

  public static TransferCalculateResponseView of(TransferCalculateDTO transferCalculateDTO) {
    return new TransferCalculateResponseView(transferCalculateDTO.getCoin(),
        transferCalculateDTO.getAmount(),
        transferCalculateDTO.getBuyOrderBook(),
        transferCalculateDTO.getSellOrderBook());
  }

}

package com.vivalahm.coinhub.service;

import com.vivalahm.coinhub.dto.CoinBuyDTO;
import com.vivalahm.coinhub.dto.CoinSellDTO;
import com.vivalahm.coinhub.dto.TransferCalculateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TransferCalculateService {

  private final CommonMarketService commonMarketService;
  private final Map<String, MarketService> marketServices;

  public TransferCalculateDTO calculate(String fromMarket, String toMarket, Double amount) {

    //TODO: fromMarket, toMarket: common coin 가져오기
    List<String> commonCoins = commonMarketService.getCommonCoin(fromMarket, toMarket);
    //TODO: fromMarket에서 얼마에 살수 있는지 계산
    CoinBuyDTO fromMarketBuyDto = fromMarketService.calculateBuy(commonCoins, amount);
    //TODO: 이체 수수료 계산
    Map<String, Double> fromMarketTransferFee = fromMarketService.calculateTransferFee(commonCoins, amount);
    //TODO: toMarket에서 얼마에 팔수 있는지 계산
    CoinSellDTO toMarketSellDto = fromMarketService.calculateBuy(commonCoins, amount);

    // TODO: 가장 높은 값을 받을 수 있는 코인선택
    String transferCoin = toMarketSellDto.getAmount().keySet().get(0); // TODO: 이게 가장 높은 값 받을 수 있는 코인

    return new TransferCalculateDTO(
      transferCoin,
      toMarketSellDto.getAmount().get(transferCoin),
      fromMarketBuyDto.getOrderBooks().get(transferCoin),
      toMarketSellDto.getOrderBooks().get(transferCoin)
    ) ;
  }
}

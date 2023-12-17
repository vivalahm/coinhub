package com.vivalahm.coinhub.controller;

import com.vivalahm.coinhub.service.TransferCalculateService;
import com.vivalahm.coinhub.view.TransferCalculateResponseView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TransferCalculateController
{
  private final TransferCalculateService transferCalulateService;
  @GetMapping("/transfer-calculate")
  public TransferCalculateResponseView getPrice(@RequestParam String fromMarket, @RequestParam String toMarket, @RequestParam Double amount)
  {
    return TransferCalculateResponseView.of(transferCalulateService.calculate(fromMarket, toMarket, amount));
  }
}

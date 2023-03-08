package com.challenge.rewardsService.controller;

import com.challenge.rewardsService.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/api/rewards")
public class RewardsController {

    @Autowired RewardsService rewardsService;

    @GetMapping("/{customerId}")
    public Map<String, Integer> getRewardsByMonth(@Valid @NotNull(message = "customerId must not be null") @PathVariable Long customerId) {
        return rewardsService.calculateRewards(customerId);
    }

}

package com.challenge.rewardsService.controller;

import com.challenge.rewardsService.service.RewardsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class RewardsControllerTest {

    @InjectMocks
    private RewardsController subject;
    @Mock
    private RewardsService rewardsService;

    @Test
    public void getRewardsByMonth_shouldCallRewardsServiceAndGetRewardsByMonth() {
        long customerId = 1;
        Map<String, Integer> expected = new HashMap<>();
        expected.put("FEBRUARY 2023", 120);
        expected.put("MARCH 2023", 52);

        when(rewardsService.calculateRewards(customerId)).thenReturn(expected);

        Map<String, Integer> actual = subject.getRewardsByMonth(customerId);

        assertEquals(expected, actual);
        verify(rewardsService).calculateRewards(customerId);
    }
}
package com.challenge.rewardsService.service;

import com.challenge.rewardsService.entity.TransactionEntity;
import com.challenge.rewardsService.exception.DatabaseException;
import com.challenge.rewardsService.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class RewardsServiceTest {
    @InjectMocks RewardsService subject;

    @Mock
    TransactionRepository transactionRepository;

    @Test
    public void calculateRewards_shouldReturnRewardsByMonth_forGivenCustomerId() {
        long customerId = 1;

        TransactionEntity transaction1 = TransactionEntity.builder()
                .id(1L)
                .customerId(customerId)
                .transactionDate(LocalDate.of(2023, 2, 1))
                .transactionAmount(120.00)
                .build();
        TransactionEntity transaction2 = TransactionEntity.builder()
                .id(2L)
                .customerId(customerId)
                .transactionDate(LocalDate.of(2023, 2, 15))
                .transactionAmount(75.00)
                .build();
        TransactionEntity transaction3 = TransactionEntity.builder()
                .id(3L)
                .customerId(customerId)
                .transactionDate(LocalDate.of(2023, 3, 1))
                .transactionAmount(50.00)
                .build();

        List<TransactionEntity> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("FEBRUARY 2023", 115);
        expected.put("MARCH 2023", 0);

        when(transactionRepository.findByCustomerId(customerId)).thenReturn(transactions);

        Map<String, Integer> actual = subject.calculateRewards(customerId);

        assertEquals(expected, actual);
    }

    @Test
    public void calculateRewards_shouldThrowDatabaseException_whenDatabaseIsDown(){
        long customerId = 1;

        when(transactionRepository.findByCustomerId(customerId)).thenThrow(RuntimeException.class);
        assertThrows(DatabaseException.class, () -> subject.calculateRewards(customerId));
    }
}
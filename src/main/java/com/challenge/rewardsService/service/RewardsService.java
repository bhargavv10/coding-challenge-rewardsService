package com.challenge.rewardsService.service;

import com.challenge.rewardsService.entity.TransactionEntity;
import com.challenge.rewardsService.exception.DatabaseException;
import com.challenge.rewardsService.exception.RewardsServiceExceptionHandler;
import com.challenge.rewardsService.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RewardsService {
    private static final Logger LOG = LoggerFactory.getLogger(RewardsService.class.getName());

    @Autowired TransactionRepository transactionRepository;

    public Map<String, Integer> calculateRewards(Long customerId) {

        List<TransactionEntity> transactions = getTransactionEntities(customerId);

        return transactions.stream()
                .collect(Collectors.groupingBy(transactionEntity -> {
                    LocalDate transactionDate = transactionEntity.getTransactionDate();
                    return transactionDate.getMonth().toString() + " " + transactionDate.getYear();
                }, Collectors.summingInt(transactionEntity -> {
                    double amount = transactionEntity.getTransactionAmount();
                    int points = 0;

                    if (amount > 100) {
                        points += Math.round((amount - 100) * 2);
                        amount = 100;
                    }

                    if (amount > 50) {
                        points += Math.round(amount - 50);
                    }

                    return points;
                })));
    }

    private List<TransactionEntity> getTransactionEntities(Long customerId) {
        try {
            List<TransactionEntity> transactions = transactionRepository.findByCustomerId(customerId);
            return transactions;
        } catch (Exception e) {
            LOG.error("getTransactionEntities failed: " + e.getMessage());
            throw new DatabaseException("getTransactionEntities failed: " + e.getMessage());
        }
    }

}


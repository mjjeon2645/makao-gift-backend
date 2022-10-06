package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.exceptions.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Transactional
public class OrderHistoryService {
  private final OrderHistoryRepository orderHistoryRepository;

  public OrderHistoryService(OrderHistoryRepository orderHistoryRepository) {
    this.orderHistoryRepository = orderHistoryRepository;
  }

  public List<OrderHistory> histories(String sender) {

    return orderHistoryRepository.findAllBySender(sender);
  }

  public OrderHistory detail(Long historyId) {

    OrderHistory found = orderHistoryRepository.findById(historyId)
        .orElseThrow(() -> new OrderHistoryNotFound());

    return found;
  }
}

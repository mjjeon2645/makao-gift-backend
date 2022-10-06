package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.dtos.*;
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
}

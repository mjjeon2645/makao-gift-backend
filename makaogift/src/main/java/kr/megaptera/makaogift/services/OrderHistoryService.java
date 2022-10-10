package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.exceptions.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.repositories.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class OrderHistoryService {
  private final OrderHistoryRepository orderHistoryRepository;
  private Pageable pageable;

  public OrderHistoryService(OrderHistoryRepository orderHistoryRepository) {
    this.orderHistoryRepository = orderHistoryRepository;
  }

  // 구입 내역이 최근순으로 오는 것이 상식선에서 무난할듯.
  public Page<OrderHistory> histories(String sender, int page) {
    Sort sort = Sort.by("createdAt").descending();
    pageable = PageRequest.of(page - 1, 8, sort);

    return orderHistoryRepository.findAllBySender(sender, pageable);
  }

  public int getPages(String sender) {
    return orderHistoryRepository.findAllBySender(sender, pageable).getTotalPages();
  }

  public OrderHistory detail(Long historyId) {

    OrderHistory found = orderHistoryRepository.findById(historyId)
        .orElseThrow(() -> new OrderHistoryNotFound());

    return found;
  }
}

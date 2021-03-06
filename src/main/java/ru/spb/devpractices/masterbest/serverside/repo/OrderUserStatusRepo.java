package ru.spb.devpractices.masterbest.serverside.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spb.devpractices.masterbest.serverside.model.order.OrderUserStatus;

@Repository
public interface OrderUserStatusRepo extends JpaRepository<OrderUserStatus, OrderUserStatusId> {

//    OrderUserStatus findAllByUserAndAndOrder(Long user, String order);
}

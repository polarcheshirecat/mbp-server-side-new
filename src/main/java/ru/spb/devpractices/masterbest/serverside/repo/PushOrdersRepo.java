package ru.spb.devpractices.masterbest.serverside.repo;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.stereotype.Repository;import ru.spb.devpractices.masterbest.serverside.model.order.PushOrderInfo;@Repositorypublic interface PushOrdersRepo extends JpaRepository<PushOrderInfo, Long> { }
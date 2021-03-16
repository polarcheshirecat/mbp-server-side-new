package ru.spb.devpractices.masterbest.serverside.services.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spb.devpractices.masterbest.serverside.model.order.PushOrderInfo;
import ru.spb.devpractices.masterbest.serverside.repo.PushOrdersRepo;

@Service
@AllArgsConstructor
public class PushOrdersService {

    private final PushOrdersRepo pushOrdersRepo;

    public void save (PushOrderInfo pushOrderInfo){
        pushOrdersRepo.save(pushOrderInfo);
    }
}

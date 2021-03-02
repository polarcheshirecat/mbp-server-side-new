package ru.spb.devpractices.masterbest.serverside.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.spb.devpractices.masterbest.serverside.dto.OrderInfoDTO;
import ru.spb.devpractices.masterbest.serverside.model.order.Order;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderInfoMapper {

    @Mapping(target = "ikeaNumber", source = "ikea_number")
    @Mapping(target = "customerAddress", source = "customer_address")
    @Mapping(target = "dateStart", dateFormat = "dd-MM-yyyy hh:mm", source = "date_start")
    OrderInfoDTO toDto (Order order);
}

package ru.spb.devpractices.masterbest.serverside.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.spb.devpractices.masterbest.serverside.dto.front.OrderItemDTO;
import ru.spb.devpractices.masterbest.serverside.model.order.OrderItem;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderItemDTOMapper {

    OrderItemDTO toDTO (OrderItem item);
    OrderItem toEntity (OrderItemDTO dto);
}

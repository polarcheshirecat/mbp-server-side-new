package ru.spb.devpractices.masterbest.serverside.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.spb.devpractices.masterbest.serverside.dto.UserOrderStatusDTO;
import ru.spb.devpractices.masterbest.serverside.model.order.OrderUserStatus;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderUserStatusMapper {

    @Mapping(target = "order", source = "orderNumber")
    @Mapping(target = "user", source = "userID")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "comment", source = "comment")
    OrderUserStatus toEntity (UserOrderStatusDTO entity);
}

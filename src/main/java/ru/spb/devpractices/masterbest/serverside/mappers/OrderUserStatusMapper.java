package ru.spb.devpractices.masterbest.serverside.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderUserStatusMapper {

//    @Mapping(target = "orderId", source = "ikeaNumber")
//    @Mapping(target = "userId", source = "userID")
//    @Mapping(target = "mbNumber", source = "mbNumber")
//    @Mapping(target = "status", source = "status")
//    @Mapping(target = "comment", source = "comment")
//    OrderUserStatus toEntity (OrderStatusDTO dto);
//
//    @Mapping(target = "ikeaNumber", source = "orderId")
//    @Mapping(target = "userID", source = "userId")
//    @Mapping(target = "mbNumber", source = "mbNumber")
//    @Mapping(target = "status", source = "status")
//    @Mapping(target = "comment", source = "comment")
//    OrderStatusDTO toDTO (OrderUserStatus entity);
//
//    default String map (OrderStatus status){
//        return status.getDescription();
//    }
//
//    default OrderStatus map (String descr){
//        return OrderStatus.getStatusByDescription(descr);
//    }


}

package ru.spb.devpractices.masterbest.serverside.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

//    @Mapping(source = "ikea_number", target = "ikeaNumber")
//    @Mapping(source = "date_start", target = "dateStart", dateFormat = "dd-MM-yyyy hh:mm")
//    @Mapping(source = "date_end", target = "dateEnd", dateFormat = "dd-MM-yyyy hh:mm")
//    @Mapping(source = "customer_name", target = "customerName")
//    @Mapping(source = "customer_address", target = "customerAddress")
//    @Mapping(source = "customer_phone", target = "customerPhone")
//    @Mapping(source = "comment", target = "comment")
//    @Mapping(source = "order_type", target = "orderType")
//    @Mapping(source = "orderItems", target = "orderItems")
//    OrderDTO orderToOrderDto (Order order);
//
//    default String map(OrderType type){
//        return type.getName();
//    }

}

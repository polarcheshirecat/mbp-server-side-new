//package ru.spb.devpractices.masterbest.serverside.mappers;////import org.mapstruct.Mapper;//import org.mapstruct.Mapping;//import org.mapstruct.MappingTarget;//import ru.spb.devpractices.masterbest.serverside.dto.IntegrationOrderDTO;//import ru.spb.devpractices.masterbest.serverside.model.order.IkeaArticle;//import ru.spb.devpractices.masterbest.serverside.model.order.Order;////@Mapper(componentModel = "spring", uses=IntegrationOrderItemMapper.class)//public interface IntegrationOrderMapper {////    @Mapping(target ="numberMB", source="mb_number")//    @Mapping(target ="numberIkea", source="ikea_number")//    @Mapping(target ="dateStart", source="date_start")//    @Mapping(target ="orderType", source="order_type.name")//    @Mapping(target ="client", source="customer_name")//    @Mapping(target ="address", source="customer_address")//    @Mapping(target ="telefon", source="customer_phone")//    @Mapping(target ="sumVerify", ignore = true)//    @Mapping(target ="sumVerifyNoNDS", ignore = true)//    @Mapping(target ="sumRange", ignore = true)//    @Mapping(target ="sumRangeBuh", ignore = true)//    @Mapping(target ="falseVisit", source="falseVisit")//    @Mapping(target ="commentForCPK", ignore = true)//    @Mapping(target ="commentOperator", source="comment")//    IntegrationOrderDTO toDTO (Order order);////////////    Order toEntity (IntegrationOrderDTO dto);////////}
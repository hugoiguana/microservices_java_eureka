package microservices.java.eureka.sales.config.orika.mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.MappingDirection;
import microservices.java.eureka.sales.dto.SalesDto;
import microservices.java.eureka.sales.model.ApplicationUser;
import microservices.java.eureka.sales.model.ItemOrder;
import microservices.java.eureka.sales.model.Order;
import microservices.java.eureka.sales.model.Product;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SalesDtoMapper extends CustomMapper<SalesDto, Order> {

    public SalesDtoMapper(MapperFactory mapperFactory) {
        mapperFactory.classMap(SalesDto.class, Order.class)
                .customize(this)
                .byDefault(MappingDirection.A_TO_B)
                .register();
    }

    @Override
    public void mapAtoB(SalesDto salesDto, Order order, MappingContext context) {
        Set<ItemOrder> items = salesDto.getItems().stream().map(i -> {
            Product product = Product.builder().id(i.getProductId()).build();
            return ItemOrder.builder().product(product).quantity(i.getQuantity()).build();
        }).collect(Collectors.toSet());

        order.addItems(items);
        order.setCustomer(ApplicationUser.builder().id(salesDto.getCustomerId()).build());
    }
}

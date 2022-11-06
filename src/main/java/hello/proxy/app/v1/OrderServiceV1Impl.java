package hello.proxy.app.v1;

public class OrderServiceV1Impl implements OrderServiceV1{

    private final OrderRepositoryV1 orderReporsitory;

    public OrderServiceV1Impl(OrderRepositoryV1 orderReporsitory) {
        this.orderReporsitory = orderReporsitory;
    }

    @Override
    public void orderItem(String itemId) {
        orderReporsitory.save(itemId);
    }
}

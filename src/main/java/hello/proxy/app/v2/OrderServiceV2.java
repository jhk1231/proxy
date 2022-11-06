package hello.proxy.app.v2;

public class OrderServiceV2 {

    private final OrderRepositoryV2 orderReporsitory;

    public OrderServiceV2(OrderRepositoryV2 orderReporsitory) {
        this.orderReporsitory = orderReporsitory;
    }

    public void orderItem(String itemId) {
        orderReporsitory.save(itemId);
    }
}

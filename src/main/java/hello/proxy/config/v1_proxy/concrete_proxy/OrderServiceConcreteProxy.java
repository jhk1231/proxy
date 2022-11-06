package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.trace.LogTrace;
import hello.trace.TraceStatus;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderServiceV2 target,
                                     LogTrace logTrace) {
        super(null); // 부모의 기능은 사용하지 않을것이기 때문에 null 주입
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {

        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.orderItem");

            target.orderItem(itemId);
            logTrace.end(status);
        } catch (Exception ex) {
            logTrace.exception(status, ex);
            throw ex;
        }
    }
}

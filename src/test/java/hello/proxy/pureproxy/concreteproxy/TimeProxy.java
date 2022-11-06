package hello.proxy.pureproxy.concreteproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic{

    private ConcreteLogic concreteLogic;

    public TimeProxy(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    @Override
    public String operation() {
      log.info("TimeDecorator 실행");
        long startTiem = System.currentTimeMillis();

        String result = concreteLogic.operation();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTiem;
        log.info("TimeDecorator 종료 resultTime={}ms", resultTime);
        return result;
    }
}

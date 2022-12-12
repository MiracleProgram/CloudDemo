package com.siven.service;

import com.siven.pojo.Dept;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/*降级的配置类*/
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {


    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public Dept get(Long id) {
                return new Dept().setDeptNo(id).setDname("id=>"+id+",没有对应的信息，客户端提供了降级服务，这给服务已经被关闭了");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public Boolean add(Dept dept) {
                return null;
            }
        };
    }
}

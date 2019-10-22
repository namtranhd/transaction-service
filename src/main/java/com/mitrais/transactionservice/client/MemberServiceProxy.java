package com.mitrais.transactionservice.client;

import com.mitrais.transactionservice.domain.Member;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "member-service", url = "localhost:8081/api/member")
@FeignClient(name = "member-service")
@RibbonClient(name = "member-service")
@EnableDiscoveryClient
public interface MemberServiceProxy {
    @GetMapping
    Member getAllMember();
}

package com.example.chopeeweb.task;

import com.example.chopeebiz.dto.QueryOrderListDto;
import com.example.chopeedao.po.OrderInfo;
import com.example.chopeeservice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.List;


@Configuration
@EnableScheduling
public class OrderFinishTask {

    @Autowired
    private OrderService orderService;

    // 添加定时任务
//        @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
//        @Scheduled(fixedRate=5000)
    private void configureTasks() {
        List<OrderInfo> orderList = orderService.SelectUnCompletedOrderList();
        orderList.stream().forEach(o -> {
            QueryOrderListDto queryOrderListDto = new QueryOrderListDto();
            queryOrderListDto.setOrderId(o.getId());
            orderService.completeOrder(queryOrderListDto);
        });
    }

}

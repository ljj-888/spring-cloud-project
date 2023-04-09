package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import com.example.feign.clients.UserClient;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId){
        //1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.用Feign远程调用
        User user = userClient.FeignById(order.getUserId());
        order.setUser(user);
        return order;
    }

//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        // 2.利用RestTemplate发起HTTP请求，查询用户
//        // 2.1 url路径
//        // 2.2 发送http请求，实现远程调用
//        String url="http://userservice/user/"+order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
//        //3.封装User到Order
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }
}

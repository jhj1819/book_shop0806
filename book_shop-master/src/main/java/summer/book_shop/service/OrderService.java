package summer.book_shop.service;

import org.springframework.stereotype.Service;
import summer.book_shop.domain.Order;

import summer.book_shop.domain.dto.OrderRequestDto;
import summer.book_shop.repository.OrderRepository;

@Service
public class OrderService {

    private OrderRepository orderRepository;


    //주문정보 조회
    public void orderinformation(Order order) throws Exception {
        if (!orderRepository.isOrderId(order.getOrderId())) {
            throw new Exception("주문 번호를 찾을 수 없습니다.");
        }

        orderRepository.selectOrder(order.getOrderId());
    }
    //주문 배송지 수정
    public void NewShippingAddress(String orderCode, String newAddress) throws Exception {

        System.out.println("배송지 업데이트가 완료되었습니다.");

        orderRepository.updateshippingAddress(orderCode, newAddress);
    }

    //아이디별 총 주문건수
    public void orderOrdercnt(String orderId) throws Exception {
        if (!orderRepository.isOrderId(orderId)) {
            throw new Exception("주문자를 찾을 수 없습니다.");
        }
        int orderCount = orderRepository.totalorder(orderId);
        System.out.println("회원님의 총주문 건수: " + orderCount);
    }

    // 주문 상태
    public void orderState(Order order) {
        if (orderRepository.save(order) == 1) {
            order.setStatus(true);
            System.out.println("주문 접수 완료되었습니다.");
        }

        if (order.isStatus() == false) {
            order.setStatus(false);
            System.out.println("주문 접수에 오류가 발생했습니다.");
        }
    }
    //주문 취소
    public void cancelOrder(String orderCode){
        if(orderRepository.orderdelete(orderCode) == 1){
            System.out.println("주문취소 되었습니다.");
        }
        if(orderRepository.orderdelete(orderCode) == 0){
            System.out.println("주문취소 실패하였습니다.");
        }

    }
}
package br.com.shifter.enpoint

import br.com.shifter.OrderManagementGrpc
import br.com.shifter.OrderService
import br.com.shifter.model.repository.OrderRepository
import com.google.protobuf.StringValue
import io.grpc.stub.StreamObserver
import javax.inject.Singleton

@Singleton
class OrderManagementEndpoint(
        private val orderRepository: OrderRepository
) : OrderManagementGrpc.OrderManagementImplBase() {
    override fun getOrder(request: StringValue?, responseObserver: StreamObserver<OrderService.Order>) {
        orderRepository.findOrders(request!!.value).forEach { responseObserver.onNext(OrderService.Order.newBuilder().setId(it).build()) }
        responseObserver.onCompleted()
    }

    override fun submit(request: StringValue?, responseObserver: StreamObserver<StringValue>) {
        responseObserver.onCompleted()
    }
}
package com.deviniciative.services;

import com.deviniciative.grpcFortune.FortuneGrpc.FortuneImplBase;
import com.deviniciative.grpcFortune.FortuneMessage;
import com.deviniciative.grpcFortune.FortuneReply;
import com.deviniciative.grpcFortune.FortuneReply.Builder;
import com.deviniciative.grpcFortune.FortuneRequest;
import io.grpc.stub.StreamObserver;

public class FortuneService extends FortuneImplBase {

    @Override
    public void callFortune (FortuneRequest request, StreamObserver<FortuneReply> responseObserver) {
        Builder response = FortuneReply.newBuilder();

        String caller = request.getName();
        FortuneMessage fortuneMessage = new FortuneMessage();
        StringBuilder resposta = new StringBuilder();
        resposta.append(caller);
        resposta.append(" : ");
        resposta.append(fortuneMessage.retornaFrase());
        response.setMessage(resposta.toString());
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

}

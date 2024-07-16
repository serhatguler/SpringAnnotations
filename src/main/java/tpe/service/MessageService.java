package tpe.service;

import tpe.domain.Message;

public interface MessageService {

    void sendMessage(Message message);
    void savedMessage(Message message);
}

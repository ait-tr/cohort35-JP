package homework.homework_5.Task1;

public class MessageService {
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void printMessage() {
        System.out.println(messageRepository.getMessage());
    }
}

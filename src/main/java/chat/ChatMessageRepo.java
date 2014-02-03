package chat;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Klaus Bayrhammer
 */
public interface ChatMessageRepo extends CrudRepository<ChatMessage, Long> {

}

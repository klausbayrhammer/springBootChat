package chat;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Klaus Bayrhammer
 */
@Controller
public class ChatController {

    @Autowired
    private ChatMessageRepo chatMessageRepo;

    @RequestMapping(value="/chat", method = {RequestMethod.GET})
    public @ResponseBody
    List<ChatMessage> initialChatList() {
        return Lists.newArrayList(chatMessageRepo.findAll());
    }

    @RequestMapping(value="/chat", method = {RequestMethod.POST})
    public @ResponseBody
    List<ChatMessage> chat(@RequestBody ChatMessage message) {
        chatMessageRepo.save(message);
        return Lists.newArrayList(chatMessageRepo.findAll());
    }
}

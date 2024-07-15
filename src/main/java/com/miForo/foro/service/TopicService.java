import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    public Topic findById(Long id) {
        return topicRepository.findById(id).orElse(null);
    }

    @Transactional
    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }

    @Transactional
    public Topic update(Long id, Topic updatedTopic) {
        if (topicRepository.existsById(id)) {
            updatedTopic.setId(id);
            return topicRepository.save(updatedTopic);
        }
        return null;
    }

    @Transactional
    public void deleteById(Long id) {
        topicRepository.deleteById(id);
    }
}

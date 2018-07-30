package dulk.baseMan.service;

import dulk.baseMan.dao.DemoDao;
import dulk.baseMan.pojo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DemoService.
 *
 * @author Dulk
 * @version 20180730
 * @date 2018/7/30
 */
@Service
public class DemoService {

    @Autowired
    private DemoDao demoDao;

    public Girl findById(Integer id) {
        return demoDao.findById(id);
    }

}

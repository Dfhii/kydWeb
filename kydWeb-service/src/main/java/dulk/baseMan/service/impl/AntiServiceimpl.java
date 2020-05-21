package dulk.baseMan.service.impl;


import dulk.baseMan.mapper.AntiMapper;
import dulk.baseMan.service.AntiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class AntiServiceimpl implements AntiService {
    @Autowired
    AntiMapper antiMapper;

    @Override
    public String findProduct(String serial) {
        return antiMapper.findProduct(serial);
    }
}

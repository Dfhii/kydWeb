package dulk.baseMan.service;

import java.util.List;
import java.util.Map;

public interface InviteService {

    Map<String,String> findInviteById(int id);

    List<Map<String,String>> iteBySchool(int hireType);
}

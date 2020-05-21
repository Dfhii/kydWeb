package dulk.baseMan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface NewsService {
    List<Map<String,String>> findNewsTitle();

    HashMap<String,String> findNewsContents(int id);

    List<Map<String,String>> findTitleByHome();
}

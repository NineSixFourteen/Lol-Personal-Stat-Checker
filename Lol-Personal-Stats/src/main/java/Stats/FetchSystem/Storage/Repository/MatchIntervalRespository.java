package Stats.FetchSystem.Storage.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;

@Repository
public interface MatchIntervalRespository extends  CrudRepository<MatchInterval,Integer> {
    
    List<MatchInterval> findByMatchIDAndName(String id, String Name);
    List<MatchInterval> findByMatchID(String id);
}

package Stats.FetchSystem.Storage.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;

@Repository
public interface MatchIntervalRespository extends  CrudRepository<MatchInterval,Integer> {
    
}

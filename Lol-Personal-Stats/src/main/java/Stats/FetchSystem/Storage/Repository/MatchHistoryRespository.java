package Stats.FetchSystem.Storage.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Stats.FetchSystem.Storage.Entitys.MatchHistory;
@Repository
public interface MatchHistoryRespository extends CrudRepository<MatchHistory,Integer> {
    
}

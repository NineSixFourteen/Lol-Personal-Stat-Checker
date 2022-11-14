package Stats.BackEnd.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Stats.BackEnd.Entitys.MatchHistory;
@Repository
public interface MatchHistoryRespository extends CrudRepository<MatchHistory,Integer> {

    List<MatchHistory> findByMatchID(String Matchid);
    
}

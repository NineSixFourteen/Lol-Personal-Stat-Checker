package Stats.FetchSystem.Storage.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Stats.FetchSystem.Storage.Entitys.MatchOverall1;

@Repository
public interface MatchOverall1Respository extends CrudRepository<MatchOverall1,Integer> {
    
}

package Stats.FetchSystem.Storage.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Stats.FetchSystem.Storage.Entitys.MatchOverall2;

@Repository
public interface MatchOverall2Respository extends  CrudRepository<MatchOverall2,Integer> {
    
}

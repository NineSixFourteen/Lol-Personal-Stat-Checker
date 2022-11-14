package Stats.BackEnd.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Stats.BackEnd.Entitys.MatchOverall2;

@Repository
public interface MatchOverall2Respository extends  CrudRepository<MatchOverall2,Integer> {
    List<MatchOverall2> findByMatchIDAndName(String Matchid, String name);
    List<MatchOverall2> findByMatchID(String id);
    List<MatchOverall2> findByName(String name);
}

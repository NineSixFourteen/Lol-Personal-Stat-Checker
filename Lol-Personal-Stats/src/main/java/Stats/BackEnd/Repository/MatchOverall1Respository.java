package Stats.BackEnd.Repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Stats.BackEnd.Entitys.MatchOverall1;

@Repository
public interface MatchOverall1Respository extends CrudRepository<MatchOverall1,Integer> {
    List<MatchOverall1> findByMatchIDAndName(String Matchid, String name);
    List<MatchOverall1> findByMatchID(String id);
    List<MatchOverall1> findByName(String name);
    List<MatchOverall1> findByChampion(String name);
    List<MatchOverall1> findByPosition(String name);
    List<MatchOverall1> findByPositonAndName(String pos, String name);
}

package Stats.FetchSystem.Storage.Entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class test {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String name;

  public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

private String email;

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}
}
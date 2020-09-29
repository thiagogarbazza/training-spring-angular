import java.time.LocalDate;
import java.util.ArrayList;

public class PessoaService {

  public static void main(String[] args) {
    Pessoa pessoa = Pessoa.builder()
      .nome("Thiag")
      .dataNascimeto(LocalDate.of(1984,1,1))
      .build();

    System.out.println(pessoa);
  }
}

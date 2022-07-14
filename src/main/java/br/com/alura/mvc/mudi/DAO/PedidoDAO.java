package br.com.alura.mvc.mudi.DAO;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;

@Repository // as classes que herdam de Repository são consideradas como DAO,
public interface PedidoDAO extends JpaRepository<Pedido, Long> {

}

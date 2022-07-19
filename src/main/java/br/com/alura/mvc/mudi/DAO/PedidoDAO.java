package br.com.alura.mvc.mudi.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

@Repository // as classes que herdam de Repository são consideradas como DAO,
public interface PedidoDAO extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatus(StatusPedido status);

    @Query("select p from Pedido p where p.user.username= :username")
    Object findAllByUsuario(@Param("username") String username);
}

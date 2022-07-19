package br.com.alura.mvc.mudi.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.mudi.DAO.PedidoDAO;
import br.com.alura.mvc.mudi.model.StatusPedido;

@Controller
public class HomeController {

        @Autowired // significa que o spring vai instanciar o objeto automaticamente
        private PedidoDAO pedidoDAO;

        @GetMapping("/")
        public ModelAndView main(Principal principal) {

                ModelAndView mv = new ModelAndView("home");
                mv.addObject("pedidos", pedidoDAO.findAllByUsuario(principal.getName()));
                mv.addObject("status", "todos");
                return mv;
        }

        @GetMapping("/{status}")
        public ModelAndView status(@PathVariable("status") String status, Principal principal) {
                ModelAndView mv = new ModelAndView("home");

                try {
                        mv.addObject("pedidos", pedidoDAO.findByStatus(StatusPedido.valueOf(status.toUpperCase())));
                        mv.addObject("status", status);

                } catch (Exception e) {
                        mv.addObject("pedidos", pedidoDAO.findAllByUsuario(principal.getName()));
                        mv.addObject("status", "todos");
                }
                return mv;
        }

}

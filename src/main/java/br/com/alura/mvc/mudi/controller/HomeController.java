package br.com.alura.mvc.mudi.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.mudi.DAO.PedidoDAO;
import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {

        @Autowired // significa que o spring vai instanciar o objeto automaticamente
        private PedidoDAO pedidoDAO;

        @GetMapping("/")
        public ModelAndView main() {
                ModelAndView mv = new ModelAndView("home");
                mv.addObject("pedidos", pedidoDAO.findAll());
                return mv;
        }

}

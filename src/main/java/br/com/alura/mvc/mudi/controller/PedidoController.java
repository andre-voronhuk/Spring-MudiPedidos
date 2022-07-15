package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.mudi.DAO.PedidoDAO;
import br.com.alura.mvc.mudi.dto.RequestNovoProduto;
import br.com.alura.mvc.mudi.model.Pedido;

@Controller
@RequestMapping("pedido")
public class PedidoController {
    @Autowired
    private PedidoDAO pedidoDAO;

    @GetMapping("formulario")
    public String formulario(RequestNovoProduto produto) {

        return "pedido/formulario";
    }

    @PostMapping("novo")
    public ModelAndView novo(@Valid RequestNovoProduto produto, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("pedido/formulario");
            return mv;
        }

        ModelAndView mv = new ModelAndView("redirect:/");
        Pedido pedido = produto.toPedido();
        pedidoDAO.save(pedido);
        System.out.println("Salvando novo pedido " + produto.getNome());
        return mv;
    }

}

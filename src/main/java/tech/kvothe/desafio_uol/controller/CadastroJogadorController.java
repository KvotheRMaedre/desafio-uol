package tech.kvothe.desafio_uol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.kvothe.desafio_uol.model.GrupoCodinome;
import tech.kvothe.desafio_uol.model.Jogador;
import tech.kvothe.desafio_uol.service.JogadorService;

@Controller
@RequestMapping("cadastro-jogador")
public class CadastroJogadorController {
    private final JogadorService jogadorService;

    public CadastroJogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping
    public String cadastrarJogador(@ModelAttribute Jogador jogador) {
        try {
            jogadorService.registrarJogador(jogador);
            return "redirect:/cadastro-jogador";
        } catch (Exception e) {
            return "redirect:/cadastro-jogador";
        }
    }

    @GetMapping
    public String paginaCadastroogador(Model model) {
        model.addAttribute("jogador", new Jogador(null,null,null,null,null));
        model.addAttribute("gruposCodinomes", GrupoCodinome.values());
        return "cadastro_jogador";
    }
}

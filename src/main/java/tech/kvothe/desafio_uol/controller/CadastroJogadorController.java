package tech.kvothe.desafio_uol.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.kvothe.desafio_uol.exception.GrupoCodinomeIndisponivelException;
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
    public String cadastrarJogador(@ModelAttribute @Valid Jogador jogador, BindingResult result, Model model) throws Exception {
        if (result.hasErrors()) {
            return getViewAndModel(model, jogador);
        }

        try {
            jogadorService.registrarJogador(jogador);
            return "redirect:/listagem-jogadores";
        } catch (GrupoCodinomeIndisponivelException e) {
            result.rejectValue("grupoCodinome", "grupoCodinomeIndisponivel", e.getMessage());
            return getViewAndModel(model, jogador);
        }

    }

    @GetMapping
    public String paginaCadastroogador(Model model) {
        return getViewAndModel(model, new Jogador(null,null,null,null,null));
    }

    private static String getViewAndModel(Model model, Jogador jogador) {
        model.addAttribute("jogador", jogador);
        model.addAttribute("gruposCodinomes", GrupoCodinome.values());
        return "cadastro_jogador";
    }
}

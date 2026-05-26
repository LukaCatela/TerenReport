package hr.fipu.terenreport.controller;

import hr.fipu.terenreport.model.Kampanja;
import hr.fipu.terenreport.service.KampanjaService;
import hr.fipu.terenreport.service.PointService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/kampanje")
public class KampanjaController {

    private final KampanjaService kampanjaService;
    private final PointService pointService;

    public KampanjaController(KampanjaService kampanjaService, PointService pointService) {
        this.kampanjaService = kampanjaService;
        this.pointService = pointService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("kampanje", kampanjaService.getAll());
        return "kampanje";
    }

    @GetMapping("/nova")
    public String novaForm(Model model) {
        model.addAttribute("kampanja", new Kampanja());
        return "kampanja-forma";
    }

    @PostMapping("/nova")
    public String spremi(@ModelAttribute Kampanja kampanja) {
        kampanjaService.save(kampanja);
        return "redirect:/kampanje";
    }

    @GetMapping("/{id}")
    public String detalji(@PathVariable Long id, Model model) {
        Kampanja kampanja = kampanjaService.getById(id);
        model.addAttribute("kampanja", kampanja);
        model.addAttribute("points", pointService.getByKampanja(kampanja));
        return "kampanja-detalji";
    }
}

package hr.fipu.terenreport.controller;

import hr.fipu.terenreport.model.Point;
import hr.fipu.terenreport.model.VrstaTocke;
import hr.fipu.terenreport.service.KampanjaService;
import hr.fipu.terenreport.service.PointService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/points")
public class PointController {

    private final PointService pointService;
    private final KampanjaService kampanjaService;

    public PointController(PointService pointService, KampanjaService kampanjaService) {
        this.pointService = pointService;
        this.kampanjaService = kampanjaService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("points", pointService.getAll());
        return "points";
    }

    @GetMapping("/novi")
    public String noviForm(Model model) {
        model.addAttribute("point", new Point());
        model.addAttribute("kampanje", kampanjaService.getAll());
        model.addAttribute("vrste", VrstaTocke.values());
        model.addAttribute("svePoints", pointService.getAll());
        return "point-forma";
    }

    @PostMapping("/novi")
    public String spremi(@ModelAttribute Point point,
                         @RequestParam(required = false) Long kampanjaId,
                         @RequestParam(required = false) Long odTockeId,
                         @RequestParam(required = false) Long doTockeId) {
        if (kampanjaId != null) {
            point.setKampanja(kampanjaService.getById(kampanjaId));
        }
        if (odTockeId != null) {
            point.setOdTocke(pointService.getById(odTockeId));
        }
        if (doTockeId != null) {
            point.setDoTocke(pointService.getById(doTockeId));
        }
        pointService.save(point);

        if (kampanjaId != null) {
            return "redirect:/kampanje/" + kampanjaId;
        }
        return "redirect:/points";
    }
}

package com.pablozoani.webapp.layers.business.controller;

import com.pablozoani.webapp.layers.business.datatransferobject.AcademyDTO;
import com.pablozoani.webapp.layers.business.service.AcademyService;
import com.pablozoani.webapp.layers.model.Academy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@Slf4j
@Controller
public class AcademyController {

    public static final String ACADEMY_URL = "academy/academy";

    private final AcademyService academyService;

    @Autowired
    public AcademyController(AcademyService academyService) {
        this.academyService = academyService;
    }

    @GetMapping("/academy")
    public String getAcademy(Model model) {

        log.debug("getAcademy()");

        model.addAttribute("academy", new AcademyDTO());

        model.addAttribute("academies", academyService.findAll());

        return ACADEMY_URL;
    }

    @PostMapping("/academy/new")
    public String saveAcademy(@Valid @ModelAttribute AcademyDTO academyDTO) {

        log.debug("saveAcademy()");

        if (academyService.existsByName(academyDTO.getName())) {

            throw new AcademyAlreadyExistsException();
        }
        academyService.saveAcademy(academyDTO);

        return "redirect:/academy";
    }

    @GetMapping("/academy/{id}/delete")
    public String deleteAcademy(@PathVariable String id) {

        log.debug("deleteAcademy()", id);

        academyService.deleteById(Long.valueOf(id));

        return "redirect:/academy";
    }

    @GetMapping("/academy/{id}/update")
    public String updateAcademy(@PathVariable String id, Model model) {

        log.debug("updateAcademy()");

        Academy academy = academyService.findById(Long.valueOf(id));

        AcademyDTO academyDTO = AcademyDTO.toDTO(academy);

        model.addAttribute("academy", academyDTO);

        model.addAttribute("academies", academyService.findAll());

        return ACADEMY_URL;
    }

    @GetMapping("/academy/findByNameContaining")
    public String findByNameContaining(@RequestParam("academy_name") String name, Model model) {

        log.debug("findByNameContaining() -> {}", name);

        Set<Academy> academies = academyService.findByNameContaining(name);

        model.addAttribute("academies", academies);

        model.addAttribute("academy", new AcademyDTO());

        return ACADEMY_URL;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    static class AcademyAlreadyExistsException extends RuntimeException {

        public AcademyAlreadyExistsException() {
            super("academy name must be unique");
        }
    }
}

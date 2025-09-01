package com.example.demo.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.patient;
import com.example.demo.repository.PatientRepository;

@CrossOrigin(origins = {"http://localhost:5173/"}, methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/clinic")
public class defaultController {
    private final PatientRepository patientRepository;

    public defaultController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/getAllPatients")
    public List<patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @PostMapping("/createPatient")
    public String createPatient(@RequestBody patient newPatient) {
        patientRepository.save(newPatient);
        return "Patient Saved";
    }
}

package com.example.demo.servicios;
import java.sql.Timestamp;
import java.util.List;

import com.example.demo.entities.*;
import com.example.demo.servicios.apoyos.DomainService;
import com.example.demo.servicios.apoyos.ProjectionDomainService;

public interface LanguageService extends ProjectionDomainService<Language, Integer> {
}

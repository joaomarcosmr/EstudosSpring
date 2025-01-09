package dev.java10x.projetoapi.Ninjas;

import org.springframework.stereotype.Service;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
}

package repositories.impl;

import frunivangers.jpv.Symbole;
import repositories.SymboleFactory;
import repositories.SymboleTypeRepository;
import repositories.VarianteRepository;

public class SymboleFactoryImpl implements SymboleFactory {

    private final SymboleTypeRepository symboleTypeRepository;
    private final VarianteRepository varianteRepository;

    public SymboleFactoryImpl(SymboleTypeRepository symboleTypeRepository, VarianteRepository varianteRepository) {
        this.symboleTypeRepository = symboleTypeRepository;
        this.varianteRepository = varianteRepository;
    }

    @Override
    public Symbole createSymbole(int symboleTypeId, int varianteId) {
        return new Symbole(this.symboleTypeRepository.getSymboleType(symboleTypeId), this.varianteRepository.getVariante(varianteId));
    }
}

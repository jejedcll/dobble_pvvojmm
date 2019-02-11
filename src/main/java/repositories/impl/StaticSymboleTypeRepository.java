package repositories.impl;

import frunivangers.jpv.SymboleType;
import repositories.SymboleTypeRepository;

import java.util.HashMap;
import java.util.Map;

public class StaticSymboleTypeRepository implements SymboleTypeRepository {

    Map<Integer, SymboleType> symboleTypeMap;

    public StaticSymboleTypeRepository() {
        this.symboleTypeMap = new HashMap<>();
    }

    @Override
    public SymboleType getSymboleType(int id) {
        if(symboleTypeMap.containsKey(id)){
            return symboleTypeMap.get(id);
        }else{
            SymboleType symboleType = new SymboleType(id);
            symboleTypeMap.put(id, symboleType);
            return symboleType;
        }
    }
}

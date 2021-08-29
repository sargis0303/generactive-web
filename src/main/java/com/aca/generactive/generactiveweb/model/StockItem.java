package com.aca.generactive.generactiveweb.model;

import com.aca.generactive.generactiveweb.util.idgenerator.IdGenerator;
import com.aca.generactive.generactiveweb.util.idgenerator.Type;

public class StockItem extends Item {

    public StockItem() {
        this.setId(IdGenerator.getNext(Type.ITEM));
    }

    public StockItem(int id, int basePrice, String name) {
        super(id, basePrice, name);
    }

    @Override
    public int calculatePrice(Configuration configuration) {
        return getBasePrice() * configuration.getResolution().getCoefficient();
    }
}

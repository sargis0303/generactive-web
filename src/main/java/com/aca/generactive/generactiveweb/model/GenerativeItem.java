package com.aca.generactive.generactiveweb.model;

import com.aca.generactive.generactiveweb.util.idgenerator.IdGenerator;
import com.aca.generactive.generactiveweb.util.idgenerator.Type;

public class GenerativeItem extends Item {

    public GenerativeItem() {
        this.setId(IdGenerator.getNext(Type.ITEM));
    }

    private double complexity = 1;

    public GenerativeItem(int id, int basePrice, String name) {
        super(id, basePrice, name);
    }

    public double getComplexity() {
        return complexity;
    }

    public void setComplexity(double complexity) {
        this.complexity = complexity;
    }

    @Override
    public int calculatePrice(Configuration configuration) {
        return (int) (getBasePrice() * complexity * configuration.getResolution().getCoefficient());
    }
}

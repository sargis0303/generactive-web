package com.aca.generactive.generactiveweb.mock;

import com.aca.generactive.generactiveweb.model.Configuration;
import com.aca.generactive.generactiveweb.model.Resolution;

import java.util.Random;

public final class ConfigurationMock {

    public static Configuration getConfiguration() {
        return new Configuration(Resolution.values()[new Random().nextInt(Resolution.values().length - 1)]);
    }

    private ConfigurationMock() {

    }
}

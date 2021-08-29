package com.aca.generactive.generactiveweb.mock;

import com.aca.generactive.generactiveweb.model.Group;
import com.aca.generactive.generactiveweb.util.idgenerator.IdGenerator;
import com.aca.generactive.generactiveweb.util.idgenerator.Type;
import com.aca.generactive.generactiveweb.util.namegenerator.Casing;
import com.aca.generactive.generactiveweb.util.namegenerator.NameGen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GroupMock {

    private static final NameGen NAME_GEN = NameGen.start()
            .withSeparator(" ")
            .withCasing(Casing.CAPITALIZE)
            .adjective()
            .noun();

    public static Group getGroup() {
        return new Group(IdGenerator.getNext(Type.GROUP), NAME_GEN.get());
    }

    public static List<Group> getGroupsHierarchy() {
        Group group1 = getGroup();
        Group group2 = getGroup();
        Group group3 = getGroup();
        Group group4 = getGroup();
        Group group5 = getGroup();
        Group group6 = getGroup();

        group1.addSubGroup(group2);
        group2.addSubGroup(group3);

        group4.addSubGroup(group5);
        group5.addSubGroup(group6);

        return Arrays.asList(group1,
                group2,
                group3,
                group4,
                group5,
                group6);
    }

    public static List<Group> getGroups(int count) {
        List<Group> rv = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            rv.add(getGroup());
        }

        return rv;
    }

    private GroupMock() {

    }
}

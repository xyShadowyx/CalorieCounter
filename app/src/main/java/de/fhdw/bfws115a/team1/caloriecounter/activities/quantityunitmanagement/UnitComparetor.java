package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;

import java.util.Comparator;

/**
 * @author Florian Obladen.
 */
public class UnitComparetor implements Comparator<Unit> {
    @Override
    public int compare(Unit unit, Unit t1) {
        return unit.getName().compareTo(t1.getName());
    }
}

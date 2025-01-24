package org.example.service;

public class CapimonTypeDmg {
    public static int calculateDamage (String attackerType, String targetType, boolean isSpecial){
        int baseDamage = isSpecial ? 25 : 15;
        int typeMultiplier = getTypeMultiplier(attackerType,targetType);
        return baseDamage * typeMultiplier;
    }
    private static int getTypeMultiplier (String attackType, String targetType){
        if ( attackType.equals("agua") &&  targetType.equals("fuego")) {
            return 2;
        } else if ( attackType.equals("fuego") && targetType.equals("planta")){
            return 2;
        } else if ( attackType.equals("planta") &&  targetType.equals("agua")){
            return 2;
        } else if (attackType.equals("electrico") && targetType.equals("oscuro")) {
            return 2;
        } else if ( attackType.equals("oscuro") && targetType.equals("agua") || attackType.equals("oscuro") && targetType.equals("fuego") || attackType.equals("oscuro") && targetType.equals("planta")) {
            return 2;
        } else if (attackType.equals(targetType)) {
            return 1;
        }
        return 1;
    }
}

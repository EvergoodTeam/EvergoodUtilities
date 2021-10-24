package evergoodteam.evergoodutilities.util;


public class GetName {

    public static String type(String input){
        String type = input;

        type = type.split("_")[0].replaceAll("evergoodutilities:", "").replaceAll("_", "");

        if(type.contains("icon")){
            return null;
        }

        if(type.contains("dirty")){
            type = type.replaceAll("dirty", "Dirty");
        }

        return type;
    }

    public static String metal(String input){
        StringBuilder name = new StringBuilder(input);

        name.setCharAt(name.indexOf("_") + 1, Character.toUpperCase(name.charAt(name.indexOf("_") + 1)));
        String metal = name.toString().split("_")[1].replaceAll("evergoodutilities:", "").replaceAll("_", "");

        if (metal.contains("Astralstarmetal")){
            metal = metal.replaceAll("Astralstarmetal", "AstralStarmetal");
        }

        return metal;
    }

    public static String oreDict(String input){

        if(type(input) == null){
            return null;
        }
        else{
            return type(input)+metal(input);
        }
    }

    public static String metalUncapital(String input){

        String metal = metal(input);

        StringBuilder name = new StringBuilder(metal);
        name.setCharAt(0, Character.toUpperCase(name.charAt(0)));
        return name.toString();
    }
}

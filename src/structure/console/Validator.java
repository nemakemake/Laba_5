package src.structure.console;

public class Validator {
    public Validator() {
    }

    public boolean checkMinPoint(String arg){
        try {
            if (arg == null) {return true;}
            int value = Integer.parseInt(arg);
            return value > 0;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public boolean checkName(String arg){
        return !(arg.isBlank());
    }

    public boolean checkCoordinates(String arg){
        try{
            String[] args = arg.split(" ");
            Integer.parseInt(args[0]);
            Integer.parseInt(args[1]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }

    public boolean checkDifficulty(String arg){
        try{
            int num = Integer.parseInt(arg);
            return 0 < num && num < 5;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public boolean checkDiscipline(String arg){
        try{
            if (arg.isBlank()){ return false;}
            String[] args = arg.split(" ");
            if (args.length >1) {
                Integer.parseInt(args[1]);
            }
            return true;
        } catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
            return false;
        }
    }
}
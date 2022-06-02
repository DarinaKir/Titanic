import java.util.Locale;

public class Passenger {

    private int passengerId;
    private boolean survived;
    private int pClass;
    private String name;
    private String sex;
    private double age;
    private int sibSp;
    private int parch;
    private String ticket;
    private double fare;
    private String cabin;
    private char embarked;

    public Passenger(String text) {
        String[] dataItem = text.split(",");

        this.passengerId = Integer.parseInt(dataItem[0]);
        this.survived = (Integer.parseInt(dataItem[1]) == 1);
        this.pClass = Integer.parseInt(dataItem[2]);
        this.name = dataItem[3] + "," + dataItem[4];
        this.sex = dataItem[5];
        if (dataItem[6].equals("")) {
            this.age = -1;
        } else {
            this.age = Double.parseDouble(dataItem[6]);
        }
        this.sibSp = Integer.parseInt(dataItem[7]);
        this.parch = Integer.parseInt(dataItem[8]);
        this.ticket = dataItem[9];
        this.fare = Double.parseDouble(dataItem[10]);
        this.cabin = dataItem[11];
        if (dataItem.length == 13) {
            this.embarked = dataItem[12].charAt(0);
        }
    }

    public String getFormattedName() {
        String fullName = "";
        String[] split1 = this.name.split(",");
        String[] split2 = split1[1].split("\\.");
        fullName = split2[1].substring(1, split2[1].length() - 1) + " " + split1[0].substring(1);
        return fullName;
    }

    public String toString() {
        return
                +passengerId +
                        "," + (survived ? "1" : "0") +
                        "," + pClass +
                        "," + getFormattedName() +
                        "," + sex +
                        "," + ((age == -1) ? "" : age) +
                        "," + sibSp +
                        "," + parch +
                        "," + ticket +
                        "," + fare +
                        "," + cabin +
                        "," + embarked + "\n";
    }

    public boolean isIdInRange(int min, int max) {
        boolean isInRange = false;
        if (this.passengerId >= min && this.passengerId <= max) {
            isInRange = true;
        }
        return isInRange;
    }

    public boolean isNameExist(String name) {
        boolean isCorrect = false;
        if (getFormattedName().contains(name)) {
            isCorrect = true;
        }
        return isCorrect;
    }

    public boolean isSameClass(int pClass) {
        boolean isSame = false;
        if (pClass == this.pClass || pClass == 0) {
            isSame = true;
        }
        return isSame;
    }

    public boolean isSameSex(String sex) {
        boolean isSame = false;
        if (this.sex.equals(sex.toLowerCase(Locale.ROOT)) || sex.equals("All")) {
            isSame = true;
        }
        return isSame;
    }

    public boolean isSameSibSp(int sibSp) {
        boolean isSame = false;
        if (sibSp == this.sibSp || sibSp == -1) {
            isSame = true;
        }
        return isSame;
    }

    public boolean isSameParch(int parch) {
        boolean isSame = false;
        if (parch == this.parch || parch == -1) {
            isSame = true;
        }
        return isSame;
    }

    public boolean isSameTicketNumber(int ticket) {
        boolean isSame = false;
        if (ticket != -1){
            String ticketNumber = "" + ticket;
            isSame = (this.ticket.contains(ticketNumber));
        } else isSame = true;
//        int thisTicket;
//        try {
//            if (this.ticket.contains(" ")){
//                String[] splitTicket = this.ticket.split(" ");
//                thisTicket = Integer.parseInt(splitTicket[splitTicket.length - 1]);
//            }else {
//                thisTicket = Integer.parseInt(this.ticket);
//            }
//        } catch (NumberFormatException e) {
//            thisTicket = -1;
//        }
//        if (ticket == thisTicket || ticket == -1) {
//            isSame = true;
//        }
        return isSame;
    }

    public boolean isFareInRange(int min, int max) {
        boolean isInRange = false;
        if (this.fare >= min && this.fare <= max) {
            isInRange = true;
        }
        return isInRange;
    }

    public boolean isSameCabin(int cabin) {
        boolean isSame = false;
        if (cabin!=-1){
            String cabinNumber = ""+cabin;
            isSame = (this.cabin.contains(cabinNumber));
        }else isSame = true;
//        String cabinNumber = "";
//        for (int i = 1; i < this.cabin.length(); i++) {
//            if (Character.isDigit(this.cabin.charAt(i))) {
//                cabinNumber += this.cabin.charAt(i);
//            } else {
//                break;
//            }
//        }
//        int cabinNumberInt;
//        try {
//            cabinNumberInt = Integer.parseInt(cabinNumber);
//        }catch (NumberFormatException e) {
//            cabinNumberInt = -1;
//        }
//
//        if (cabin == cabinNumberInt || cabin == -1) {
//            isSame = true;
//        }
        return isSame;
    }

    public boolean isSameEmbarked(char embarked) {
        boolean isSame = false;
        if ((embarked == this.embarked) || embarked == 'A') {
            isSame = true;
        }
        return isSame;
    }

    public boolean isAgeInRange(int min, int max) {
        boolean isInRange = false;
        if (this.age >= min && this.age <= max) {
            isInRange = true;
        }
        return isInRange;
    }


    public boolean isSurvived() {
        return survived;
    }

    public boolean hasRelative(){
        return ((this.parch + this.sibSp) > 0);
    }
}
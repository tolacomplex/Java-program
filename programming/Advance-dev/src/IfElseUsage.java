
public class IfElseUsage {

    public static void main(String[] args) {
        int month = 12;
        String season;

        // if ((month == 12) || (month == 1) || (month == 2)) {
        //     season = "Winter";
        // } else if ((month == 3) || (month == 4) || (month == 5)) {
        //     season = "Spring";
        // } else if ((month == 6) || (month == 7) || (month == 8)) {
        //     season = "Summer";
        // } else if ((month == 9) || (month == 10) || (month == 11)) {
        //     season = "Autumn";
        // } else {
        //     season = "Bogus Month";
        // }
        // System.out.println("December is the " + season);
        // for (int i = 0; i <= 10; i++) {
        //     System.out.print(i);
        // }
        switch (month) {
            case 12, 1, 2:
                season = "Winter";
                break;
            case 3, 4, 5:
                season = "Spring";
                break;
            case 6, 7, 8:
                season = "Summer";
                break;
            case 9, 10, 11:
                season = "Autumn";
                break;
            default:
                season = "Bogus Month";
                break;
        }
        System.out.println("December is " + season);

    }

}

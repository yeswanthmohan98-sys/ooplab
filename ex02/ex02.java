import java.util.*;
import java.text.DecimalFormat;

public class Convertor {

    double rupee, dollar, euro, yen;
    double meter, km, miles;
    double hour, minute, second;

    Scanner sc = new Scanner(System.in);
    DecimalFormat f = new DecimalFormat("##.###");


    // Currency Conversion

    public void convertInrToEuro() {
        System.out.println("Enter amount in Rupees");
        rupee = sc.nextDouble();

        euro = rupee / 80;

        System.out.println("Euro : " + f.format(euro));
    }

    public void convertEuroToInr() {
        System.out.println("Enter amount in Euro");
        euro = sc.nextDouble();

        rupee = euro * 80;

        System.out.println("Rupees : " + f.format(rupee));
    }

    public void convertInrToDollar() {
        System.out.println("Enter amount in Rupees");
        rupee = sc.nextDouble();

        dollar = rupee / 66;

        System.out.println("Dollar : " + f.format(dollar));
    }

    public void convertDollarToInr() {
        System.out.println("Enter amount in Dollar");
        dollar = sc.nextDouble();

        rupee = dollar * 66;

        System.out.println("Rupees : " + f.format(rupee));
    }

    public void convertInrToYen() {
        System.out.println("Enter amount in Rupees");
        rupee = sc.nextDouble();

        yen = rupee / 0.61;

        System.out.println("Yen : " + f.format(yen));
    }

    public void convertYenToInr() {
        System.out.println("Enter amount in Yen");
        yen = sc.nextDouble();

        rupee = yen * 0.61;

        System.out.println("Rupees : " + f.format(rupee));
    }


    // Distance Conversion

    public void convertMeterToKm() {
        System.out.println("Enter the Meter");
        meter = sc.nextDouble();

        km = meter * 0.001;

        System.out.println("Kilometer : " + f.format(km));
    }

    public void convertKmToMeter() {
        System.out.println("Enter the Kilometer");
        km = sc.nextDouble();

        meter = km / 0.001;

        System.out.println("Meter : " + f.format(meter));
    }

    public void convertMilesToKm() {
        System.out.println("Enter the Miles");
        miles = sc.nextDouble();

        km = miles * 1.6093;

        System.out.println("Kilometer : " + f.format(km));
    }

    public void convertKmToMiles() {
        System.out.println("Enter the Kilometer");
        km = sc.nextDouble();

        miles = km / 1.6093;

        System.out.println("Miles : " + f.format(miles));
    }


    // Time Conversion

    public void convertHourToMinute() {
        System.out.println("Enter the Hour");
        hour = sc.nextDouble();

        minute = hour * 60;

        System.out.println("Minutes : " + f.format(minute));
    }

    public void convertMinuteToHour() {
        System.out.println("Enter the Minute");
        minute = sc.nextDouble();

        hour = minute / 60;

        System.out.println("Hours : " + f.format(hour));
    }

    public void convertHourToSeconds() {
        System.out.println("Enter the Hour");
        hour = sc.nextDouble();

        second = hour * 3600;

        System.out.println("Seconds : " + f.format(second));
    }

    public void convertSecondsToHour() {
        System.out.println("Enter the Seconds");
        second = sc.nextDouble();

        hour = second / 3600;

        System.out.println("Hours : " + f.format(hour));
    }


    public static void main(String[] args) {

        Convertor c = new Convertor();

        int code, currency_code, distance_code, time_code;

        System.out.println("Enter the code");
        System.out.println("1: Currency");
        System.out.println("2: Distance");
        System.out.println("3: Time");

        code = c.sc.nextInt();


        if (code == 1) {

            System.out.println("Enter the Currency code");
            System.out.println("1: Euro");
            System.out.println("2: Dollar");
            System.out.println("3: Yen");

            currency_code = c.sc.nextInt();

            if (currency_code == 1) {

                c.convertInrToEuro();
                c.convertEuroToInr();

            } else if (currency_code == 2) {

                c.convertInrToDollar();
                c.convertDollarToInr();

            } else if (currency_code == 3) {

                c.convertInrToYen();
                c.convertYenToInr();

            } else {

                System.out.println("Invalid Code");
            }


        } else if (code == 2) {

            System.out.println("Enter the Distance code");
            System.out.println("1: Meter");
            System.out.println("2: Miles");

            distance_code = c.sc.nextInt();

            if (distance_code == 1) {

                c.convertMeterToKm();
                c.convertKmToMeter();

            } else if (distance_code == 2) {

                c.convertMilesToKm();
                c.convertKmToMiles();

            } else {

                System.out.println("Invalid Code");
            }


        } else if (code == 3) {

            System.out.println("Enter the Time code");
            System.out.println("1: Minutes");
            System.out.println("2: Seconds");

            time_code = c.sc.nextInt();

            if (time_code == 1) {

                c.convertHourToMinute();
                c.convertMinuteToHour();

            } else if (time_code == 2) {

                c.convertHourToSeconds();
                c.convertSecondsToHour();

            } else {

                System.out.println("Invalid Code");
            }


        } else {

            System.out.println("Invalid Code");
        }

        c.sc.close();
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//
//        List<Ride> rides = new ArrayList<>();
//        for(int i = 0; i<n; i++){
//            rides.add( new Ride(scan.nextInt(),
//                    scan.nextInt(),
//                    scan.nextInt(),
//                    scan.nextInt(),
//                    scan.next().toCharArray()[0]
//            ));
//        }

//        B(n, rides);

    }

    public static void test(){
        int n = (int) (Math.random()*10);
        List<Ride> rides = new ArrayList<>();

        for(int i = 0; i<n; i++){
            int day = (int) (Math.random()*1);
            int minute = (int) (Math.random() * 60);
            int hour = (int) (Math.random()*24);
            int id = (int) (Math.random()*10000);
            char status = rides.get(i).getStatus();
            if (status == 'A'){
                double prob = Math.random();
                if (prob<=1/3d) status = 'B';
                else if (prob>1/3d&&prob<=2/3d) status = 'S';
                else if (prob>2/3d) status = "C"
            }
            rides.add( new Ride(day,
                    hour,
                    minute,
                    id,

            ));
        }
    }

    public static class Ride{
        private int day;
        private int hour;
        private int minute;
        private int id;
        private char status;

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public char getStatus() {
            return status;
        }

        public void setStatus(char status) {
            this.status = status;
        }

        public Ride(int day, int hour, int minute, int id, char status) {
            this.day = day;
            this.hour = hour;
            this.minute = minute;
            this.id = id;
            this.status = status;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Ride)) return false;

            Ride ride = (Ride) o;

            if (day != ride.day) return false;
            if (hour != ride.hour) return false;
            if (minute != ride.minute) return false;
            if (id != ride.id) return false;
            return status == ride.status;
        }

        @Override
        public int hashCode() {
            int result = day;
            result = 31 * result + hour;
            result = 31 * result + minute;
            result = 31 * result + id;
            result = 31 * result + (int) status;
            return result;
        }

        @Override
        public String toString() {
            return "Ride{" +
                    "day=" + day +
                    ", hour=" + hour +
                    ", minute=" + minute +
                    ", id=" + id +
                    ", status=" + status +
                    '}';
        }
    }
    public static void B(int n, List<Ride> rides){

        Collections.sort(
                rides, Comparator.comparing(Ride::getId));
        rides.sort(Comparator.comparing(Ride::getId).thenComparing(Ride::getDay).thenComparingInt(Ride::getMinute).thenComparing(Ride::getHour));

        int sum = 0;
        Ride temp_ride = null;

        for(Ride a: rides){
            if (temp_ride == null) {
                temp_ride = a;
                continue;
            }
            if (a.getStatus()=='A'){
                if (temp_ride.getId()!=a.getId()) {
                    System.out.print(sum+" ");
                    sum=0;
                }
                temp_ride = null;
            }
            else{
                int day_diff = a.getDay()-temp_ride.getDay();
                int hour_diff = a.getHour()- temp_ride.getHour();
                int minute_diff = a.getMinute()-temp_ride.getMinute();
                sum += 24*60*(day_diff)+60*(hour_diff)+(minute_diff);
            }
            temp_ride = a;
        }
        System.out.print(sum);

    }
}

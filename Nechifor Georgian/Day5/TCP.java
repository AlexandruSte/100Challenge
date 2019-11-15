import java.util.ArrayList;
import java.util.List;

public class TCP {
    private List<String> events =  new ArrayList<>();
    private List<String> states = new ArrayList<>();

    private void init() {
        events.add("APP_PASSIVE_OPEN");
        events.add("APP_ACTIVE_OPEN");
        events.add("APP_SENT");
        events.add("APP_CLOSE");
        events.add("APP_TIMEOUT");
        events.add("RCV_SYN");
        events.add("RCV_ACK");
        events.add("RCV_SYN_ACK");
        events.add("RCV_FIN");
        events.add("RCV_FIN_ACK");

        states.add("CLOSED");
        states.add("LISTEN");
        states.add("SYN_SENT");
        states.add("SYN_RCVD");
        states.add("ESTABLISHED");
        states.add("CLOSE_WAIT");
        states.add("LAST_ACK");
        states.add("FIN_WAIT_1");
        states.add("FIN_WAIT_2");
        states.add("CLOSING");
        states.add("TIME_WAIT");
    }

    private String traverse(String state, String event) {
        switch(state) {
            case "CLOSED":
                if(event.equals("APP_PASSIVE_OPEN")) return "LISTEN";
                if(event.equals("APP_ACTIVE_OPEN")) return "SYN_SENT";
                break;
            case "LISTEN":
                if(event.equals("RCV_SYN")) return "SYN_RCVD";
                if(event.equals("APP_SEND")) return "SYN_SENT";
                if(event.equals("APP_CLOSE")) return "CLOSED";
                break;
            case "SYN_RCVD":
                if(event.equals("APP_CLOSE")) return "FIN_WAIT_1";
                if(event.equals("RCV_ACK")) return "ESTABLISHED";
                break;
            case "SYN_SENT":
                if(event.equals("RCV_SYN")) return "SYN_RCVD";
                if(event.equals("RCV_SYN_ACK")) return "ESTABLISHED";
                if(event.equals("APP_CLOSE")) return "CLOSED";
                break;
            case "ESTABLISHED":
                if(event.equals("APP_CLOSE")) return "FIN_WAIT_1";
                if(event.equals("RCV_FIN")) return "CLOSE_WAIT";
                break;
            case "FIN_WAIT_1":
                if(event.equals("RCV_FIN")) return "CLOSING";
                if(event.equals("RCV_FIN_ACK")) return "TIME_WAIT";
                if(event.equals("RCV_ACK")) return "FIN_WAIT_2";
                break;
            case "CLOSING":
                if(event.equals("RCV_ACK")) return "TIME_WAIT";
                break;
            case "FIN_WAIT_2":
                if(event.equals("RCV_FIN")) return "TIME_WAIT";
                break;
            case "TIME_WAIT":
                if(event.equals("APP_TIMEOUT")) return "CLOSED";
                break;
            case "CLOSE_WAIT":
                if(event.equals("APP_CLOSE")) return "LAST_ACK";
                break;
            case "LAST_ACK":
                if(event.equals("RCV_ACK")) return "CLOSED";
                break;
            default:
                return "ERROR";
        }

        return "ERROR";
    }


    public static String traverseStates(String[] events) {
        TCP tcp = new TCP();
        tcp.init();
        String state = "CLOSED";
        String nextState = "";// initial state, always
        // Your code here!
        for(String s: events) {
            nextState = tcp.traverse(state, s);
            state = nextState;
        }
        return state;
    }
}
